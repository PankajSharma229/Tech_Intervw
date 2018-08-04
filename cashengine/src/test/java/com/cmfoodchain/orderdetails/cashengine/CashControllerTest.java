package com.cmfoodchain.orderdetails.cashengine;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CashControllerTest {

	CashController cashController;

	@Before
	public void setUp() throws Exception {
		cashController = new CashController();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void calculatetest() {
		org.junit.Assert.assertTrue(cashController.compute());
	}

}
