package scouting.active;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

import scouting.datastorage.Defense;
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
	private SelectionPanel panel;
	private DefenseClickRegion caller;
	
	public SelectionArea(SelectionPanel sp){
		panel = sp;
		this.addActionListener(new SelectionAreaListener());
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
	
	public void display(DefenseClickRegion caller){
		this.caller = caller;
		panel.replaceSelector(this);
	}
	
	public SelectionPanel getSelectionPanel(){
		return panel;
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
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() instanceof JComboBox<?>){
				JComboBox<String> selector =  (JComboBox<String>) e.getSource();
				String selectedItem = (String) selector.getSelectedItem();
				
				char previousDefenseGroup = Defense.findGroup(caller.getDefenseName());
				for(char c: availableGroups){
					if (c == '*'){
						c = previousDefenseGroup;
						break;
					}
				}
				
				caller.setDefenseName(selectedItem);
				
				char defenseGroupPicked = Defense.findGroup(selectedItem);
				for(char c: availableGroups){
					if (c == defenseGroupPicked){
						c = '*';
					}
				}
			}
		}
	}
}

