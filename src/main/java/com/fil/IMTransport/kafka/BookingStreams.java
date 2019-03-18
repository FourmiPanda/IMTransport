package com.fil.IMTransport.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

/**
 * Interface permettant de se connecter à kafka
 * @author Océane
 *
 */
public interface BookingStreams {

	// La valeur des String doit être le nom du channel kafka je pense
	String INPUT = "booking-in";
	String OUTPUT = "booking-out";
	
	@Input(INPUT)
	SubscribableChannel inboundBookings();
	
	@Output(OUTPUT)
	SubscribableChannel outboundBookings();
}
