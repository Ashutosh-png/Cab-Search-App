package com.workshop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CabService {
	
	  private static     List<Booking> booking = new ArrayList<>();

	public void save(Booking booking2) {
		// TODO Auto-generated method stub
		booking.add(booking2);
		
	}
	
	public List<Booking> showAll(){
		return booking;
	}


}
