package org.springframework.samples.petclinic.detect;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

public class XmlParser {

	public List<String> parseXmlGiveSuggestions(String xml) {
		List<String> list = new ArrayList<>();
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			InputSource inputSource = new InputSource(new StringReader(xml));
			Document doc = dBuilder.parse(inputSource);
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("CompleteSuggestion");
			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					Node nl = eElement.getElementsByTagName("suggestion").item(0);
					Element suggestElement = (Element) nl;
					String suggestion = suggestElement.getAttribute("data");
					list.add(suggestion);
					System.out.println("Suggestion: " + suggestion);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
