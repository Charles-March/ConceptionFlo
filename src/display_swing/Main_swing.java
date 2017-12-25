package display_swing;

import items.Item;
import java.util.List;
import main.Main;
import display._Graphical;

public class Main_swing implements _Graphical{

	MainWindow mw;
	
	@Override
	public void init(List<Item> item_list) {
		mw = new MainWindow(Main.frame_X, Main.frame_Y, Main.frame_Name,item_list);
		mw.setVisible(true);
		
	}

}
