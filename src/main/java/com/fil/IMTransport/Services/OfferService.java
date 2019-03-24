package com.fil.IMTransport.Services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fil.IMTransport.Repository.OfferRepository;
import com.fil.IMTransport.object.Offer;

@Service
@Transactional
public class OfferService {
	@Autowired
	private OfferRepository offerRepo;
	
	public List<Offer> getOffers() {
		List<Offer> offers = new ArrayList<Offer>();
		
		for(Offer t: offerRepo.findAll()) {
			offers.add(t);
		}
		
		return offers;
	}

	public Offer getOffer(int id) {
		return offerRepo.findById(id);
	}

	public void addOffer(Offer offer) {
		offerRepo.save(offer);
	}

	public void updateOffer(Offer offer) {
		offerRepo.save(offer);
	}

	public void deleteOffer(int id) {
		offerRepo.deleteById(id);
	}
	
	public void deleteOffer(Offer offer) {
		offerRepo.deleteById(offer.getId());
	}
}
