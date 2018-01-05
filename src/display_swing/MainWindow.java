package display_swing;

import items.Item;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import main.Main;

public class MainWindow extends JFrame{
	
	private static final long serialVersionUID = 3795702711244761199L;
	
	JSplitPane split_pane = new JSplitPane();
	
	public MainWindow(int sizeX, int sizeY, String title,List<Item> item_list){
		super(title);
		setSize(new Dimension(sizeX,sizeY));
		addListener();
		LeftPannel lp = new LeftPannel(Main.frame_X/4,Main.frame_Y);
		split_pane.setLeftComponent(lp);
		split_pane.setRightComponent(new RightScrollPane());
		split_pane.setDividerLocation(Main.frame_X/4);
		lp.setSize(new Dimension(Main.frame_X/4,Main.frame_Y));
		this.add(split_pane);
	}
	
	private void addListener(){
		this.addWindowListener(new WindowListener() {
					
				@Override
				public void windowOpened(WindowEvent e) {
					// TODO Auto-generated method stub
				}
				
				@Override
				public void windowIconified(WindowEvent e) {
					// TODO Auto-generated method stub
				}
				
				@Override
				public void windowDeiconified(WindowEvent e) {
					// TODO Auto-generated method stub
				}
				
				@Override
				public void windowDeactivated(WindowEvent e) {
					// TODO Auto-generated method stub
				}
				
				@Override
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
				
				@Override
				public void windowClosed(WindowEvent e) {
					System.exit(0);
				}
				
				@Override
				public void windowActivated(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
	}
	
	public void newNameValidation(String name){
		
	}

}
