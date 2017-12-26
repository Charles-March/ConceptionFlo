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

	JCheckBox grille = new JCheckBox("grille");
	
	public FiltersPannel(){
		super();
		this.add(grille);
		grille.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				Main_swing.display_grille=grille.isSelected();
				Main_swing.on_display_grille_changed();
			}
		});
	}
}
