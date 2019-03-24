package com.fil.IMTransport.Services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fil.IMTransport.Repository.StationRepository;
import com.fil.IMTransport.object.Station;

@Service
@Transactional
public class StationService {
	@Autowired
	private StationRepository stationRepo;
	
	public List<Station> getStations() {
		List<Station> stations = new ArrayList<Station>();
		
		for(Station t: stationRepo.findAll()) {
			stations.add(t);
		}
		
		return stations;
	}

	public Station getStation(int id) {
		return stationRepo.findById(id);
	}

	public void addStation(Station station) {
		stationRepo.save(station);
	}

	public void updateStation(Station station) {
		stationRepo.save(station);
	}

	public void deleteStation(int id) {
		stationRepo.deleteById(id);
	}
}
