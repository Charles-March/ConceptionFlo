package display_swing;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.Main;

public class ChangeNameDialog extends JDialog{
	private static final long serialVersionUID = 7235832392537131415L;
	JTextField name_row = new JTextField();
	
	public ChangeNameDialog(int x,int y){
		super(Main_swing.mw);
	    this.setLayout(new GridLayout(1, 2));
		setTitle("Changement de nom");
		this.add(new JLabel("Nom : "));
		this.add(name_row);
		this.setSize(new Dimension(250,75));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		name_row.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					Main.grille[x][y].name=name_row.getText();
					Main_swing.on_name_changed();
					destroy_dialog();
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public ChangeNameDialog(JFrame owner,int x,int y){
		super(owner);
	    this.setLayout(new GridLayout(1, 2));
		setTitle("Changement de nom");
		this.add(new JLabel("Nom : "));
		this.add(name_row);
		this.setSize(new Dimension(250,75));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		name_row.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					Main.grille[x][y].name=name_row.getText();
					Main_swing.on_name_changed();
					destroy_dialog();
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void destroy_dialog(){
		this.setVisible(false);
		this.setEnabled(false);
	}
	
	
}
