package com.fil.IMTransport.Services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fil.IMTransport.Repository.LineRepository;
import com.fil.IMTransport.object.Line;

@Service
@Transactional
public class LineService {
	@Autowired
	private LineRepository lineRepo;
	
	public List<Line> getLines() {
		List<Line> lines = new ArrayList<Line>();
		
		for(Line t: lineRepo.findAll()) {
			lines.add(t);
		}
		
		return lines;
	}

	public Line getLine(int id) {
		return lineRepo.findById(id);
	}

	public void addLine(Line line) {
		lineRepo.save(line);
	}

	public void updateLine(Line line) {
		lineRepo.save(line);
	}

	public void deleteLine(int id) {
		lineRepo.deleteById(id);
	}
}
