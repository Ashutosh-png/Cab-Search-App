package com.workshop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pickupLocation;
    private String dropLocation;
    private String distance;
    private String name;
    private String email;
    private String date;
    private String time;
    private String tripType;
    private int price;
    
    
    
    
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPickupLocation() {
		return pickupLocation;
	}
	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}
	public String getDropLocation() {
		return dropLocation;
	}
	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTripType() {
		return tripType;
	}
	public void setTripType(String tripType) {
		this.tripType = tripType;
	}
	
	
	@Override
	public String toString() {
		return "Booking [id=" + id + ", pickupLocation=" + pickupLocation + ", dropLocation=" + dropLocation
				+ ", distance=" + distance + ", name=" + name + ", email=" + email + ", date=" + date + ", time=" + time
				+ ", tripType=" + tripType + ", price=" + price + "]";
	}
	public Booking(Long id, String pickupLocation, String dropLocation, String distance, String name, String email,
			String date, String time, String tripType, int price) {
		super();
		this.id = id;
		this.pickupLocation = pickupLocation;
		this.dropLocation = dropLocation;
		this.distance = distance;
		this.name = name;
		this.email = email;
		this.date = date;
		this.time = time;
		this.tripType = tripType;
		this.price = price;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
