package com.fil.IMTransport.kafka;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.kafka.annotation.KafkaListener;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fil.IMTransport.ImTransportApplication;
import com.fil.IMTransport.Services.BookingService;
import com.fil.IMTransport.Services.OfferService;
import com.fil.IMTransport.handler.offer.BasicOfferHandler;
import com.fil.IMTransport.object.Booking;
import com.fil.IMTransport.object.Booking.State;
import com.fil.IMTransport.object.Offer;

public class KafkaService {

	private static ObjectMapper mapper = new ObjectMapper();

	private KafkaService() {
	}

	public static void sendTripInfo(TripInfo tripInfo) {
		try {
			ImTransportApplication.kafkaTemplate.send("transport", mapper.writeValueAsString(tripInfo));
			System.out.println("Booking request sent: " + mapper.writeValueAsString(tripInfo));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	public static void askForBooking(BookingRequest request) {
		try {
			ImTransportApplication.kafkaTemplate.send("request", mapper.writeValueAsString(request));
			System.out.println("Booking request sent: " + mapper.writeValueAsString(request));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@KafkaListener(topics = "response", groupId = "transport")
	public static void listenResponse(String message) throws IOException {
		System.out.println("Received message in response: " + message);
		
		Response response = mapper.readValue(message, Response.class);
		BookingService  bookingService = new BookingService();
		List<Booking> request = bookingService.getBookingsByIdRequest(response.id);
		for(Booking booking : request) {
			if(response.accepted) {
				booking.setState(State.OK);
				bookingService.updateBooking(booking);
			}
			else {
				bookingService.deleteBooking(booking);
			}
		}
	}

	@KafkaListener(topics = "offers", groupId = "transport")
	public static void listenOffers(String message) throws IOException {
		System.out.println("Received message in offer: " + message);
		Offer offer = mapper.readValue(message, Offer.class);

		OfferService offerService = new OfferService();
		offerService.addOffer(offer);
		
		//Appel à l'algo d'Ismail
	}

	@KafkaListener(topics = "maintenance", groupId = "transport")
	public static void listenMaintenance(String message) throws IOException {
		System.out.println("Received message in maintenance: " + message);
		// Appel handleCancel
	}
	
	@XmlRootElement
	protected class Response {
		@JsonProperty("id")
		private String id;
		@JsonProperty("outcome")
		private boolean accepted;
	}
}
