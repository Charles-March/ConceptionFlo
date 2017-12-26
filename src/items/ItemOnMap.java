package items;

import java.awt.Image;

import main.Main;

public class ItemOnMap {
	public int refId;
	public int toControllerid;
	public int fromControllerid;
	public ItemOnMap next;
	
	
	public Image getImage(){
		return Main.item_list.get(refId).getImage();
	}
	
	public ItemOnMap(Item i){
		
		refId = i.id;
		
		if(i.toController==1){
			Main.toController++;
			toControllerid = Main.toController;
		}
		else{
			
		}
		
		if(i.fromController==1){
			Main.fromController++;
			fromControllerid=Main.fromController;
		}
		else{
			
		}
		
	}
}
