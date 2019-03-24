package com.fil.IMTransport.handler.booking;

import java.util.Calendar;
import java.util.List;

import com.fil.IMTransport.kafka.BookingRequest;
import com.fil.IMTransport.kafka.KafkaService;
import com.fil.IMTransport.kafka.TripInfo;
import com.fil.IMTransport.object.Booking;
import com.fil.IMTransport.object.Global;
import com.fil.IMTransport.object.Line;
import com.fil.IMTransport.object.LineInaccessibility;
import com.fil.IMTransport.object.Trip;

public class BasicBookingHandler implements BookingHandler {

	@Override
	public void book(List<Trip> trips) {
		trips.forEach((trip) -> {
			trip.getLines().forEach((l) -> {
				String bookingId = Global.NAME_TRANSPORTER + "_" + l.getStart().getName() + l.getEnd().getName() + "_"
						+ Calendar.getInstance().getTimeInMillis();
				BookingRequest request = new BookingRequest(bookingId, trip.getTimeAtStation(l.getStart()),
						l.getStart(), l.getEnd());
				Booking b = new Booking();
				b.setIdBooking(bookingId);
				b.setLine(l);
				b.setStartDate(trip.getTimeAtStation(l.getStart()));
				b.setState(Booking.State.PENDING);
				saveBooking(b);
				KafkaService.askForBooking(request);
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
		saveLine(b.getLine());
	}

	@Override
	public void handleConfirm(String id) {
		Booking b = getBooking(id);
		b.setState(Booking.State.OK);
		saveBooking(b);
		KafkaService.sendTripInfo(new TripInfo(b.getLine().getStart().getName(), b.getLine().getEnd().getName(), 500,
				b.getStartDate().getTime()));
	}

	@Override
	public void handleDeny(String id) {
		Booking b = getBooking(id);
		removeBooking(b);
		LineInaccessibility in = new LineInaccessibility(b.getLine(), b.getStartDate(), b.getStartDate(),
				LineInaccessibility.Inaccessibility.REJECTED);
		b.getLine().addInnaccessibility(in);
		saveLine(b.getLine());
	}

	private Booking getBooking(String id) {
		return null;
	}

	private void removeBooking(Booking b) {

	}

	private void saveBooking(Booking b) {

	}

	private void saveLine(Line l) {

	}
}
