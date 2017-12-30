package display_swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JDialog;

public class ChooseBoleanDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2143958985362103192L;
	
	public ChooseBoleanDialog(ConfigurationWindow owner,String name){
		super(owner);
		this.setTitle(name);
		JButton Btrue = new JButton("Vrai");
		JButton Bfalse = new JButton("faux");
		
		this.add(Btrue,BorderLayout.EAST);
		this.add(Bfalse,BorderLayout.WEST);
		
		this.setSize(new Dimension(125,100));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		Btrue.addMouseListener(new MouseListener() {
			
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
				owner.chosen(true);
				destroy_dialog();
			}
		});
		
		Bfalse.addMouseListener(new MouseListener() {
			
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
				owner.chosen(false);
				destroy_dialog();
				
			}
		});
	}
	
	public void destroy_dialog(){
		this.setVisible(false);
		this.setEnabled(false);
	}
}
