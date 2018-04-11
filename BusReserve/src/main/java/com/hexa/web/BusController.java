package com.hexa.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hexa.dao.BusDao;
import com.hexa.dao.InvalidException;
import com.hexa.dao.UserException;
import com.hexa.entity.LoginBean;
import com.hexa.service.BusSer;

/**
 * @author Srilatha
 * @author Durga
 *         <p>
 * 		This class controller for bus reservation
 *         </p>
 */

@Controller
public class BusController {
	private Logger logger = LoggerFactory.getLogger("bus");

	@Autowired
	private BusDao dao;

	@Autowired
	private BusSer ser;

	/**
	 * @return string
	 *         <p>
	 * 		this is mapping to main page
	 *         </p>
	 */
	// Login page
	@RequestMapping("/")
	public String displayMain() {
		return "Main";
	}

	/**
	 * @return string
	 *         <p>
	 * 		this is mapping to login page
	 *         </p>
	 */
	// Login page
	@RequestMapping("/Login")
	public String displayIdFrm() {
		return "LoginPage";
	}

	/**
	 * @param request request object
	 * @param model  model object
	 * @param uname  username
	 * @param pwd password
	 * @return string
	 *         <p>
	 * 		this is mapping to check login page
	 *         </p>
	 */

	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public String checkLogin(HttpServletRequest request, Model model, @RequestParam("uname") Integer uname,
			@RequestParam("psw") String pwd) {
		HttpSession sess = request.getSession();
		LoginBean lb = dao.checkUser(uname, pwd);
		if (lb == null) {
			return "LoginPage";
		}
		sess.setAttribute("log", lb);

		return "BusSearch";
	}

	/**
	 * @param model model object
	 * @return string
	 *         <p>
	 * 		this is mapping to bus search page
	 *         </p>
	 */

	// searching for buses
	@RequestMapping("/search")
	public String dislpayBusSchedule(Model model) {
		return "BusSearch";
	}

	/**
	 * @param src source
	 * @param dest destination
	 * @param doj date of join
	 * @param model model object
	 * @throws InvalidException invalid user defined exception
	 * @return string
	 *         <p>
	 * 		this is mapping to bus schedule display page
	 *         </p>
	 */
	// getting schedule of bus
	@RequestMapping("/displaySchedule")
	public String displayBusId(@RequestParam("src") String src, @RequestParam("dest") String dest,
			@RequestParam("doj") String doj, Model model) throws InvalidException {
		model.addAttribute("dlist", dao.getBusSchedule(src, dest, doj));
		return "BusScheduleDisplay";
	}

	/**
	 * @param busid bus id
	 * @param model model object
	 * @return string
	 *         <p>
	 * 		this is mapping to bus id display page
	 *         </p>
	 */
	// displaying booking id
	@RequestMapping("/displayBooking")
	public String displayBookingId(@RequestParam("bid") Integer busid, Model model) {
		model.addAttribute("ilist", dao.getBusDetails(busid));
		return "BusIdDisplay";
	}

	/**
	 * @param seat userseats
	 * @param sid schedule id
	 * @param lid login id
	 * @param model model
	 * @throws UserException userdefined exception
	 * @return string
	 *         <p>
	 * 		this is mapping to bookingdetail display page
	 *         </p>
	 */

	// insertion and updating.........
	@RequestMapping("/displayUserBook")
	public String displayUserBook(@RequestParam("noofseatsrequired") Integer seat, @RequestParam("schId") Integer sid,
			@RequestParam("uname") Integer lid, Model model) throws UserException {
		model.addAttribute("slist", ser.getBusUpdate(seat, sid, lid));
		model.addAttribute("llist", dao.getUserBookingDetails(lid));
		return "BookingDetailDisplay";
	}

	/**
	 * @param request request object
	 * @return string
	 *         <p>
	 * 		this is mapping to logout page
	 *         </p>
	 */

	@RequestMapping("/logout")
	public String checkLogin(HttpServletRequest request) {
		HttpSession sess = request.getSession(false);
		sess.invalidate();
		return "LoginPage";
	}

	/**
	 * 
	 * @return string
	 *         <p>
	 * 		this is mapping to home page
	 *         </p>
	 */

	@RequestMapping("/home")
	public String Home() {
		return "Main";
	}

	/**
	 * @param  ex InvalidException
	 * @return ModelAndView
	 *         <p>
	 * 		this is handling exception
	 *         </p>
	 */

	@ExceptionHandler(InvalidException.class)
	public ModelAndView handleException(InvalidException ex) {
		return new ModelAndView("MyErr", "err", ex.getMessage());
	}

	/**
	 * @param  ex UserException
	 * @return ModelAndView
	 *         <p>
	 * 		this is handling exception
	 *         </p>
	 */
	@ExceptionHandler(UserException.class)
	public ModelAndView UserException(UserException ex) {
		return new ModelAndView("Error", "err", ex.getMessage());
	}
}
