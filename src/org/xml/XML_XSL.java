package org.xml;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


public class XML_XSL {

	private String myTransformer (String sourceID, String xslID)
			throws TransformerException, TransformerConfigurationException {

		// Create a transform factory instance.
		TransformerFactory tfactory = TransformerFactory.newInstance();

		// Create a transformer for the stylesheet.
		Transformer transformer = tfactory.newTransformer(new StreamSource(new File(xslID)));

		// Transform the source XML to System.out.
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		//transformer.transform(new StreamSource(new File(sourceID)),new StreamResult(System.out));
		transformer.transform(new StreamSource(new File(sourceID)),new StreamResult(outStream));
		return outStream.toString();
	}

	public static void main(String args[]) {
		XML_XSL TranformOBj= new XML_XSL();
		
		System.out.println(TranformOBj.XmlXslTranform("nmap.xml", "nmap.xsl"));

		
	}
	
	public String XmlXslTranform(String xmlFile,String xslFile){
		// set the TransformFactory to use the Saxon TransformerFactoryImpl method 
		//System.setProperty("javax.xml.transform.TransformerFactory",
			//	"net.sf.saxon.TransformerFactoryImpl");

		String results = null;
		
		try {
			results=(myTransformer (xmlFile, xslFile));
		} catch (Exception ex) {
			handleException(ex);
		}
		
		return results;
	}

	
	
	
	private void handleException(Exception ex) {
		System.out.println("EXCEPTION: " + ex);
		ex.printStackTrace();
	}



}
