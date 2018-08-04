package com.cmfoodchain.orderdetails.domainbeans;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "orders")
@XmlAccessorType(XmlAccessType.FIELD)
public class Orders {

	@XmlElement(name = "orderdetail")
	private List<OrderDetail> orderdetail = null;

	public List<OrderDetail> getOrderdetail() {
		return orderdetail;
	}

	public void setOrderdetail(List<OrderDetail> orderdetail) {
		this.orderdetail = orderdetail;
	}

}
