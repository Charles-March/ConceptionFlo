package display_swing;

import items.ItemOnMap;
import java.awt.Graphics;
import javax.swing.JPanel;
import main.Main;

public class GrillePannel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6340708146688459670L;

	public GrillePannel(){
		super();
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		for(int i=0;i<Main.grilleX;i++){
			for(int j=0;j<Main.grilleY;j++){
				ItemOnMap item =Main.grille[i][j];
				if(item!=null){
					int pos_x = i*Main.pic_size;
					int pos_y = j*Main.pic_size;
					g.drawImage(item.getImage(), pos_x, pos_y, Main.pic_size, Main.pic_size, null, null);
				}
			}
		}
	}
}
