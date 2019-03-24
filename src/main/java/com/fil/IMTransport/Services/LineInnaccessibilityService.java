package com.fil.IMTransport.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fil.IMTransport.Repository.LineInaccessibilityRepository;

@Service
@Transactional
public class LineInnaccessibilityService {
	@Autowired
	private LineInaccessibilityRepository lineInnaccessRepo;
}
