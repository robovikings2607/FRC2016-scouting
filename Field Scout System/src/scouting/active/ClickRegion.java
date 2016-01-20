package scouting.active;

import javax.swing.JPanel;
/**
 * A ClickRegion is the basic class that describes a clickable area on a {@link ClickableFieldMap}.
 * It provides no functionality on its own, and any desired event listeners should be overridden in subclasses.
 * @author Michael
 *
 */
public class ClickRegion extends JPanel{

	private static final long serialVersionUID = 1L;
	private FieldScoutGUI parentFrame;
	
	public ClickRegion(FieldScoutGUI parentFrame){
		this.parentFrame = parentFrame;
	}

	public FieldScoutGUI getParentFrame() {
		return parentFrame;
	}
}
