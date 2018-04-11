package com.hexa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hexa.dao.BusDao;
import com.hexa.dao.UserException;
import com.hexa.entity.BookingDetailsBean;
import com.hexa.entity.BusScheduleBean;
import com.hexa.entity.LoginBean;

/**
 * @author Srilatha
 * @author Durga
 *         <p>
 * 		This interface is for service method
 *         </p>
 */
@Service("myser")
public class BusSerImpl implements BusSer {

	@Autowired
	private BusDao dao;
	private Logger logger = LoggerFactory.getLogger("bus");

	/**
	 * @param userSeats
	 * @param schId
	 * @param loginId
	 * @return int value
	 *         <p>
	 * 		this method is implementing the service interface
	 *         </p>
	 */

	@Transactional(readOnly = false)
	@Override
	public int getBusUpdate(int userSeats, int schId, int loginId) throws UserException {

		BusScheduleBean bs = dao.getSeats(schId);
		logger.debug("hiii");
		int seats = bs.getNoOfSeatsAvailable();
		BusScheduleBean bb = new BusScheduleBean();
		BookingDetailsBean bd = new BookingDetailsBean();

		if (userSeats <= seats) {
			bb.setSchId(schId);
			LoginBean lb = new LoginBean();
			lb.setLoginId(loginId);
			int bookid = dao.setBookingId();
			bookid = bookid + 1;
			bd.setBookingId(bookid);
			bd.setBusSch(bs);
			bd.setLogin(lb);
			int res = dao.insertBookId(bd);
			if (res > 0) {
				int totalseats = seats - userSeats;
				logger.debug("totalseats" + totalseats);

				int update = dao.UpdateNoOfSeats(schId, totalseats);
				if (update > 0) {
					logger.debug("updated");
				} else {
					logger.debug("not update");
				}
			} else {
				logger.debug("no seats available");
			}
		} else {
			throw new UserException("no required seats available");
		}
		return 1;
	}

}
