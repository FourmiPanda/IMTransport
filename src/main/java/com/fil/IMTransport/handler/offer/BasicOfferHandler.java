package com.fil.IMTransport.handler.offer;

import com.fil.IMTransport.object.Line;
import com.fil.IMTransport.object.Offer;
import com.fil.IMTransport.object.Station;
import com.fil.IMTransport.object.Trip;

import java.util.ArrayList;
import java.util.List;

import static com.fil.IMTransport.object.Global.NB_PASSENGERS_BY_TRAIN;

public class BasicOfferHandler implements OfferHandler {

    public List<Line> allLines = new ArrayList<>();

    @Override
    public List<Trip> handle(List<Offer> offers) {
        allLines.add(new Line(new Station("A"), new Station("B"), 50));
        allLines.add(new Line(new Station("B"), new Station("C"), 50));

        ArrayList<Trip> trips = new ArrayList<>();
        for (Offer o : offers) {
            Trip t = new Trip();
            ArrayList<Line> lines = new ArrayList<>();
            t.setLines(this.getLines(o.getStartStation(), o.getEndStation()));
            t.setNbTrain((int)this.getNbTrainFromPassenger(o.getNbPassengers()));
            String affichageChemin = "";
            for (Line l :  t.getLines()){
                affichageChemin += l.getStart().getName() + " => " + l.getEnd().getName()+" , ";
            }
            System.out.println("PATH : " + affichageChemin);


            trips.add(t);
        }

        return trips;
    }

    private double getNbTrainFromPassenger(int nbPassenger){
        double nbPbyT = NB_PASSENGERS_BY_TRAIN;
        return Math.ceil(nbPassenger/nbPbyT);
    }


    private List<Line> getLines(Station start, Station end){
        boolean found = false;
        List<Line> lines = new ArrayList<>();
        Station lookingFor = start;
        while(!found){
            Line l = this.getLineFromStartStation(lookingFor);
            lines.add(l);
            System.out.println(l.getStart().getName() + " => " + l.getEnd().getName());
            if (l.getEnd().getName().equals(end.getName())){
                System.out.println("FOUND !");
                found = true;
            }
            lookingFor = l.getEnd();
        }
        return lines;
    }

    private Line getLineFromStartStation(Station start){
        for (Line l : allLines){
            if (l.getStart().getName().equals(start.getName())){
                return l;
            }
        }
        return null;
    }


}
