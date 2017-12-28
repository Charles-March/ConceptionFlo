package display_swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import items.Configuration;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import main.Main;

public class ConfigurationWindow extends JFrame{
	private static final long serialVersionUID = -8305498490817098855L;

	
	private class pannelConfigs extends JPanel{
		
		private static final long serialVersionUID = -6551203786465208805L;
		public JList<String> ChoixList;
		
		public pannelConfigs(){
			super();
			String[] Iarray = new String[Main.to_pc_list.size()];
			
			for(int i=0;i<Main.to_pc_list.size();i++){
				Iarray[i]=Main.to_pc_list.get(i).name;
			}
			
			ChoixList=new JList<String>(Iarray);
			ChoixList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			ChoixList.setLayoutOrientation(JList.VERTICAL);
			ChoixList.setVisibleRowCount(-1);
			JScrollPane listScroller = new JScrollPane(ChoixList);
			listScroller.setPreferredSize(new Dimension(250, 80));
			this.add(listScroller);
			ChoixList.setVisible(true);
			this.setVisible(true);
		}
	}
	
	public ConfigurationWindow(Configuration c){
		super("Coucou");
		this.setLayout(new BorderLayout());
		this.add(new pannelConfigs(),BorderLayout.CENTER);
		this.setSize(new Dimension(275, 300));
		this.setVisible(true);
	}
}
