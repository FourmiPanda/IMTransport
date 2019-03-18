package com.fil.IMTransport.kafka;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

/**
 * Classe permettant d'envoyer les reservations à l'autorité de transport, via Kafka
 * 
 * @author Océane
 * A mocker quand l'algo sera fait : pour vérifier que l'appel à sendBooking se fait bien
 */
@Service
public class BookingService {

	/**
	 * @param bookingStream BookingStream - Interface permettant de se connecter à Kafka 
	 */
	private final BookingStreams bookingStream;

	public BookingService(BookingStreams bookingStream) {
		this.bookingStream = bookingStream;
	}

	/**
	 * Méthode permettant d'envoyer une demande de réservation
	 * @param booking BookingRequest - Demande de réservation à envoyer
	 */
	public void sendBooking(final BookingRequest booking) {
		MessageChannel messageChannel = bookingStream.outboundBookings();
		messageChannel.send(MessageBuilder.withPayload(booking)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
	}

}
