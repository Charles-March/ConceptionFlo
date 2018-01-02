package main;

import items.Connection;
import items.Group;
import items.Item;
import items.ItemOnMap;

import java.util.LinkedList;
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
	
	
	public static int selected = -1;
	public static int selectedGroup = -1;
	public static List<Item> item_list;
	public static List<Group> group_list;
	public static ItemOnMap[][] grille;
	
	public static int toController=0;
	public static List<ItemOnMap> to_pc_list = new LinkedList<ItemOnMap>(); 
	public static int fromController=0;
	
	public static List<Connection> connection_list = new LinkedList<Connection>();
	public static _Graphical disp = new Main_swing();
	
	public static void main(String[] argc){
		init_grille();
		item_list = Item.all_items();
		group_list= Group.get_all_groups();
		disp.init(item_list);
	}
	
	private static void init_grille(){
		grille = new ItemOnMap[grilleX][];
		for(int i=0;i<grilleX;i++){
			grille[i]=new ItemOnMap[grilleY];
			for(int j=0;j<grilleY;j++){
				grille[i][j]=null;
			}
		}
	}
	
}
