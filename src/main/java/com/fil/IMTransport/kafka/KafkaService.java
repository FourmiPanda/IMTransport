package com.fil.IMTransport.kafka;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.SubscribableChannel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fil.IMTransport.ImTransportApplication;

public class KafkaService {

	private KafkaService() {
	}

	public static void askForBooking(BookingRequest request) {		
		ObjectMapper mapper = new ObjectMapper();
		try {
			ImTransportApplication.kafkaTemplate.send("request", mapper.writeValueAsString(request));
			System.out.println("Booking request sent: "+mapper.writeValueAsString(request));
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
	}
}
