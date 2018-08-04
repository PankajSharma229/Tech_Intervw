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
@XmlRootElement(name = "orderdetail")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderDetail {
	byte orderid;

	float billamount;

	public byte getOrderid() {
		return orderid;
	}

	public void setOrderid(byte orderid) {
		this.orderid = orderid;
	}

	public float getBillamount() {
		return billamount;
	}

	public void setBillamount(float billamount) {
		this.billamount = billamount;
	}

}
