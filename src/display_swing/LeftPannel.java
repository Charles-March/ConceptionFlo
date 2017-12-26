package display_swing;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;



public class LeftPannel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8221576319528886598L;

	public JSplitPane split_pane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	
	public LeftPannel(int size_x,int size_y){
		super();
		ItemPannel ip = new ItemPannel(size_x, size_y-150);
		ip.setLayout(new BorderLayout());
		this.setLayout(new BorderLayout());
		split_pane.setTopComponent(ip);
		split_pane.setDividerLocation(size_y-150);
		split_pane.setBottomComponent(new FiltersPannel());
		this.add(split_pane,BorderLayout.CENTER);
		this.setSize(size_x,size_y);
	}
	
}
