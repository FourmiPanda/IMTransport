package com.fil.IMTransport.object;

import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LineInaccessibility {
	private enum Inaccessibility { REJECTED, WORK; }
	
	@Id
	private int id;
	
	@ManyToOne
	private Line line;
	
	private Timestamp startDate;
	
	private Timestamp endDate;
	
	private Inaccessibility reason;

	public LineInaccessibility() {
		super();
	}

	public LineInaccessibility(Line line, Timestamp startDate, Timestamp endDate, Inaccessibility reason) {
		super();
		this.setLine(line);
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
	}

	public int getId() {
		return id;
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
		line.addInnaccessibility(this);
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Inaccessibility getReason() {
		return reason;
	}

	public void setReason(Inaccessibility reason) {
		this.reason = reason;
	}
	
}
