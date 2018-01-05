package display_swing;

import items.Group;
import items.Item_In_Group;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import main.Main;

public class GroupPannel extends JPanel{

	private static final long serialVersionUID = 9145802623507535958L;
	public GroupPannel(){
		super();
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				leftClick(e.getPoint());
			}
		});
	}
	
	private void leftClick(Point mousePosition){
		int pos_y = (mousePosition.y-20)/Main.pic_size;
		Main.selected=-1;
		Main.selectedGroup=pos_y;
		Main_swing.repaintLeft();
		paintComponent(getGraphics());
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		for(int i=0;i<Main.group_list.size();i++){
			System.out.println("Paint group");
			Group gr = Main.group_list.get(i);
			
			String s = gr.entireName;
			g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
			g.drawChars(s.toCharArray(), 0, s.length(), 10, 20 + i*Main.pic_size);
			int j;
			for(j=0;j<gr.item_list.size();j++){
					Item_In_Group ig = gr.item_list.get(j);
					g.drawImage(Main.item_list.get(ig.id).getImage(), 20 + Main.pic_size*j, 30 + i*(Main.pic_size*2),Main.pic_size,Main.pic_size, null, null);
						
			}
			if(Main.selectedGroup==i){
				g.setColor(new Color(150,50,50));
				g.drawRect(20, 30 + i*(Main.pic_size*2),  ((Main.pic_size*gr.item_list.size())), Main.pic_size);
			}
		}
	}
}
