package xmlParser;

import items.Group;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class ParserGroup {
	
	
	static public Group parse(String FilePath){
		SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser;
		try {
			parser = factory.newSAXParser();
	        File f=new File(FilePath);
	        Import_Group imp = new Import_Group();
			parser.parse(f, imp);
			return new Group(imp.groupName,imp.item_list);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
