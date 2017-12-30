package xmlParser;

import items.Item_In_Group;

import java.util.LinkedList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Import_Group extends DefaultHandler {
	
	private boolean bid;
	private boolean bname;
	private boolean bitem;
	private boolean bgroupname;
	private boolean bgroup;
	
	
	
	private int id;
	private String name;
	
	public String groupName;
	public LinkedList<Item_In_Group> item_list = new LinkedList<Item_In_Group>();
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("id")){ 
			bid=true;
		} else if (qName.equalsIgnoreCase("name")) {
			bname=true;
		} else if (qName.equalsIgnoreCase("item")) {
			bitem = true;
		} else if (qName.equalsIgnoreCase("groupname")){
			bgroupname = true;
		} else if (qName.equalsIgnoreCase("group")){
			bgroup = true;
		}
	}
	
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if (qName.equalsIgnoreCase("item")) {
				item_list.add(new Item_In_Group(id, name));
			}
		}
		
		public void characters(char ch[], int start, int length) throws SAXException {
			String lecture = new String(ch, start, length);
			if (bid) {
				id=Integer.parseInt(lecture);
				bid=false;
			} else if (bname) {
				name=lecture;
				bname=false;
			} else if (bitem){
				bitem=false;
			} else if(bgroupname){
				groupName=lecture;
				bgroupname=false;
			} else if (bgroup){
				bgroup=false;
			}
			
		}
	}
