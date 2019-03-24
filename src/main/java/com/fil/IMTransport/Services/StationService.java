package com.fil.IMTransport.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fil.IMTransport.Repository.StationRepository;

@Service
@Transactional
public class StationService {
	@Autowired
	private StationRepository stationRepo;
}
