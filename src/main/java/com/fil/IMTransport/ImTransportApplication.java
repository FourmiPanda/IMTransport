package com.fil.IMTransport;

import java.awt.List;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fil.IMTransport.handler.offer.BasicOfferHandler;
import com.fil.IMTransport.kafka.BookingRequest;
import com.fil.IMTransport.kafka.KafkaService;
import com.fil.IMTransport.object.Offer;
import com.fil.IMTransport.object.Station;

@SpringBootApplication
public class ImTransportApplication {

	@Autowired
	public static KafkaTemplate<String, String> kafkaTemplate;
	
	public static void main(String[] args) {
        SpringApplication.run(ImTransportApplication.class, args);
    }
	
	public void run(ApplicationArguments args) throws Exception {
//		// Récupération des offres
//		Offer offer = new Offer(new Timestamp(1551942000), new Timestamp(1551949200), new Station("A"), new Station("B"), 300);
//		ArrayList<Offer> offers = new ArrayList<>();
//		offers.add(offer);
//		
//		// Création des courses
//		BasicOfferHandler boh = new BasicOfferHandler();
//		boh.handle(offers);
//		//A compléter...
//		
//		// Envoi des demandes de réservation
//		BookingRequest br = new BookingRequest();
//		Station start = new Station();
//		start.setName("A");
//		
//		Station stop= new Station();
//		stop.setName("B");
//		
//		br.addLine(new Date(), start, stop);
//		KafkaService.askForBooking(br);
	}

}
