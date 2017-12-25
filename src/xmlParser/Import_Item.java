package xmlParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Import_Item extends DefaultHandler {
	
	private boolean bid;
	private boolean bimage;
	private boolean binCount;
	private boolean boutCount;
	private boolean btoController;
	private boolean bfromController;
	
	public int id;
	public String image;
	public int inCount;
	public int outCount;
	public int toController;
	public int fromController;
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("id")){ 
			bid=true;
		} else if (qName.equalsIgnoreCase("image")) {
			bimage=true;
		} else if (qName.equalsIgnoreCase("inCount")) {
			binCount = true;
		} else if (qName.equalsIgnoreCase("outCount")){
			boutCount = true;
		} else if (qName.equalsIgnoreCase("toController")){
			btoController = true;
		} else if (qName.equalsIgnoreCase("fromController")){
			bfromController = true;
		}
	}
	
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if (qName.equalsIgnoreCase("item")) {
				
			}
		}
		
		public void characters(char ch[], int start, int length) throws SAXException {
			String lecture = new String(ch, start, length);
			if (bid) {
				id=Integer.parseInt(lecture);
				bid=false;
			} else if (bimage) {
				image=lecture;
				bimage=false;
			} else if (binCount){
				inCount=Integer.parseInt(lecture);
				binCount=false;
			} else if(boutCount){
				outCount=Integer.parseInt(lecture);
				boutCount=false;
			} else if (btoController){
				toController=Integer.parseInt(lecture);
				btoController=false;
			} else if(bfromController){
				fromController=Integer.parseInt(lecture);
				bfromController=false;
			} 
			
		}
	}
