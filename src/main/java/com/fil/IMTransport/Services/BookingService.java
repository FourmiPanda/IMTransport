package com.fil.IMTransport.Services;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fil.IMTransport.Repository.BookingRepository;
import com.fil.IMTransport.object.Booking;
import com.fil.IMTransport.object.Line;
import com.fil.IMTransport.object.Booking.State;

@Service
@Transactional
public class BookingService {
	@Autowired
	private BookingRepository bookingRepo;
	
	public List<Booking> getBookings() {
		List<Booking> bookings = new ArrayList<Booking>();
		
		for(Booking t: bookingRepo.findAll()) {
			bookings.add(t);
		}
		
		return bookings;	
	}

	public Booking getBooking(int id) {
		return bookingRepo.findById(id);
	}

	public void addBooking(Booking booking) {
		bookingRepo.save(booking);
	}

	public void updateBooking(Booking booking) {
		bookingRepo.save(booking);
	}

	public void deleteTopic(int id) {
		bookingRepo.deleteById(id);
	}
}
