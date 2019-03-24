package com.fil.IMTransport.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fil.IMTransport.Repository.TripRepository;

@Service
@Transactional
public class TripService {
	@Autowired
	private TripRepository tripRepo;
}
