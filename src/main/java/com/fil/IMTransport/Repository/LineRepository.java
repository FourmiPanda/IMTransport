package com.fil.IMTransport.Repository;

import org.springframework.data.repository.CrudRepository;
import com.fil.IMTransport.object.Line;
import com.fil.IMTransport.object.Offer;

public interface LineRepository extends CrudRepository<Line, Integer>{
	Line findById(int id);
	void deleteById(int id);
}
