import java.util.Scanner;
import java.io.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import org.xml.sax.*;

class XPathProcessor{
	public static void main(String args[]){
		try{
			Scanner scanner = new Scanner(System.in);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse("Greycell.xml");
							
			System.out.println("Enter the Expression: ");
			String expression = scanner.nextLine();
			
			XPathExpression xPath = XPathFactory.newInstance().newXPath().compile(expression);
			Object eve = xPath.evaluate(doc, XPathConstants.NODESET);
						
			NodeList nodes = (NodeList) eve;
			
			for(int i=0; i<nodes.getLength();i++){
				Element element = (Element)nodes.item(i);
				System.out.println("<"+element.getNodeName()+">"+nodes.item(i).getTextContent()+"</"+element.getNodeName()+">");
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}