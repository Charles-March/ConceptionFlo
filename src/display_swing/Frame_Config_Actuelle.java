package display_swing;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import items.BooleanEquation;
import items.ItemOnMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Main;

public class Frame_Config_Actuelle extends JFrame{
	private static final long serialVersionUID = 4276734847310297053L;
	pannelConfigs pc;
	ConfigurationWindow owner;
	private class pannelConfigs extends JPanel{
		private static final long serialVersionUID = 3565091823818812340L;
		ItemOnMap item;
		
		public pannelConfigs(ItemOnMap i){
			item=i;
			
			this.addMouseListener(new MouseListener() {
				
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
					leftclick(e.getPoint());
					
				}
			});
		}
		
		public void leftclick(Point mousePosition){
			int pos_y = ((mousePosition.y-20)/20);
			List<BooleanEquation> lbe = item.config.equation_list;
			System.out.println("pos_y = "+pos_y);
			if(pos_y<lbe.size()){
				System.out.println("removed");
				lbe.remove(pos_y);	
				this.showAgain();
			}
			
			
		}
		
		public void showAgain(){
			paintComponent(getGraphics());
			if(getSize().width==250) setSize(new Dimension(251,150));
			else setSize(new Dimension(250,150));
			owner.repaint_config();
		}
		
		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(getGraphics());
			List<BooleanEquation> lbe = item.config.equation_list;
			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
			for(int i=0;i<lbe.size();i++){
				BooleanEquation be = lbe.get(i);
				String s = Main.to_pc_list.get(be.id).name + " : " + Boolean.toString(be.state);
				g.drawChars(s.toCharArray(), 0, s.length(), (10), (20)+ (i*20));
			}
		}
		
	}
	public Frame_Config_Actuelle(ItemOnMap item,ConfigurationWindow owner){
		super("Configuration ("+item.name+")");
		pc = new pannelConfigs(item);
		this.owner=owner;
		this.add(pc);
		this.setSize(new Dimension(250,150));
		this.setAlwaysOnTop(true);
		
	}
	public void repaint_config(){
		pc.repaint();
	}

}
