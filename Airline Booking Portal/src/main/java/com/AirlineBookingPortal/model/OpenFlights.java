package com.AirlineBookingPortal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
@IdClass(OpenFlightsPK.class)
public class OpenFlights {

	@Id
	@ManyToOne
	@JoinColumn(name = "flight_id")
	private Flight flight;

	@Id
	private Date date;

	public OpenFlights() {
	}

	public OpenFlights(Flight flight, Date date) {
		this.flight = flight;
		this.date = date;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}

class OpenFlightsPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private Flight flight;
	private Date date;

	public OpenFlightsPK() {
	}

	public OpenFlightsPK(Flight flight, Date date) {
		this.flight = flight;
		this.date = date;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "OpenFlightsPK [flight=" + flight + ", date=" + date + "]";
	}

}