package scouting.datastorage;
/**
 * This class represents a single defense in the outer works.
 * It contains the name of the defense and the group it is a member of.
 * @author Michael
 */
public class Defense {
	private char group;
	private String name;
	
	/**
	 * All groups are as described in the game manual
	 * The low bar is labeled as group 'L'
	 * @return the group of the defense
	 */
	public char getGroup() {
		return group;
	}
	
	/**
	 * @return The name of the defense
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This constructor finds the group for you
	 * @param s The name of the defense
	 */
	public Defense(String s){
		name = s;
		group = findGroup(s);
		if (group == '*'){
			name = "Invalid Defense";
		}
	}
	
	/**
	 * This constructor is marginally faster if you already have the group letter
	 * @param s The name of the defense
	 * @param gr The letter of the group
	 */
	public Defense(String s, char gr){
		name = s;
		group = gr;
	}
	
	public static char findGroup(String dName){
		if (dName.equals("Cheval de Frise") || dName.equals("Portcullis")){
			return 'A';
		} else if (dName.equals("Moat") || dName.equals("Ramparts")){
			return 'B';
		} else if (dName.equals("Drawbridge") || dName.equals("Sally Port")){
			return 'C';
		} else if (dName.equals("Rock Wall") || dName.equals("Rough Terrain")){
			return 'D';
		} else if (dName.equals("Low Bar")){
			return 'L';
		} else {
			return '*';
		}
	}
}
