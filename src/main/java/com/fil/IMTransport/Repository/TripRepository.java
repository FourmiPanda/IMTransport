package com.fil.IMTransport.Repository;

import org.springframework.data.repository.CrudRepository;
import com.fil.IMTransport.object.Trip;

public interface TripRepository extends CrudRepository<Trip, Integer>{
	Trip findById(int id);
	void deleteById(int id);
}
