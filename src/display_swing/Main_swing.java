package display_swing;

import items.Item;
import java.util.List;
import main.Main;
import display._Graphical;

public class Main_swing implements _Graphical{

	static MainWindow mw;
	static boolean display_grille=false;
	
	@Override
	public void init(List<Item> item_list) {
		mw = new MainWindow(Main.frame_X, Main.frame_Y, Main.frame_Name,item_list);
		mw.setVisible(true);
	}
	
	public static void on_display_grille_changed(){
		mw.split_pane.getRightComponent().repaint();
	}

}
