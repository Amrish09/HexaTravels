package com.hexa.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Srilatha
 * @author Durga
 *         <p>
 * 		This class is for busscheduledetailsBean
 *         </p>
 */
@Entity
@Table(name = "bus_schedule")
public class BusScheduleBean {
	@Id
	@Column(name = "sch_id")
	private int schId;
	@Column(name = "doj")
	private String dateOfJourney;
	@Column(name = "noofseats")
	private int noOfSeatsAvailable;

	@ManyToOne
	@JoinColumn(name = "bus_id", referencedColumnName = "bus_id")
	private BusDetailsBean bdetail;

	@OneToMany(mappedBy = "busSch", fetch = FetchType.LAZY)
	private Set<BookingDetailsBean> booklist;

	public Set<BookingDetailsBean> getBooklist() {
		return booklist;
	}

	public void setBooklist(Set<BookingDetailsBean> booklist) {
		this.booklist = booklist;
	}

	public BusDetailsBean getBdetail() {
		return bdetail;
	}

	public void setBdetail(BusDetailsBean bdetail) {
		this.bdetail = bdetail;
	}

	public BusScheduleBean() {

	}

	public BusScheduleBean(int schId, String dateOfJourney, int noOfSeatsAvailable) {
		super();
		this.schId = schId;
		this.dateOfJourney = dateOfJourney;
		this.noOfSeatsAvailable = noOfSeatsAvailable;
	}

	public int getSchId() {
		return schId;
	}

	public void setSchId(int schId) {
		this.schId = schId;
	}

	public String getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(String dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	@Override
	public String toString() {
		return "BusScheduleBean [schId=" + schId + ", dateOfJourney=" + dateOfJourney + ", noOfSeatsAvailable="
				+ noOfSeatsAvailable;
	}

	public int getNoOfSeatsAvailable() {
		return noOfSeatsAvailable;
	}

	public void setNoOfSeatsAvailable(int noOfSeatsAvailable) {
		this.noOfSeatsAvailable = noOfSeatsAvailable;
	}

}
