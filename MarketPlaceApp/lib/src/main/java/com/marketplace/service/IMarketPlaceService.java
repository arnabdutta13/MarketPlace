/**
 * 
 */
package com.marketplace.service;

import com.marketplace.entity.Command;

/**
 * @author arnab
 *
 */
public interface IMarketPlaceService {
	
	Object process(Command c, String[] params) throws Exception;
	
	void validateCommand(Command c, String[] params) throws Exception;

}
