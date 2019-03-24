package com.fil.IMTransport.Repository;

import org.springframework.data.repository.CrudRepository;
import com.fil.IMTransport.object.Offer;
import com.fil.IMTransport.object.Station;

public interface OfferRepository extends CrudRepository<Offer, Integer>{
	Offer findById(int id);
	void deleteById(int id);
}
