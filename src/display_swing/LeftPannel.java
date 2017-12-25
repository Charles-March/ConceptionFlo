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
	
	public LeftPannel(){
		super();
		ItemPannel ip = new ItemPannel();
		ip.setLayout(new BorderLayout());
		split_pane.setTopComponent(ip);
		split_pane.setBottomComponent(new FiltersPannel());
		this.add(split_pane);
	}
	
}
