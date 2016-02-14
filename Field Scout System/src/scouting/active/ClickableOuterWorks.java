package scouting.active;

import scouting.datastorage.AllianceColor;
//import scouting.datastorage.Defense;
import scouting.datastorage.OuterWorks;

public class ClickableOuterWorks {
	private DefenseClickRegion[] defenses;
	//private char[] availableGroups = {'A', 'B', 'C', 'D'};
	private SelectionPanel selector;
	private AllianceColor color;
	
	public ClickableOuterWorks(SelectionPanel selector, AllianceColor color){
		this.color = color;
		this.selector = selector;
		defenses = new DefenseClickRegion[4];
	}
	
	public void addDefense(DefenseClickRegion dcr){
		defenses[dcr.getDefenseNumber()- 1] = dcr;
		dcr.addToOuterWorks(this);
		//dcr.addSelectionArea(selector);
	}
	
	public void clearBorders(){
		for(int i = 0; i < defenses.length; i++){
			defenses[i].setIsSelected(false);
			defenses[0].repaint();
		}
	}
	
	/*public void updateGroups(){
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
	*/
	public void displaySelector(DefenseClickRegion dcr){
		selector.setCallingRegion(dcr);
	}
	
	public AllianceColor getColor(){
		return color;
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
