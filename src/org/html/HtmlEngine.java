package org.html;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.xml.XML_XSL;

public class HtmlEngine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		XML_XSL TranformOBj= new XML_XSL();
		
		String HtmlXml=TranformOBj.XmlXslTranform("nmap.xml", "nmap.xsl");
		
		System.out.println(HtmlXml);
		for(int i=0;i<=100;i++){
			System.out.println("---------------------");
		}
		
		
		Document doc = Jsoup.parse(HtmlXml);

		
		for (Element table : doc.select("hr[class]")) {
			Element contentDiv = table.select("h2[class]").first();
			System.out.println(table+"\t"+contentDiv);
		}
		
	}
	
	   ArrayList getDivsByClass(String CSSClassname)
	    {
	        ArrayList divList = new ArrayList();

	        //TagNode divElements[] = rootNode.getElementsByName("div", true);
	        //for (int i = 0; divElements != null && i < divElements.length; i++)
	        //{
	         //   String classType = divElements[i].getAttributeByName("class");
	          //  if (classType != null && classType.equals(CSSClassname))
	           // {
	           //     divList.add(divElements[i]);
	            //}
	        //}

	        return divList;
	    }

}
