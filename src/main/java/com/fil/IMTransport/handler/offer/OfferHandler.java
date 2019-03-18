package com.fil.IMTransport.handler.offer;

import com.fil.IMTransport.object.Offer;
import com.fil.IMTransport.object.Trip;

import java.util.List;

public interface OfferHandler {
    

    public List<Trip> handle(List<Offer> offers);

}
