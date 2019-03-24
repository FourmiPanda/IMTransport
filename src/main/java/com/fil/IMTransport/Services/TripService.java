package com.fil.IMTransport.Services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fil.IMTransport.Repository.TripRepository;
import com.fil.IMTransport.object.Trip;

@Service
@Transactional
public class TripService {
	@Autowired
	private TripRepository tripRepo;
	
	public List<Trip> getTrips() {
		List<Trip> trips = new ArrayList<Trip>();
		
		for(Trip t: tripRepo.findAll()) {
			trips.add(t);
		}
		
		return trips;
			
	}

	public Trip getTrip(int id) {
		return tripRepo.findById(id);
	}

	public void addTrip(Trip trip) {
		tripRepo.save(trip);
	}

	public void updateTrip(Trip trip) {
		tripRepo.save(trip);
	}

	public void deleteTrip(int id) {
		tripRepo.deleteById(id);
	}
	
	public void deleteTrip(Trip trip) {
		tripRepo.deleteById(trip.getId());
	}
}
