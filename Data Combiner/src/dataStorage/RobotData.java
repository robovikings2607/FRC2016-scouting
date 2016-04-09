package dataStorage;

import errorHandling.InvalidDataException;

public class RobotData {
	private String scoutName, positionID, comments; //defenseComments, crossingComments, skillComments;
	
	private int autonDefense;
	private String preciseAutonDefense;
	
	private int[] defenseCrossings;
	//private int[] autonDefense;
	private int teamNumber, matchNumber, highGoalHit,highGoalMiss,lowGoalHit,
				lowGoalMiss,autonHighHit,autonHighMiss,autonLowHit,autonlowMiss,fouls,techFouls;
	private int esBrokien,absent,stuck,autonDefenseReached,TowerScaled,
				TowerChallenged,Breach,Capture,Win; //These will be either 1 or 0 (true/false respectively)
	
	private int[] preciseDefenseCrossings;
	private int[] preciseDefenseAvoids;
	//private int[] preciseAutonDefense;
	private boolean defensesIdentified;
	
	public RobotData(String[] rawCSVData) throws InvalidDataException{
		
	}
	
	public void combineData(FieldData fd){
		String[] matchData = fd.get(new Integer(matchNumber));
		FieldMatch fmMatchData = new FieldMatch(matchData);
		fmMatchData.specifyData(this);
	}

	public String getCSVEntry() throws InvalidDataException{
		if(!defensesIdentified){
			throw new InvalidDataException("The data for Match " + matchNumber + 
					" Team " + teamNumber + " has not yet been combined with field data.", true);
		}
		String csv = "";
		
		csv += teamNumber + "," + matchNumber + "," + positionID + "," + scoutName + ",";
		
		int[] numerVals = {esBrokien, absent, stuck};
		numerVals = concat(numerVals, preciseDefenseCrossings);
		numerVals = concat(numerVals, preciseDefenseAvoids);
		//numerVals = concat(numerVals, preciseAutonDefense);
		int[] remainingVals = {highGoalHit,highGoalMiss,lowGoalHit,lowGoalMiss,autonHighHit,
				autonHighMiss,autonLowHit,autonlowMiss,autonDefenseReached,TowerScaled,
				TowerChallenged,fouls,techFouls,Breach,Capture,Win};
		numerVals = concat(numerVals, remainingVals);
		for(int i = 0; i < numerVals.length; i++){
			csv += numerVals[i] + ",";
			
			if(i == 29){
				csv += preciseAutonDefense + ",";
			}
		}
		
	//	csv += defenseComments + "," + crossingComments + "," + skillComments;
		csv += comments;
		return csv;
	}
	
	private int[] concat(int[] a, int[]b){
		int[] ret = new int[a.length + b.length];
		for(int i = 0; i < a.length; i++){
			ret[i] = a[i];
		}
		for(int i = 0; i < b.length; i++){
			ret[i + a.length] = b[i];
		}
		return ret;
	}
	
	public int[] getDefenseCrossings() {
		return defenseCrossings;
	}

/*	public int[] getAutonDefense() {
		return autonDefense;
	} */
	
	public String getPositionID() {
		return positionID;
	}

	public void setDefensesIdentified(boolean defensesIdentified) {
		this.defensesIdentified = defensesIdentified;
	}

	public void setBreach(int breach) {
		Breach = breach;
	}

	public void setCapture(int capture) {
		Capture = capture;
	}

	public void setWin(int win) {
		Win = win;
	}

	public void setPreciseDefenseCrossings(int[] preciseDefenseCrossings) {
		this.preciseDefenseCrossings = preciseDefenseCrossings;
	}

	public void setPreciseDefenseAvoids(int[] preciseDefenseAvoids) {
		this.preciseDefenseAvoids = preciseDefenseAvoids;
	}

/*	public void setPreciseAutonDefense(int[] preciseAutonDefense) {
		this.preciseAutonDefense = preciseAutonDefense;
	} */

	public String toString(){
		String s;
		try{
			s = getCSVEntry();
		} catch (InvalidDataException e){
			s = "Error: " + e.getMessage();
		}
		return s;
	}

	public int getAutonDefense() {
		return autonDefense;
	}

	public void setPreciseAutonDefense(String preciseAutonDefense) {
		this.preciseAutonDefense = preciseAutonDefense;
	}
}
