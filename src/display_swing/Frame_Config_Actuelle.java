package display_swing;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;

import items.BooleanEquation;
import items.ItemOnMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Main;

public class Frame_Config_Actuelle extends JFrame{
	private static final long serialVersionUID = 4276734847310297053L;
	pannelConfigs pc;
	
	private class pannelConfigs extends JPanel{
		private static final long serialVersionUID = 3565091823818812340L;
		ItemOnMap item;
		public pannelConfigs(ItemOnMap i){
			item=i;
		}
		
		@Override
		public void paintComponent(Graphics g){
			List<BooleanEquation> lbe = item.config.equation_list;
			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
			for(int i=0;i<lbe.size();i++){
				BooleanEquation be = lbe.get(i);
				String s = Main.to_pc_list.get(be.id).name + " : " + Boolean.toString(be.state);
				g.drawChars(s.toCharArray(), 0, s.length(), (10), (20)+ (i*20));
			}
		}
		
	}
	public Frame_Config_Actuelle(ItemOnMap item){
		super("Configuration ("+item.name+")");
		pc = new pannelConfigs(item);
		this.add(pc);
		this.setSize(new Dimension(250,150));
		this.setAlwaysOnTop(true);
		
	}
	public void repaint_config(){
		pc.repaint();
	}

}
