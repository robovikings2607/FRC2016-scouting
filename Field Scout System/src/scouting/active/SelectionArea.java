package scouting.active;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
/**
 * This class extends JComboBox and is the method of selecting which defense goes in the
 * selected position. It interacts primarily with {@link DefenseClickRegion}.
 * @author Michael
 *
 */
public class SelectionArea extends JComboBox<String>{
	
	private static final long serialVersionUID = 1L;
	public static final String emptyText = "(none)"; 
	
	private char[] availableGroups;
	
	public SelectionArea(){
		setEnabled(true);
		setEditable(false);
	}
	
	public void showSelector(char callingDefense){
		removeAllItems();
		for(char c: availableGroups){
			addGroup(c);
		}
		addGroup(callingDefense);
	}
	
	private void addGroup(char groupLetter){
		switch (Character.toUpperCase(groupLetter)){
		case 'A':
			addItem("Cheval de Frise");
			addItem("Portcullis");
		case 'B':
			addItem("Moat");
			addItem("Ramparts");
		case 'C':
			addItem("Drawbridge");
			addItem("Sally Port");
		
		case 'D':
			addItem("Rock Wall");
			addItem("Rough Terrain");
		}
	}
	
	private class SelectionAreaListener implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
}

