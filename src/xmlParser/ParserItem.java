package xmlParser;

import items.Item;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class ParserItem {
	
	
	static public Item parse(String FilePath){
		SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser;
		try {
			parser = factory.newSAXParser();
	        File f=new File(FilePath);
	        Import_Item imp = new Import_Item();
			parser.parse(f, imp);
			return new Item(imp.id,imp.image,imp.inCount,imp.outCount,imp.toController,imp.fromController);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
