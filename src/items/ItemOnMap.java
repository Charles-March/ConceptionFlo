package items;

import java.awt.Image;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import main.Main;

public class ItemOnMap {
	public int refId;
	public List<Integer> toControllerid=new LinkedList<Integer>();
	public List<Integer> fromControllerid=new LinkedList<Integer>();
	public ItemOnMap next;
	public Configuration config;
	public String name;
	
	
	public Image getImage(){
		return Main.item_list.get(refId).getImage();
	}
	
	public ItemOnMap(Item i){
		refId = i.id;
		
		if(i.toController>0){
			Main.to_pc_list.add(this);
			name="Output"+(Main.toController+1);
			for(int j=0;j<i.toController;j++){
				Main.toController++;
				toControllerid.add(new Integer(Integer.valueOf(Main.toController)));
			}
			
		}
		else{
			
		}
		
		if(i.fromController>0){
			name="Input"+(Main.fromController+1);
			for(int j=0;j<i.fromController;j++){
				Main.fromController++;
				fromControllerid.add(new Integer(Main.fromController));
			}
		}
		else{
			
		}
		
	}
	
	public static boolean toNext(Point from, Point to){
		if(Main.grille[from.x][from.y]!=null && Main.grille[to.x][to.y]!=null){
			Connection c =new Connection(from,to);
			if(!Connection.isOnList(c)){
				Main.connection_list.add(c);
				System.out.println("Connection added");
				Main.disp.repaintGrid();
				return true;
			}
		}
		return false;
		
	}
}
