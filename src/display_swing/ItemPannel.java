package display_swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
	private Point mousePosition=null;
	public ItemPannel(int size_x, int size_y){
		super();
		setSize(new Dimension(size_x,size_y));
		for(int i=0;i<Main.item_list.size();i++){
			image_list.add(Main.item_list.get(i).getImage());
		}
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mousePosition=arg0.getPoint();
				paintComponent(getGraphics());
			}
		});
	}
	
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		int maxX = (this.getWidth()-20) / Main.pic_size;
		int pos=-1;
		if(mousePosition!=null){
			pos = maxX*((mousePosition.y-20)/Main.pic_size) + (mousePosition.x-20)/Main.pic_size;
		}
		for(int i=0;i<image_list.size() && maxX>0;i++){
			
			int pos_x = 20 +(i%maxX) * Main.pic_size;
			int pos_y = 20 + (i/maxX) * Main.pic_size;
			g.drawImage(image_list.get(i), pos_x, pos_y, Main.pic_size, Main.pic_size, null, null);
		}
		
		if(pos!=-1){
			int pos_x = 20 +(pos%maxX) * Main.pic_size;
			int pos_y = 20 + (pos/maxX) * Main.pic_size;
			g.setColor(new Color(255, 0, 0));
			Main.selected=pos;
			g.drawRect(pos_x, pos_y, Main.pic_size, Main.pic_size);
		}
		
		
		
	}
}
