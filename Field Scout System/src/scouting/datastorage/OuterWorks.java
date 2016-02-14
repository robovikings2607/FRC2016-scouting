package scouting.datastorage;
/**
 * This class represents one set of {@link Defense}s in an outer works.
 * @author Michael
 */
public class OuterWorks {
	private Defense[] defenseLayout;
	
	/**
	 * Creates an OuterWorks from an array of the names of the defenses
	 * @param defenseNames Should be organized from 1 to 5, with the Low Bar as the 1st, as in the Game Manual
	 */
	public OuterWorks(String[] defenseNames){
		defenseLayout = new Defense[5];
		for(int i = 0; i < 5; i++){
			defenseLayout[i] = new Defense(defenseNames[i]);
		}
	}
	
	/**
	 * This returns the defense in the given position on the field.
	 * Indexed to 1 to comply with FRC defense position labeling
	 * @param i The index of the desired defense
	 */
	public Defense getDefense(int i){
		return defenseLayout[i - 1];
	}
	
	public String toString(){
		String s = "";
		for(int i = 0; i < defenseLayout.length; i++){
			s += i + 1 + "-" + defenseLayout[i].getName() + " ";
		}
		return s;
	}
}
