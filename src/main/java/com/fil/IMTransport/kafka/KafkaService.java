package com.fil.IMTransport.kafka;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fil.IMTransport.ImTransportApplication;
import com.fil.IMTransport.Services.OfferService;
import com.fil.IMTransport.handler.booking.BasicBookingHandler;
import com.fil.IMTransport.handler.booking.BookingHandler;
import com.fil.IMTransport.handler.offer.BasicOfferHandler;
import com.fil.IMTransport.object.Offer;

@Service
public class KafkaService {

	private ObjectMapper mapper = new ObjectMapper();

	private BookingHandler bookingHandler = BasicBookingHandler.getInstance();

	public KafkaService() {
	}

	public void sendTripInfo(TripInfo tripInfo) {
		try {
			ImTransportApplication.kafkaTemplate.send("transport", mapper.writeValueAsString(tripInfo));
			System.out.println("Booking request sent: " + mapper.writeValueAsString(tripInfo));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	public void askForBooking(BookingRequest request) {
		try {
			ImTransportApplication.kafkaTemplate.send("request", mapper.writeValueAsString(request));
			System.out.println("Booking request sent: " + mapper.writeValueAsString(request));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@KafkaListener(topics = "response", groupId = "transport")
	public void listenResponse(String message) throws IOException {
		System.out.println("Received message in response: " + message);

		Response response = mapper.readValue(message, Response.class);
		if (response.accepted) {
			bookingHandler.handleConfirm(response.id);
		} else {
			bookingHandler.handleDeny(response.id);
		}
	}

	@KafkaListener(topics = "offers", groupId = "transport")
	public void listenOffers(String message) throws IOException {
		System.out.println("Received message in offer: " + message);
		ListOffers offers = mapper.readValue(message, ListOffers.class);

		OfferService offerService = new OfferService();
		offerService.addOffer(offers.offers);

		new BasicOfferHandler().handle(offers.offers);
	}

	@KafkaListener(topics = "maintenance", groupId = "transport")
	public void listenMaintenance(String message) throws IOException {
		System.out.println("Received message in maintenance: " + message);
		String idCanceledRequest = "";
		bookingHandler.handleCancel(idCanceledRequest);
	}

	@XmlRootElement
	protected class Response {

		@JsonProperty("id")
		private String id;
		@JsonProperty("outcome")
		private boolean accepted;
	}

	@XmlRootElement
	protected class ListOffers {

		@JsonProperty("offers")
		private List<Offer> offers;
	}
}
