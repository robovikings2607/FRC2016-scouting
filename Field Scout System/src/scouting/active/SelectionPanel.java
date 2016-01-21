package scouting.active;

import javax.swing.JPanel;

public class SelectionPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void replaceSelector(SelectionArea selector){
		removeAll();
		add(selector);
	}
}
