package com.fil.IMTransport.handler.offer;

import com.fil.IMTransport.object.Offer;
import com.fil.IMTransport.object.Trip;

import java.util.ArrayList;
import java.util.List;

public class BasicOfferHandler implements OfferHandler {
    @Override
    public List<Trip> handle(List<Offer> offers) {
        ArrayList<Trip> trips = new ArrayList<>();
        for (Offer o : offers) {

            trips.add(new Trip());
        }
        return trips;
    }
}
