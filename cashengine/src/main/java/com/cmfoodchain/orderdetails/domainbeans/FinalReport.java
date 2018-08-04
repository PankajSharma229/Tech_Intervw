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
public class FinalReport {
	Branch branch;

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}
}
