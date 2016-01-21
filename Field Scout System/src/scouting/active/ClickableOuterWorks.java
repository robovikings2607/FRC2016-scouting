package scouting.active;

import scouting.datastorage.OuterWorks;

public class ClickableOuterWorks {
	private DefenseClickRegion[] defenses;
	private SelectionArea selector;
	
	public ClickableOuterWorks(SelectionArea selector){
		this.selector = selector;
		defenses = new DefenseClickRegion[4];
	}
	
	public void addDefense(DefenseClickRegion dcr){
		defenses[dcr.getDefenseNumber()] = dcr;
		dcr.addSelectionArea(selector);
	}
	
	public DefenseClickRegion[] getDefenses() {
		return defenses;
	}

	public SelectionArea getSelector(){
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
