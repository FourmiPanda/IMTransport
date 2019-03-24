package com.fil.IMTransport.Repository;

import org.springframework.data.repository.CrudRepository;
import com.fil.IMTransport.object.Stop;
import com.fil.IMTransport.object.Trip;

public interface StopRepository extends CrudRepository<Stop, Integer>{
	Stop findById(int id);
	void deleteById(int id);
}
