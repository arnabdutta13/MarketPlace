/**
 * 
 */
package com.marketplace.data;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import com.marketplace.entity.Category;
import com.marketplace.entity.Listing;
import com.marketplace.entity.User;

/**
 * @author arnab
 *
 */
public class MarketPlaceData {
	
	private static long LISTING_ID = 100000;
	
	private static MarketPlaceData marketPlaceData = new MarketPlaceData();
	
	private Map<String, User> userData = new ConcurrentHashMap<>();
	
	private Map<String, Listing> listingData = new ConcurrentHashMap<>();
	
	private Map<String, Category> categoryData = new ConcurrentHashMap<>();
	
	private TreeMap<Category, Integer> categoryFreqDataCache = new TreeMap<>();

	private MarketPlaceData() {}
	
	public static MarketPlaceData getInstance() {
		return marketPlaceData;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return marketPlaceData;
	}

	public Map<String, User> getUserData() {
		return userData;
	}

	public void setUserData(Map<String, User> userData) {
		this.userData = userData;
	}

	public Map<String, Listing> getListingData() {
		return listingData;
	}

	public void setListingData(Map<String, Listing> listingData) {
		this.listingData = listingData;
	}

	public Map<String, Category> getCategoryData() {
		return categoryData;
	}

	public void setCategoryData(Map<String, Category> categoryData) {
		this.categoryData = categoryData;
	}
	
	public TreeMap<Category, Integer> getCategoryFreqDataCache() {
		return categoryFreqDataCache;
	}

	public void setCategoryFreqDataCache(TreeMap<Category, Integer> categoryFreqDataCache) {
		this.categoryFreqDataCache = categoryFreqDataCache;
	}

	public synchronized long getListingId() {
		LISTING_ID = LISTING_ID + 1;
		return LISTING_ID;
	}
	
}
