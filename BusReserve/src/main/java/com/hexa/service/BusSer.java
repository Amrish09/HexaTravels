package com.hexa.service;

import com.hexa.dao.UserException;

/**
 * @author Srilatha
 * @author Durga
 *         <p>
 * 		This interface is for service method
 *         </p>
 */

public interface BusSer {

	int getBusUpdate(int userSeats, int schId, int loginId) throws UserException;

}
