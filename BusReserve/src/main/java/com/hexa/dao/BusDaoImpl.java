package com.hexa.dao;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.hexa.entity.BookingDetailsBean;
import com.hexa.entity.BusDetailsBean;
import com.hexa.entity.BusScheduleBean;
import com.hexa.entity.LoginBean;

/**
 * 
 * @author Srilatha
 * @author Durga
 *         <p>
 * 		Class implementation of Dao class
 *         </p>
 *
 */
@Repository("mydao")
public class BusDaoImpl implements BusDao {
	private Logger logger = LoggerFactory.getLogger("bus");

	@Autowired
	private SessionFactory sfac;

	/**
	 * @param source
	 *            source of place
	 * @param destination
	 *            destination of place
	 * @param doj
	 *            date of journey
	 * @see com.hexa.dao.BusDao#getBusSchedule(java.lang.String, java.lang.String,
	 *      java.lang.String)
	 * @return list of busScheduleBean
	 *         <p>
	 *         This method is used to retrieve bus schedule details
	 *         </p>
	 */
	@Override
	public List<BusScheduleBean> getBusSchedule(String source, String destination, String doj) throws InvalidException {

		logger.debug("Bus Schedule method");
		Session sess = sfac.openSession();
		String hql = "from BusScheduleBean bs inner join fetch bs.bdetail bl where bl.source=? and bl.destination=? and bs.dateOfJourney=?";
		Query qry = sess.createQuery(hql);
		qry.setString(0, source);
		qry.setString(1, destination);
		qry.setString(2, doj);
		List<BusScheduleBean> lst = qry.list();
		if (lst.size() == 0) {
			logger.error("Notexception raise");
			throw new InvalidException("Source and destination are invalid");
		}
		sess.close();
		return lst;
	}

	/**
	 * @param bid
	 *            bus id
	 * @return list of bus schedulebean
	 *         <p>
	 * 		This method get bus id and give list of bus schedule bean details
	 *         </p>
	 */
	@Override
	public List<BusScheduleBean> getBusDetails(int bid) {
		logger.debug("Bus Details method");
		Session sess = sfac.openSession();
		String hql = "from BusScheduleBean bd inner join fetch bd.bdetail bsh where bsh.bid=?";
		Query qry = sess.createQuery(hql);
		qry.setInteger(0, bid);
		List<BusScheduleBean> lst = qry.list();
		sess.close();
		return lst;
	}

	/**
	 * @param bd
	 *            bookingdeatailsbean object
	 * @return int value
	 *         <p>
	 * 		This method gets bookingdetails and return int value
	 *         </p>
	 */

	@Override
	public int insertBookId(BookingDetailsBean bd) {
		logger.debug("Insert Book Id");
		Session sess = sfac.getCurrentSession();
		sess.save(bd);
		return 1;
	}

	/**
	 * @param schId
	 *            ScheduleId
	 * @param noOfSeats
	 *            noofseats
	 * @return int value
	 *         <p>
	 * 		This method gets schId and noofseats and return int value
	 *         </p>
	 */

	@Override
	public int UpdateNoOfSeats(int schId, int noOfSeats) {
		logger.debug("UpdateNoOfSeats method");
		Session sess = sfac.getCurrentSession();
		BusScheduleBean busSch = (BusScheduleBean) sess.get(BusScheduleBean.class, schId);
		busSch.setNoOfSeatsAvailable(noOfSeats);
		sess.update(busSch);
		return 0;

	}

	/**
	 * @param loginId
	 *            login id
	 * @return list of bookingDetailsBean
	 *         <p>
	 * 		This method get loginId as input and returns list of
	 *         bookingdetailsbean
	 *         </p>
	 */
	@Override
	public List<BookingDetailsBean> getUserBookingDetails(int loginId) {
		logger.debug("User BookingDeatils method");
		Session sess = sfac.openSession();
		String hql = "from BookingDetailsBean b inner join fetch b.login ll where ll.loginId=?";
		Query qry = sess.createQuery(hql);
		qry.setInteger(0, loginId);
		List<BookingDetailsBean> lst = qry.list();
		sess.close();
		return lst;

	}

	/**
	 * @param schId
	 *            scheduleId
	 * @return busscheduleBean
	 *         <p>
	 * 		This method gets schId as input and returns busScheduleBean
	 *         </p>
	 */
	@Override
	public BusScheduleBean getSeats(int schId) {
		logger.debug("no of seats booking method");
		Session sess = sfac.openSession();
		String hql = "from BusScheduleBean b where b.schId=? ";
		Query qry = sess.createQuery(hql);
		qry.setInteger(0, schId);
		BusScheduleBean bd = (BusScheduleBean) qry.uniqueResult();
		sess.close();
		return bd;
	}

	/**
	 * @return int value
	 *         <p>
	 * 		This method returns the maximum bookId
	 *         </p>
	 */

	@Override
	public int setBookingId() {
		logger.debug("generaring bookingid method");
		Session sess = sfac.openSession();
		String hql = "select max(bookingId) from BookingDetailsBean";
		Query qry = sess.createQuery(hql);
		int bookid = (int) qry.uniqueResult();
		sess.close();
		return bookid;
	}

	/**
	 * @param busId
	 *            bus id
	 * @return double value
	 *         <p>
	 * 		This method returns the price of the bus
	 *         </p>
	 */

	@Override
	public double getPrice(int busId) {
		logger.debug("generaring bookingid method");
		Session sess = sfac.openSession();
		String hql = "select price from BusDetailsBean where busId=?";
		Query qry = sess.createQuery(hql);
		double price = (double) qry.uniqueResult();
		sess.close();
		return price;
	}

	/**
	 * @param loginId
	 *            login Id
	 * @param password
	 *            passwoprd
	 * @return LoginBean value
	 *         <p>
	 * 		This method checks the correct user
	 *         </p>
	 */
	@Override
	public LoginBean checkUser(int loginId, String password) {
		logger.debug("checking user method");
		Session sess = sfac.openSession();
		String hql = "from LoginBean where loginId=? and password=?";
		Query qry = sess.createQuery(hql);
		qry.setInteger(0, loginId);
		qry.setString(1, password);
		LoginBean lbean = (LoginBean) qry.uniqueResult();
		sess.close();
		if (lbean != null) {
			logger.error("Username and password is wrong");
			return lbean;
		}

		return null;
	}
}
