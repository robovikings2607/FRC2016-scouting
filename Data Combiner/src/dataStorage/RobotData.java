package dataStorage;


import java.util.Arrays;

import errorHandling.InvalidDataException;

public class RobotData {
	private String scoutName, positionID, defenseComments, crossingComments, skillComments;
	private int[] defenseCrossings;
	private int[] defenseAvoids;
	private int[] autonDefense;
	private int teamNumber, matchNumber, highGoalHit,highGoalMiss,lowGoalHit,
				lowGoalMiss,autonHighHit,autonHighMiss,autonLowHit,autonlowMiss,fouls,techFouls;
	private int esBrokien,absent,stuck,autonDefenseReached,TowerScaled,
				TowerChallenged,Breach,Capture,Win; //These will be either 1 or 0 (true/false respectively)
	
	private int[] preciseDefenseCrossings;
	private int[] preciseDefenseAvoids;
	private int[] preciseAutonDefense;
	private boolean defensesIdentified;
	
	public RobotData(String[] rawCSVData) throws InvalidDataException{
		
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
		numerVals = concat(numerVals, preciseAutonDefense);
		int[] remainingVals = {highGoalHit,highGoalMiss,lowGoalHit,lowGoalMiss,autonHighHit,
				autonHighMiss,autonLowHit,autonlowMiss,autonDefenseReached,TowerScaled,
				TowerChallenged,fouls,techFouls,Breach,Capture,Win};
		numerVals = concat(numerVals, remainingVals);
		for(int i = 0; i < numerVals.length; i++){
			csv += numerVals[i] + ",";
		}
		
		csv += defenseComments + "," + crossingComments + "," + skillComments;
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
}
