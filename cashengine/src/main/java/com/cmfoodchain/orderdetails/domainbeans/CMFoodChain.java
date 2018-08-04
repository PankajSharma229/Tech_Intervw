/**
 * 
 */
package com.cmfoodchain.orderdetails.domainbeans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Pankaj
 *
 */
@XmlRootElement(name = "cmfoodchain")
@XmlAccessorType(XmlAccessType.FIELD)
public class CMFoodChain {
	Branch branch;
	Orders orders;

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

}
