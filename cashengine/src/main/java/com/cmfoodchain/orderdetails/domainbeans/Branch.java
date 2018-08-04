package com.cmfoodchain.orderdetails.domainbeans;
/**
 * 
 */

/**
 * @author Pankaj
 *
 */
public class Branch {
	String location;
	float totalcollection;
	float sumoforder;
	String locationid;

	public float getSumoforder() {
		return sumoforder;
	}

	public void setSumoforder(float sumoforder) {
		this.sumoforder = sumoforder;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public float getTotalcollection() {
		return totalcollection;
	}

	public void setTotalcollection(float totalcollection) {
		this.totalcollection = totalcollection;
	}

	public String getLocationid() {
		return locationid;
	}

	public void setLocationid(String locationid) {
		this.locationid = locationid;
	}

}
