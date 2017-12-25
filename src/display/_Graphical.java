package display;

import items.Item;

import java.util.List;

public interface _Graphical {
	/**
	 * Will create the windows placing all the items from item_list on the current display
	 * this function should also create all the listener needed if needed
	 * 
	 * @param item_list representing all the items available during the mapping
	 */
	void init(List<Item> item_list);
	
}
