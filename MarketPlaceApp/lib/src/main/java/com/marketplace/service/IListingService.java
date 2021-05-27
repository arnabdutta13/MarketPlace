/**
 * 
 */
package com.marketplace.service;

/**
 * @author arnab
 *
 */
public interface IListingService extends IMarketPlaceService {
	
	String createListing(String userName, String title, String description, Double price, String category) throws Exception;
	
	String deleteListing(String userName, String listingId) throws Exception;
	
	String getListing(String userName, String listingId) throws Exception;

}
