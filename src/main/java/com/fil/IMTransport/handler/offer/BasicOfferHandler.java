package com.fil.IMTransport.handler.offer;

import com.fil.IMTransport.Services.BookingService;
import com.fil.IMTransport.Services.LineInnaccessibilityService;
import com.fil.IMTransport.Services.LineService;
import com.fil.IMTransport.handler.booking.BasicBookingHandler;
import com.fil.IMTransport.handler.booking.BookingHandler;
import com.fil.IMTransport.object.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static com.fil.IMTransport.object.Global.NB_PASSENGERS_BY_TRAIN;

public class BasicOfferHandler implements OfferHandler {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private LineService lineService;
    @Autowired
    private LineInnaccessibilityService lineInnaccessibilityService;

    private BookingHandler bookingHandler = BasicBookingHandler.getInstance();

    @Override
    public void handle(List<Offer> offers) {

        ArrayList<Trip> trips = new ArrayList<>();
        for (Offer o : offers) {
            Trip t = new Trip();
            ArrayList<Line> lines = new ArrayList<>();
            t.setLines(this.getLines(o.getStartStation(), o.getEndStation()));
            t.setNbTrain((int) this.getNbTrainFromPassenger(o.getNbPassengers()));
            String affichageChemin = "";
            for (Line l : t.getLines()) {
                affichageChemin += l.getStart().getName() + " => " + l.getEnd().getName() + " , ";
            }
            System.out.println("PATH : " + affichageChemin);


            trips.add(t);
        }

        bookingHandler.book(trips);
    }

    private double getNbTrainFromPassenger(int nbPassenger) {
        double nbPbyT = NB_PASSENGERS_BY_TRAIN;
        return Math.ceil(nbPassenger / nbPbyT);
    }


    private List<Line> getLines(Station start, Station end) {
        boolean found = false;
        List<Line> lines = new ArrayList<>();
        Station lookingFor = start;
        while (!found) {
            Line l = this.getLineFromStartStation(lookingFor);
            lines.add(l);
            System.out.println(l.getStart().getName() + " => " + l.getEnd().getName());
            if (l.getEnd().getName().equals(end.getName()) && l.getInaccessibilities().size() == 0) {
                System.out.println("FOUND !");
                found = true;
            }
            lookingFor = l.getEnd();
        }
        return lines;
    }

    private Line getLineFromStartStation(Station start) {
        for (Line l : lineService.getLines()) {
            if (l.getStart().getName().equals(start.getName())) {
                return l;
            }
        }
        return null;
    }


}
