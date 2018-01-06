package display_swing;

import items.ItemOnMap;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import main.Main;

public class ConfigurationWindow extends JFrame{
	private static final long serialVersionUID = -8305498490817098855L;
	Frame_Config_Actuelle config_actuelle;
	public int current_chosing;
	public int x;
	public int y;
	private class pannelConfigs extends JPanel{
		
		private static final long serialVersionUID = -6551203786465208805L;
		public JList<String> ChoixList;
		
		
		public pannelConfigs(ConfigurationWindow owner, int x,int y){
			super();
			String[] Iarray = new String[Main.to_pc_list.size()];
			
			for(int i=0;i<Main.to_pc_list.size();i++){
				Iarray[i]=Main.to_pc_list.get(i).name;
			}
			JButton change_name = new JButton("Changer le nom");
			JButton delete = new JButton("Supprimer");
			ChoixList=new JList<String>(Iarray);
			ChoixList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			ChoixList.setLayoutOrientation(JList.VERTICAL);
			ChoixList.setVisibleRowCount(-1);
			JScrollPane listScroller = new JScrollPane(ChoixList);
			listScroller.setPreferredSize(new Dimension(250, 80));
			this.add(new JLabel("Ensemble des noeuds :"));
			this.add(listScroller);
			this.add(change_name);
			this.add(delete);
			
			ChoixList.setVisible(true);
			this.setVisible(true);
			
			delete.addMouseListener(new MouseListener() {
				
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
					ItemOnMap.deleteItem(x, y);
					Main_swing.on_display_grille_changed();
					closeWindow();
					
				}
			});
			
			change_name.addMouseListener(new MouseListener() {
				
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
					new ChangeNameDialog(owner,x,y);
					
				}
			});
			
			ChoixList.addListSelectionListener(new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if(e.getValueIsAdjusting()){
						current_chosing = ChoixList.getSelectedIndex();
						System.out.println("value changed :"+current_chosing);
						new ChooseBoleanDialog(owner,ChoixList.getSelectedValue());	
					}
					
				}
			});
		}
	}
	
	public ConfigurationWindow(int x, int y){
		super("Configuration de noeud");
		this.x=x;
		this.y=y;
		this.setLayout(new BorderLayout());
		pannelConfigs pc = new pannelConfigs(this,x,y);
		this.add(pc,BorderLayout.CENTER);
		this.setSize(new Dimension(275, 300));
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		
		
		config_actuelle = new Frame_Config_Actuelle(Main.grille[x][y],this);
		config_actuelle.setVisible(true);
		
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				config_actuelle.setVisible(false);
				config_actuelle.setEnabled(false);
				setVisible(false);
				setEnabled(false);
				
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void chosen(boolean b){
		System.out.println(Main.to_pc_list.get(current_chosing).name + " : "+ Boolean.toString(b));
		Main.grille[x][y].addConfig(current_chosing, b);
		config_actuelle.repaint();
	}
	
	public void repaint_config(){
		config_actuelle.repaint();
	}
	
	public void closeWindow(){
		config_actuelle.setVisible(false);
		config_actuelle.setEnabled(false);
		config_actuelle=null;
		
		this.setVisible(false);
		this.setEnabled(false);
	}
	
	
}
