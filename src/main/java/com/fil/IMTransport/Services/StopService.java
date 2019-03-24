package com.fil.IMTransport.Services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fil.IMTransport.Repository.StopRepository;
import com.fil.IMTransport.object.Stop;

@Service
@Transactional
public class StopService {
	@Autowired
	private StopRepository stopRepo;
	
	public List<Stop> getStops() {
		List<Stop> stops = new ArrayList<Stop>();
		
		for(Stop t: stopRepo.findAll()) {
			stops.add(t);
		}
		
		return stops;
	}

	public Stop getStop(int id) {
		return stopRepo.findById(id);
	}

	public void addStop(Stop stop) {
		stopRepo.save(stop);
	}

	public void updateStop(Stop stop) {
		stopRepo.save(stop);
	}

	public void deleteStop(int id) {
		stopRepo.deleteById(id);
	}
	
	public void deleteStop(Stop stop) {
		stopRepo.deleteById(stop.getId());
	}
}
