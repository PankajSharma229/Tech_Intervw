package com.cmfoodchain.orderdetails.domainbeans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cmfoodchain")
@XmlAccessorType(XmlAccessType.FIELD)
public class CMFoodChainReport {
	Branch branch;

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}
}
