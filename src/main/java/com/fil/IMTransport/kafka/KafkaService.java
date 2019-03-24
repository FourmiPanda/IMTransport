package com.fil.IMTransport.kafka;

import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fil.IMTransport.ImTransportApplication;
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
		// Récupération de l'objet en BD + màj
	}

	@KafkaListener(topics = "offers", groupId = "transport")
	public static void listenOffers(String message) throws IOException {
		System.out.println("Received message in offer: " + message);
		Offer offer = mapper.readValue(message, Offer.class);
		// add To BDD
		// appel algo pour calculer la course
	}
}
