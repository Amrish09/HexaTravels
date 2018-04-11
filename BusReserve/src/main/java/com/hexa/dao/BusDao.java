package com.hexa.dao;

import java.util.Date;
import java.util.List;

import com.hexa.entity.BookingDetailsBean;
import com.hexa.entity.BusScheduleBean;
import com.hexa.entity.LoginBean;

/**
 * 
 * @author Durga
 * @author Srilatha
 *         <p>
 * 		Interface for bus reservation
 *         </p>
 *         <p>
 * 		provide methods bus CRUD operations
 *         </p>
 * 
 */
public interface BusDao {

	List<BusScheduleBean> getBusSchedule(String source, String destination, String doj) throws InvalidException;

	List<BusScheduleBean> getBusDetails(int schId);

	public int insertBookId(BookingDetailsBean bd);

	int UpdateNoOfSeats(int schId, int noOfseats);

	int setBookingId();

	List<BookingDetailsBean> getUserBookingDetails(int loginId);

	BusScheduleBean getSeats(int schId);

	double getPrice(int busId);

	LoginBean checkUser(int loginId, String password);

}
