/**
 * 
 */
package com.marketplace.service;

import com.marketplace.entity.User;

/**
 * @author arnab
 *
 */
public interface IUserMgmtService extends IMarketPlaceService  {
	
	String registerUser(String userName) throws Exception;
	
	User getUserByUserName(String userName) throws Exception;

}
