package com.fil.IMTransport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class ImTransportApplication {

	@Autowired
	public static KafkaTemplate<String, String> kafkaTemplate;
	
	public static void main(String[] args) {
        SpringApplication.run(ImTransportApplication.class, args);
    }
}
