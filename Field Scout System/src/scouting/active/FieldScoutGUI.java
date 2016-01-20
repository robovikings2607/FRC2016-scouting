package scouting.active;

import javax.swing.JFrame;

public class FieldScoutGUI extends JFrame{
	
	private SelectionArea dropdown;
	
	public FieldScoutGUI(){
		super("Field Scouting System v1.0");
		
	}
	
	public SelectionArea getSelectionArea(){
		return dropdown;
	}
}
