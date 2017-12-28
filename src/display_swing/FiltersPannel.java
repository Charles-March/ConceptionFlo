package display_swing;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FiltersPannel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6527030627124245523L;

	JCheckBox grille = new JCheckBox("Grille");
	JCheckBox connectors = new JCheckBox("Connecteurs");
	JCheckBox names = new JCheckBox("Noms");
	public FiltersPannel(){
		super();
		this.add(grille);
		this.add(connectors);
		this.add(names);
		
		names.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				Main_swing.display_names=names.isSelected();
				Main_swing.on_display_names_changed();
			}
		});
		
		
		connectors.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				Main_swing.display_conectors=connectors.isSelected();
				Main_swing.on_display_connectors_changed();
			}
		});
		
		grille.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				Main_swing.display_grille=grille.isSelected();
				Main_swing.on_display_grille_changed();
			}
		});
	}
}
