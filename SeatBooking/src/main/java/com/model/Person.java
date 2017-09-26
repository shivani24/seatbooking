package com.seat.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="employee_id")
	private String employeeId;

	private String designation;

	@Column(name="employee_name")
	private String employeeName;

	private String password;

	@Column(name="user_name")
	private String userName;

	@Column(name="user_type")
	private String userType;

//	//bi-directional many-to-many association to SeatMaster
//	@ManyToMany(mappedBy="persons")
//	private List<SeatMaster> seatMasters;

	@OneToMany(mappedBy="person")
	private List<Booking> bookings =new ArrayList<>();
	private List<SeatMaster> seatmaster =new ArrayList<>();
	
	//bi-directional many-to-one association to ContactDetail
	@OneToMany
	@JoinTable(name="id", joinColumns=@JoinColumn(name="employee_id"),
			inverseJoinColumns=@JoinColumn(name="id"))
	private List<ContactDetail> contactDetails=new ArrayList<>();

	public Person() {
	}

	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

//	public List<SeatMaster> getSeatMasters() {
//		return this.seatMasters;
//	}
//
//	public void setSeatMasters(List<SeatMaster> seatMasters) {
//		this.seatMasters = seatMasters;
//	}

	public List<ContactDetail> getContactDetails() {
		return this.contactDetails;
	}

	public void setContactDetails(List<ContactDetail> contactDetails) {
		this.contactDetails = contactDetails;
	}

	public ContactDetail addContactDetail(ContactDetail contactDetail) {
		getContactDetails().add(contactDetail);
		contactDetail.setPerson(this);

		return contactDetail;
	}

	public ContactDetail removeContactDetail(ContactDetail contactDetail) {
		getContactDetails().remove(contactDetail);
		contactDetail.setPerson(null);

		return contactDetail;

	}
	
	
	public List<Booking> getBookings() {
		return this.bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Booking addBooking(Booking booking) {
		getBookings().add(booking);
		booking.setPerson(this);

		return booking;
	}

	public Booking removeBooking(Booking booking) {
		getBookings().remove(booking);
		booking.setPerson(null);

		return booking;
	}


}