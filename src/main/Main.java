package main;

import items.Item;
import items.ItemOnMap;

import java.util.List;

import display._Graphical;
import display_swing.Main_swing;

public final class Main {
	
	public static final int grilleX = 100;
	public static final int grilleY = 100;
	
	public static final int frame_X=1366;
	public static final int frame_Y=768;
	public static final String frame_Name = "Prototype 1";
	public static final int pic_size=32;
	
	
	public static int selected = 0;
	
	public static List<Item> item_list;
	public static ItemOnMap[][] grille;
	
	public static int toController=0;
	public static int fromController=0;
	
	
	public static void main(String[] argc){
		_Graphical disp = new Main_swing();
		init_grille();
		item_list = Item.all_items();
		disp.init(item_list);
		grille[1][1]=new ItemOnMap(item_list.get(0));
	}
	
	private static void init_grille(){
		grille = new ItemOnMap[grilleX][];
		for(int i=0;i<grilleX;i++){
			grille[i]=new ItemOnMap[grilleY];
		}
	}
	
}
