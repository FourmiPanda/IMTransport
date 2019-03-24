package com.fil.IMTransport.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fil.IMTransport.Repository.LineRepository;

@Service
@Transactional
public class LineService {
	@Autowired
	private LineRepository lineRepo;

}
