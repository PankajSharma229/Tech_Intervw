package com.cmfoodchain.orderdetails.cashengine;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.cmfoodchain.orderdetails.dao.CMFoodDao;
import com.cmfoodchain.orderdetails.domainbeans.Branch;
import com.cmfoodchain.orderdetails.domainbeans.CMFoodChain;
import com.cmfoodchain.orderdetails.domainbeans.CMFoodChainReport;
import com.cmfoodchain.orderdetails.domainbeans.OrderDetail;

/**
 * 
 *
 */
public class CashController {

	// Constants
	private static String FOLDER_LOCATION = "C:\\Workspace\\cashengine\\src\\main\\resources\\";
	private static String XML = "xml";
	private static String JSON = "json";

	public boolean compute() {
		// Read file
		CMFoodChain cmFoodChain = null;
		File folders = new File(FOLDER_LOCATION);
		CMFoodChainReport finalReport = new CMFoodChainReport();
		List<Branch> branchList = new ArrayList<>();

		try {
			for (File file : folders.listFiles()) {

				cmFoodChain = populateFoodChainBean(cmFoodChain, file);

				float totalBill = calculateTotalCollection(cmFoodChain);
				cmFoodChain.getBranch().setSumoforder(totalBill);
				branchList.add(cmFoodChain.getBranch());

			}
			generateReport(finalReport, branchList);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * @param cmFoodChain
	 * @param totalBill
	 * @throws IOException
	 * @throws JAXBException
	 */
	public void generateReport(CMFoodChainReport cmFoodChainReport, List<Branch> branchList)
			throws JAXBException, IOException {
		for (Branch branch : branchList) {
			cmFoodChainReport.setBranch(branch);
			if (branch.getSumoforder() == branch.getTotalcollection()) {
				// append matching file
				CMFoodDao.createReport(cmFoodChainReport, true);
			} else {
				// append non-maching file
				CMFoodDao.createReport(cmFoodChainReport, false);
			}
		}

	}

	/**
	 * @param cmFoodChain
	 * @return
	 */
	private float calculateTotalCollection(CMFoodChain cmFoodChain) {
		float totalBill = 0;
		for (OrderDetail orderDetail : cmFoodChain.getOrders().getOrderdetail()) {
			totalBill += orderDetail.getBillamount();
		}
		return totalBill;
	}

	/**
	 * @param cmFoodChain
	 * @param file
	 * @return
	 * @throws Exception
	 */
	private CMFoodChain populateFoodChainBean(CMFoodChain cmFoodChain, File file) throws Exception {
		String fileName = file.getName();
		String extension = null;
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
			extension = fileName.substring(fileName.lastIndexOf(".") + 1);
		}
		if (XML.equals(extension)) {
			cmFoodChain = CMFoodDao.getDetailsFromXml(file);
		} else if (JSON.equals(extension)) {
			cmFoodChain = CMFoodDao.getDetailsFromJson(file);
		} else {
			throw new Exception("Invalid file formate. Only xml/json is allowed");
		}
		return cmFoodChain;
	}
}
