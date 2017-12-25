package items;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

import xmlParser.ParserItem;

public class Item {
	static final String systemSeparator = "\\";
	Image image;
	public int id;
	public int inCount;
	public int outCount;
	public int toController;
	public int fromController;
	
	public Image getImage(){
		return image;
	}
	
	public static List<Item> all_items(){
		File repertoire = new File(System.getProperty("user.dir") + systemSeparator + "items");
		File[] files=repertoire.listFiles();
		List<Item> itemList = new LinkedList<Item>();
		for(int i=0;i<files.length;i++){
			if(files[i].isFile() && files[i].getName().endsWith(".xml")){
				itemList.add(new Item(files[i].getAbsolutePath()));
			}
		}
		return itemList;
	}
	
	public Item(String filename){
		Item i =ParserItem.parse(filename);	
		if(i==null){
			System.out.println("Probleme avec l'item : "+filename);
		}
		else{
			copy(i);	
		}
	}
	
	public Item(int id,String image,int inCount, int outCount,int toController,int fromController){
		this.id=id;
		try {
			this.image=ImageIO.read(new File(System.getProperty("user.dir") + systemSeparator + "items" + systemSeparator + "pictures" + systemSeparator + image));
		} catch (MalformedURLException e) {
			System.out.println("URL Image incorrecte pour item : "+id);
			System.out.println(System.getProperty("user.dir") + systemSeparator + "items" + systemSeparator + "pictures" + systemSeparator + image);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Image introuvable pour item : "+id);
			e.printStackTrace();
		}
		this.inCount=inCount;
		this.outCount=outCount;
		this.toController=toController;
		this.fromController=fromController;
	}
	
	private void copy(Item i){
		this.id=i.id;
		this.image = i.image;
		this.inCount=i.inCount;
		this.outCount=i.outCount;
		this.toController=i.toController;
		this.fromController=i.fromController;
	}
}
