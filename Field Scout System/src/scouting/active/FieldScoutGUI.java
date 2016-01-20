package scouting.active;

import javax.swing.JFrame;
/**
 * This class extends {@link JFrame} and is the top-level panel in the field scouting gui.
 * It should contain a {@link ClickabeFieldMap}, a {@link SelectionArea}, and a third (as
 * yet undefined) area to enter the information concerning Ranking Points.
 * @author Michael
 *
 */
public class FieldScoutGUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private SelectionArea dropdown;
	
	public FieldScoutGUI(){
		super("Field Scouting System v1.0");
		
	}
	
	public SelectionArea getSelectionArea(){
		return dropdown;
	}
}
