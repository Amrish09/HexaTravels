package com.hexa.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Srilatha
 * @author Durga
 *         <p>
 * 		This class is for busdetailsBean
 *         </p>
 */
@Entity
@Table(name = "bus_details")
public class BusDetailsBean {

	@Id
	@Column(name = "bus_id")
	private int bid;
	@Column(name = "bus_source")
	private String source;
	@Column(name = "bus_dest")
	private String destination;
	@Column(name = "bus_price")
	private double price;

	@OneToMany(mappedBy = "bdetail", fetch = FetchType.LAZY)
	private Set<BusScheduleBean> busList;

	public Set<BusScheduleBean> getBusList() {
		return busList;
	}

	@Override
	public String toString() {
		return "BusDetailsBean bid=" + bid + ", source=" + source + ", destination=" + destination + ", price=" + price;
	}

	public void setBusList(Set<BusScheduleBean> busList) {
		this.busList = busList;
	}

	public BusDetailsBean() {

	}

	public BusDetailsBean(int bid, String source, String destination, double price) {

		this.bid = bid;
		this.source = source;
		this.destination = destination;
		this.price = price;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
