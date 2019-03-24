package com.fil.IMTransport.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fil.IMTransport.Repository.LineInaccessibilityRepository;
import com.fil.IMTransport.object.LineInaccessibility;

@Service
@Transactional
public class LineInnaccessibilityService {
	@Autowired
	private LineInaccessibilityRepository lineInnaccessRepo;
	
	public List<LineInaccessibility> getLineInaccessibilitys() {
		List<LineInaccessibility> topics = new ArrayList<LineInaccessibility>();
		
		for(LineInaccessibility t: lineInnaccessRepo.findAll()) {
			topics.add(t);
		}
		
		return topics;
			
	}

	public LineInaccessibility getLineInaccessibility(int id) {
		return this.lineInnaccessRepo.findById(id);
	}

	public void addLineInaccessibility(LineInaccessibility topic) {
		lineInnaccessRepo.save(topic);
	}

	public void updateLineInaccessibility(LineInaccessibility topic) {
		lineInnaccessRepo.save(topic);
	}

	public void deleteLineInaccessibility(int id) {
		lineInnaccessRepo.deleteById(id);
	}
	
	public void deleteLineInaccessibility(LineInaccessibility innaccess) {
		lineInnaccessRepo.deleteById(innaccess.getId());
	}
}
