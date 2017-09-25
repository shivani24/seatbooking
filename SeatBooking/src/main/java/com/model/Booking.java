package com.seat.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the booking database table.
 * 
 */
@Entity
@NamedQuery(name="Booking.findAll", query="SELECT b FROM Booking b")
public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="booking_id")
	private int bookingId=1;

	@Temporal(TemporalType.DATE)
	@Column(name="booking_date")
	private Date bookingDate;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Person person;

	//bi-directional many-to-one association to SeatMaster
	@ManyToOne
	@JoinColumn(name="seat_no")
	private SeatMaster seatMaster;

	public Booking() {
	}

	public int getBookingId() {
		return this.bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Date getBookingDate() {
		return this.bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public SeatMaster getSeatMaster() {
		return this.seatMaster;
	}

	public void setSeatMaster(SeatMaster seatMaster) {
		this.seatMaster = seatMaster;
	}

}