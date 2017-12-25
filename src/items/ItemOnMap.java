package items;

import java.awt.Image;

import main.Main;

public class ItemOnMap {
	public int refId;
	public int toControllerid;
	public int fromControllerid;
	public Item next;
	
	public Image getImage(){
		return Main.item_list.get(refId).getImage();
	}
}
