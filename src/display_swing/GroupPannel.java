package display_swing;

import items.Group;
import items.Item_In_Group;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import main.Main;

public class GroupPannel extends JPanel{

	private static final long serialVersionUID = 9145802623507535958L;

	public GroupPannel(){
		super();
	}
	
	@Override
	public void paintComponent(Graphics g){
		for(int i=0;i<Main.group_list.size();i++){
			Group gr = Main.group_list.get(i);
			String s = gr.name;
			g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
			g.drawChars(s.toCharArray(), 0, s.length(), 10, 20 + i*Main.pic_size);
			for(int j=0;j<gr.item_list.size();j++){
				Item_In_Group ig = gr.item_list.get(j);
				g.drawImage(Main.item_list.get(ig.id).getImage(), 20 + Main.pic_size*j, 30 + i*(Main.pic_size*2), null, null);
			}
		}
	}
}
