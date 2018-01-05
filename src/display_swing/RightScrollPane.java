package display_swing;


import java.awt.Dimension;

import javax.swing.JScrollPane;

import main.Main;

public class RightScrollPane extends JScrollPane{
	private static final long serialVersionUID = -4916245979751726651L;
	
	static GrillePannel gp=new GrillePannel();
	public RightScrollPane(){
		super(gp);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.setPreferredSize(new Dimension(Main.grilleX*Main.pic_size,Main.grilleY*Main.pic_size));
		this.setVisible(true);
		gp.setVisible(true);
	}
	
	@Override
	public void repaint(){
		super.repaint();
		if(gp!=null)gp.repaint();
	}
}
