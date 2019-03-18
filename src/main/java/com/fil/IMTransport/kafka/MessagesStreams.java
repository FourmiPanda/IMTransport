package com.fil.IMTransport.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface MessagesStreams {

	String INPUT = "greetings-in";
	String OUTPUT = "greetings-out";
	
	@Input(INPUT)
	SubscribableChannel inboundGreetings();
	
	@Output(OUTPUT)
	SubscribableChannel outboundGreetings();
}
