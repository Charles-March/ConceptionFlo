package display_swing;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class FiltersPannel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6527030627124245523L;

	JCheckBox grille = new JCheckBox("grille");
	
	public FiltersPannel(){
		super();
		this.add(grille);
	}
}
