/**
 * 
 */
package com.marketplace.service;

/**
 * @author arnab
 *
 */
public interface ICategoryService extends IMarketPlaceService {

	String getCategory(String userName, String catrgory, String sortFieldName, String sortOrder) throws Exception;
	
	String getTopCategory(String userName) throws Exception;
}
