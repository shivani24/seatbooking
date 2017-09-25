package com.seat.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the location_master database table.
 * 
 */
@Entity
@Table(name="location_master")
@NamedQuery(name="LocationMaster.findAll", query="SELECT l FROM LocationMaster l")
public class LocationMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="location_code")
	private String locationCode;

	private String country;

	@Column(name="location_name")
	private String locationName;

	@Column(name="office_name")
	private String officeName;

	//bi-directional many-to-one association to SeatMaster
	@OneToMany
	@JoinTable(name="seat_no", joinColumns=@JoinColumn(name="location_code"),
	inverseJoinColumns=@JoinColumn(name="seat_no"))
	private List<SeatMaster> seatMasters=new ArrayList<>();

	public LocationMaster() {
	}

	public String getLocationCode() {
		return this.locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLocationName() {
		return this.locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getOfficeName() {
		return this.officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public List<SeatMaster> getSeatMasters() {
		return this.seatMasters;
	}

	public void setSeatMasters(List<SeatMaster> seatMasters) {
		this.seatMasters = seatMasters;
	}

	public SeatMaster addSeatMaster(SeatMaster seatMaster) {
		getSeatMasters().add(seatMaster);
		seatMaster.setLocationMaster(this);

		return seatMaster;
	}

	public SeatMaster removeSeatMaster(SeatMaster seatMaster) {
		getSeatMasters().remove(seatMaster);
		seatMaster.setLocationMaster(null);

		return seatMaster;
	}

}