package display_swing;

import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;
import main.Main;

public class ItemPannel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4085329351190259306L;
	private List<Image> image_list = new LinkedList<Image>();
	
	public ItemPannel(){
		super();
		for(int i=0;i<Main.item_list.size();i++){
			image_list.add(Main.item_list.get(i).getImage());
		}	
	}
	
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		int maxX = (this.getWidth()-20) / Main.pic_size;
		for(int i=0;i<image_list.size() && maxX>0;i++){
			int pos_x = 20 +(i%maxX) * Main.pic_size;
			int pos_y = 20 + (i/maxX) * Main.pic_size;
			g.drawImage(image_list.get(i), pos_x, pos_y, Main.pic_size, Main.pic_size, null, null);
		}
	}
}
