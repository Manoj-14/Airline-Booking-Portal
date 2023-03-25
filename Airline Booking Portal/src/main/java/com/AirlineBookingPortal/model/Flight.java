package com.AirlineBookingPortal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flight_id;
	private String flightname;
	private int numofpassengers;

	@ManyToOne
	private Place source;
	@ManyToOne
	
	private Place destination;

	public Flight() {
	};

	public Flight(String flightname, int numofpassengers, Place source, Place destination) {
		this.flightname = flightname;
		this.numofpassengers = numofpassengers;
		this.source = source;
		this.destination = destination;
	}

	public int getFlightid() {
		return flight_id;
	}

	public void setFlightid(int flightid) {
		this.flight_id = flightid;
	}

	public String getFlightname() {
		return flightname;
	}

	public void setFlightname(String flightname) {
		this.flightname = flightname;
	}

	public int getNumofpassengers() {
		return numofpassengers;
	}

	public void setNumofpassengers(int numofpassengers) {
		this.numofpassengers = numofpassengers;
	}

	public Place getSource() {
		return source;
	}

	public void setSource(Place source) {
		this.source = source;
	}

	public Place getDestination() {
		return destination;
	}

	public void setDestination(Place destination) {
		this.destination = destination;
	}

}
