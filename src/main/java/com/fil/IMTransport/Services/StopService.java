package com.fil.IMTransport.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fil.IMTransport.Repository.StopRepository;

@Service
@Transactional
public class StopService {
	@Autowired
	private StopRepository stopRepo;
}
