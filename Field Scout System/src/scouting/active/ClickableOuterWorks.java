package scouting.active;

import scouting.datastorage.Defense;
import scouting.datastorage.OuterWorks;

public class ClickableOuterWorks {
	private DefenseClickRegion[] defenses;
	private char[] availableGroups = {'A', 'B', 'C', 'D'};
	private SelectionPanel selector;
	
	public ClickableOuterWorks(SelectionPanel selector){
		this.selector = selector;
		defenses = new DefenseClickRegion[4];
	}
	
	public void addDefense(DefenseClickRegion dcr){
		defenses[dcr.getDefenseNumber()] = dcr;
		dcr.addToOuterWorks(this);
		//dcr.addSelectionArea(selector);
	}
	
	public void updateGroups(){
		char[] emptyCOW = {'A', 'B', 'C', 'D'}; 
		availableGroups = emptyCOW;
		for(DefenseClickRegion dcr: defenses){
			String name = dcr.getDefenseName();
			
			if(!name.equals(SelectionArea.emptyText)){
				char c = Defense.findGroup(name);
				for(int i = 0; i < availableGroups.length; i++){
					if (availableGroups[i] == c){
						availableGroups[i] = '*';
					}
				}
			}
		}
	}

	public void displaySelector(DefenseClickRegion dcr){
		updateGroups();
		selector.add(new SelectionArea(availableGroups, dcr));
	}
	
	public DefenseClickRegion[] getDefenses() {
		return defenses;
	}

	public SelectionPanel getSelector(){
		return selector;
	}
	
	public OuterWorks getData(){
		String[] defenseNames = new String[defenses.length];
		for(int i = 0; i < defenses.length; i++){
			defenseNames[i] = defenses[i].getDefenseName();
		}
		return new OuterWorks(defenseNames);
	}
}
