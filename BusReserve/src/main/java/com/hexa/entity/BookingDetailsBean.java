package com.hexa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Srilatha
 * @author Durga
 *         <p>
 * 		This class is for bookingdetailsBean
 *         </p>
 */
@Entity
@Table(name = "booking_details")
public class BookingDetailsBean {
	@Id
	@Column(name = "book_id")
	private int bookingId;

	@ManyToOne
	@JoinColumn(name = "sch_id", referencedColumnName = "sch_id")
	private BusScheduleBean busSch;

	@ManyToOne
	@JoinColumn(name = "login_id", referencedColumnName = "login_id")
	private LoginBean login;

	@Override
	public String toString() {
		return "BookingDetailsBean bookingId=" + bookingId;
	}

	public LoginBean getLogin() {
		return login;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}

	public BusScheduleBean getBusSch() {
		return busSch;
	}

	public void setBusSch(BusScheduleBean busSch) {
		this.busSch = busSch;
	}

	public BookingDetailsBean() {

	}

	public BookingDetailsBean(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

}
