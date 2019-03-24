package com.fil.IMTransport.handler.booking;

import java.util.Collections;
import java.util.List;

import com.fil.IMTransport.object.Trip;

public interface BookingHandler {

	public void book(List<Trip> trips);

	default public void book(Trip trip) {
		book(Collections.singletonList(trip));
	}

	public void handleCancel(String id);

	public void handleConfirm(String id);

	public void handleDeny(String id);
}
