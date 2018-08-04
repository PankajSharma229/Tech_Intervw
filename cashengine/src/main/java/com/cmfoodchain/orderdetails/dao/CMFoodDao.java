/**
 * 
 */
package com.cmfoodchain.orderdetails.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.eclipse.persistence.jaxb.JAXBContextProperties;
import org.eclipse.persistence.jaxb.xmlmodel.ObjectFactory;

import com.cmfoodchain.orderdetails.domainbeans.CMFoodChain;
import com.cmfoodchain.orderdetails.domainbeans.CMFoodChainReport;

/**
 * @author Pankaj
 *
 */
public class CMFoodDao {
	public static CMFoodChain getDetailsFromXml(File file) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(CMFoodChain.class);
		Unmarshaller un = context.createUnmarshaller();
		CMFoodChain foodChain = (CMFoodChain) un.unmarshal(file);
		return foodChain;
	}

	public static CMFoodChain getDetailsFromJson(File file) throws JAXBException {
		Map<String, Object> properties = setJaxBProperties();

		JAXBContext jaxbContext = JAXBContextFactory
				.createContext(new Class[] { CMFoodChain.class, ObjectFactory.class }, properties);

		Unmarshaller un = jaxbContext.createUnmarshaller();
		CMFoodChain foodChain = (CMFoodChain) un.unmarshal(file);
		return foodChain;

	}

	public static void createReport(CMFoodChainReport cmFoodChainReport, boolean isMatched)
			throws JAXBException, IOException {
		Map<String, Object> properties = setJaxBProperties();
		JAXBContext jaxbContext = JAXBContextFactory
				.createContext(new Class[] { CMFoodChainReport.class, ObjectFactory.class }, properties);

		Marshaller marshaller = jaxbContext.createMarshaller();
		FileWriter fileWriter = null;
		try {
			if (isMatched) {
				String fileName = "C:\\Match.json";
				File file = createWritableFile(fileName);
				fileWriter = new FileWriter(file, true);
				marshaller.marshal(cmFoodChainReport, fileWriter);
			} else {
				String fileName = "C:\\Mismatch.json";
				File file = createWritableFile(fileName);
				fileWriter = new FileWriter(file, true);
				marshaller.marshal(cmFoodChainReport, fileWriter);
			}
		} catch (IOException e) {
			throw e;
		} finally {
			fileWriter.flush();
		}
	}

	/**
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	private static File createWritableFile(String fileName) throws IOException {
		File file = new File(fileName);
		file.getParentFile().mkdirs();
		file.getParentFile().setReadable(true, false);
		file.getParentFile().setExecutable(true, false);
		file.getParentFile().setWritable(true, false);
		if (!file.exists())
			file.createNewFile();
		return file;
	}

	private static Map<String, Object> setJaxBProperties() {
		Map<String, Object> properties = new HashMap();
		properties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
		return properties;
	}
}
