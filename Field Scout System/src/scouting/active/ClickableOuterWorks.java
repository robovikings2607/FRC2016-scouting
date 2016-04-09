package scouting.active;

import scouting.datastorage.AllianceColor;
import scouting.datastorage.Defense;
//import scouting.datastorage.Defense;
import scouting.datastorage.OuterWorks;

public class ClickableOuterWorks {
	
	private DefenseClickRegion[] defenses;
	private SelectionPanel selector;
	private AllianceColor color;
	
	public ClickableOuterWorks(SelectionPanel selector, AllianceColor color){
		this.color = color;
		this.selector = selector;
		defenses = new DefenseClickRegion[4];
	}
	
	public void addDefense(DefenseClickRegion dcr){
		defenses[dcr.getDefenseNumber()- 2] = dcr;
		dcr.addToOuterWorks(this);
	}
	
	public void clearBorders(){
		for(int i = 0; i < defenses.length; i++){
			defenses[i].setIsSelected(false);
			defenses[0].repaint();
		}
	}
	
	public void reset(){
		for(int i = 0; i < defenses.length; i++){
			defenses[i].reset();
		}
	}
	
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
	
	public void selectNext(int callNum){
		int defenseIndex = callNum - 2;
		clearBorders();
		if(defenseIndex > 0){
			defenses[defenseIndex - 1].setIsSelected(true);
			displaySelector(defenses[defenseIndex - 1]);
		}
	}
	
	public OuterWorks getData(){
		String[] defenseNames = new String[defenses.length + 1];
		for(int i = 0; i < defenses.length; i++){
			defenseNames[i + 1] = defenses[i].getDefenseName();
		}
		defenseNames[0] = "Low Bar";
		return new OuterWorks(defenseNames);
	}
	
	public String validateData(){
		for(int i = 0; i < defenses.length; i++){
			if(defenses[i].getDefenseName().equals(DefenseClickRegion.emptyText)){
				return "Unfilled defense: " + defenses[i].toString();
			}
			for(int j = i + 1; j < defenses.length; j++){
				if(Defense.findGroup(defenses[i].getDefenseName()) == Defense.findGroup(defenses[j].getDefenseName())){
					return "Group conflict between " + defenses[i].toString() + " and " + defenses[j].toString();
				}
			}
		}
		return InfoPanel.noErrorMessage;
	}
}
