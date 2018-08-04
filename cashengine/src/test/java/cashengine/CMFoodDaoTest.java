package cashengine;

import java.io.File;

import javax.xml.bind.JAXBException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cmfoodchain.orderdetails.dao.CMFoodDao;

public class CMFoodDaoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getDetailsFromXmlTest() {
		try {
			Assert.assertNotNull(CMFoodDao
					.getDetailsFromXml(new File("C:\\Workspace\\cashengine\\src\\main\\resources\\branchOrder.xml")));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void getDetailsFromJsonTest() {
		try {
			Assert.assertNotNull(CMFoodDao
					.getDetailsFromJson(new File("C:\\Workspace\\cashengine\\src\\main\\resources\\branchOrder.json")));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
