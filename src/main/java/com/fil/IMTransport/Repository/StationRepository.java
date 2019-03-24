package com.fil.IMTransport.Repository;

import org.springframework.data.repository.CrudRepository;
import com.fil.IMTransport.object.Station;
import com.fil.IMTransport.object.Stop;

public interface StationRepository extends CrudRepository<Station, Integer>{
	Station findById(int id);
	void deleteById(int id);
}
