package dataStorage;

import java.util.Arrays;

public class FieldMatch {
	
	//private int[] teams;
	private int[] finalScores;
	private String capture, breach;
	private String[] defenseLayout;
	
	private static String[] defenses = {"Cheval de Frise","Portcullis","Moat","Ramparts",
		"Drawbridge","Sally Port","Rock Wall","Rough Terrain","Low Bar"};
	//writer.print("MatchNumber,Red1,Red2,Red3,Blue1,Blue2,Blue3,RedFinalScore,BlueFinalScore,");
	//writer.println("Capture,Breach,DRed1,DRed2,DRed3,DRed4,DRed5,DBlue1,DBlue2,DBlue3,DBlue4,DBlue5");

	
	public FieldMatch(String[] fieldDataCSV){
		//teams = pullData(1,6, fieldDataCSV);
		finalScores = pullData(7,2, fieldDataCSV);
		defenseLayout = Arrays.copyOfRange(fieldDataCSV, 11, fieldDataCSV.length);
		
		capture = fieldDataCSV[9];
		breach = fieldDataCSV[10];
	}
	
	private int[] pullData(int start, int length, String[] data){
		int[] ret = new int[length];
		for (int i = 0; i < length; i++){
			ret[i] = Integer.parseInt(data[i + start]);
		}
		return ret;
	}
	
	public void specifyData(RobotData rd){
		boolean red = rd.getPositionID().contains("Red");
		int[] preciseCrossings = idDefenses(rd.getDefenseCrossings(), !red);
		rd.setPreciseDefenseCrossings(preciseCrossings);
		
		int[] preciseAvoids = new int[9];
		Arrays.fill(preciseAvoids, 0);
		for(int i = 0; i < preciseCrossings.length; i++){
			if(preciseCrossings[i] == 0 && indexOfDefense(defenses[i], !red) >= 0){
				preciseAvoids[i] = 1;
			}
		}
		rd.setPreciseDefenseAvoids(preciseAvoids);
		
		rd.setPreciseAutonDefense(idDefenses(rd.getAutonDefense(),!red));
		rd.setDefensesIdentified(true);
		
		if(red){
			if(finalScores[0] > finalScores[1]) rd.setWin(1);
			if(capture.equals("RED") || capture.equals("BOTH")) rd.setCapture(1);
			if(breach.equals("RED") || breach.equals("BOTH")) rd.setBreach(1);
		}
	}
	
	private int indexOfDefense(String defenseName, boolean redOuterworks){
		int offset = 5;
		if(redOuterworks){
			offset = 0;
		}
		
		for(int i = 0; i < 5; i++){
			if (defenseLayout[i + offset].equals(defenseName)){
				return i + offset;
			}
		}
		return -1;
	}
	
	/**
	 * Translates a set of five crossings from the array describing the robot's crossings on the entire
	 * field. Which set of five is specified by the boolean argument.
	 * @param defenseCrossings The full list of all of the defenses crossed by the robot in the 
	 * course of the match.
	 * @param redDefense If true, returns the crossings of the red outerworks. If false, returns 
	 * that of the blue.
	 * @return
	 */
	private int[] idDefenses(int[] defenseCrossings, boolean redDefense){
		int offset = 5;
		if(redDefense){
			offset = 0;
		}
		
		int[] preciseDefenses = new int[9];
		for(int i = 0; i < defenses.length; i++){
			for(int j = 0; j < 5; j++){
				if(defenses[i].equals(defenseLayout[j + offset])){
					preciseDefenses[i] += defenseCrossings[j + offset];
					break;
				}
			}
		}
		return preciseDefenses;
	}
	
	/*public static void setDefenseOrder(String[] defenseOrder){
		defenses = defenseOrder;
	}
	
	private int getDefenseValue(String defenseName){
		for(int i = 0; i < defenses.length; i++){
			if (defenses)
		}
	} */
}
