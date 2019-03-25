package com.fil.IMTransport.handler.booking;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fil.IMTransport.Services.BookingService;
import com.fil.IMTransport.Services.LineService;
import com.fil.IMTransport.kafka.BookingRequest;
import com.fil.IMTransport.kafka.KafkaService;
import com.fil.IMTransport.kafka.TripInfo;
import com.fil.IMTransport.object.Booking;
import com.fil.IMTransport.object.Global;
import com.fil.IMTransport.object.Line;
import com.fil.IMTransport.object.LineInaccessibility;
import com.fil.IMTransport.object.Trip;

public class BasicBookingHandler implements BookingHandler {

	@Autowired
	private BookingService bookingService;
	@Autowired
	private LineService lineService;
	@Autowired
	private KafkaService kafkaService;

	private static BasicBookingHandler instance;

	private BasicBookingHandler() {
	}

	public static BasicBookingHandler getInstance() {
		if (instance == null) {
			instance = new BasicBookingHandler();
		}
		return instance;
	}

	@Override
	public void book(List<Trip> trips) {
		trips.forEach((trip) -> {
			trip.getLines().forEach((l) -> {
				String bookingId = Global.NAME_TRANSPORTER + "_" + l.getStart().getName() + l.getEnd().getName() + "_"
						+ Calendar.getInstance().getTimeInMillis();
				BookingRequest request = new BookingRequest(bookingId, trip.getTimeAtStation(l.getStart()),
						l.getStart(), l.getEnd());
				Booking b = new Booking();
				b.setIdRequest(bookingId);
				b.setLine(l);
				b.setStartDate(trip.getTimeAtStation(l.getStart()));
				b.setState(Booking.State.PENDING);
				addBooking(b);
				kafkaService.askForBooking(request);
			});
		});
	}

	@Override
	public void handleCancel(String id) {
		Booking b = getBooking(id);
		removeBooking(b);
		LineInaccessibility in = new LineInaccessibility(b.getLine(), b.getStartDate(), b.getStartDate(),
				LineInaccessibility.Inaccessibility.WORK);
		b.getLine().addInnaccessibility(in);
		updateLine(b.getLine());
	}

	@Override
	public void handleConfirm(String id) {
		Booking b = getBooking(id);
		b.setState(Booking.State.OK);
		updateBooking(b);
		kafkaService.sendTripInfo(new TripInfo(b.getLine().getStart().getName(), b.getLine().getEnd().getName(), 500,
				b.getStartDate().getTime()));
	}

	@Override
	public void handleDeny(String id) {
		Booking b = getBooking(id);
		removeBooking(b);
		LineInaccessibility in = new LineInaccessibility(b.getLine(), b.getStartDate(), b.getStartDate(),
				LineInaccessibility.Inaccessibility.REJECTED);
		b.getLine().addInnaccessibility(in);
		updateLine(b.getLine());
	}

	private Booking getBooking(String id) {
		return bookingService.getBookingsByIdRequest(id).get(0);
	}

	private void removeBooking(Booking b) {
		bookingService.deleteBooking(b);
	}

	private void addBooking(Booking b) {
		bookingService.addBooking(b);
	}

	private void updateBooking(Booking b) {
		bookingService.updateBooking(b);
	}

	private void updateLine(Line l) {
		lineService.updateLine(l);
	}
}
