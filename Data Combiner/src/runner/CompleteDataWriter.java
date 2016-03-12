package runner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import dataStorage.FieldData;
/**
 * Oh my this class is big. Very, very big. I should refactor this sometime later, for sure, but now is most certainly
 * not the time.
 * @author Michael
 *
 */
public class CompleteDataWriter {
	private static final String outputCSVHeader = "TeamNumber,MatchNumber,ColorAndNumber," +
									"ScoutName,EsBrokien,Absent,Stuck,Cheval de Frise," + 
									"Portcullis,Moat,Ramparts,Drawbridge,Sally Port," +
									"Rock Wall,Rough Terrain,Low Bar,Cheval de Frise Avoid," +
									"Portcullis Avoid,Moat Avoid,Ramparts Avoid,Drawbridge Avoid," +
									"Sally Port Avoid,Rock Wall Avoid,Rough Terrain Avoid," + 
									"Low Bar Avoid,HighGoalHit,HighGoalMiss,LowGoalHit,LowGoalMiss," +
									"AutonHighHit,AutonHighMiss,AutonLowHit,AutonlowMiss," +
									"AutonDefenseReached,AutonDefenseCrossed,TowerScaled," +
									"TowerChallenged,Fouls,TechFouls,Breach,Capture,Win,Comments";
	private static final String[] robotScoutCSVHeader = {"MatchNumber","TeamNumber","ColorAndNumber",
									"ScoutName","EsBrokien","Absent","Stuck","HighGoalHit","HighGoalMiss",
									"LowGoalHit","LowGoalMiss","RD1Crossings","RD2Crossings","RD3Crossings",
									"RD4Crossings","RD5Crossings","BD1Crossings","BD2Crossings",
									"BD3Crossings","BD4Crossings","BD5Crossings","AutonHighHit",
									"AutonHighMiss","AutonLowHit","AutonLowMiss","AutonDefenseReached",
									"AutonDefenseCrossed","TowerScaled","TowerChallenged","Fouls","TechFouls",
									"Comments"};
	private static final String[] defenses = {"Cheval de Frise","Portcullis","Moat","Ramparts",
									"Drawbridge","Sally Port","Rock Wall","Rough Terrain","Low Bar"};
	private FieldData fieldScoutData;
	private PrintWriter writer;
	private Scanner scan;
	
	public CompleteDataWriter(File outputFile, FieldData fieldScoutData){
		this.fieldScoutData = fieldScoutData;
		scan = new Scanner(System.in);
		try {
			writer = new PrintWriter(new FileOutputStream(outputFile, false));
			writer.write(outputCSVHeader + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void closeScanner(){
		scan.close();
	}
	
	/**
	 * Takes the contents of a CSV file following the standard robot scout template and copies the data into a combined file.
	 * The areas formerly known as the positional defense crossings are replaced with the names of the defenses,
	 * and defenses avoided are inferred from the match data. 
	 * @param robotScoutCSV The file to be written in.
	 */
	public void write(File robotScoutCSV){
		/*if(detectFatalError(robotScoutCSV)){
			System.out.println("Fatal error caused. File unreadable." + "\n");
			return;
		} */
		try{
			BufferedReader read = new BufferedReader(new FileReader(robotScoutCSV));
			String line = read.readLine();
			System.out.println("Reading from " + robotScoutCSV.getName());
			while((line = read.readLine()) != null){
				writeLine(line, scan);
			}
			read.close();
			System.out.println();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	private void writeLine(String line, Scanner scan){
		String[] data = split(line);
		String err = detectWorkableError(data);
		if (detectWorkableError(data) != null){
			System.out.println(err);
			System.out.println("Ignore error and write data anyways? (y/n)");
			String response = scan.nextLine();

			if (!"y".equals(response.toLowerCase())){
				return;
			}
		}; 
		
		writer.write(data[dataIndex("TeamNumber")] + ",");
		writer.write(data[dataIndex("MatchNumber")] + ",");
		writer.write(data[dataIndex("ColorAndNumber")] + ",");
		writer.write(data[dataIndex("ScoutName")] + ",");
		booleanWrite(data[dataIndex("EsBrokien")]);
		booleanWrite(data[dataIndex("Absent")]);
		booleanWrite(data[dataIndex("Stuck")]);
		
		writer.write(defenseCrossings(data));
		
		writer.write(data[dataIndex("HighGoalHit")] + ",");
		writer.write(data[dataIndex("HighGoalMiss")] + ",");
		writer.write(data[dataIndex("LowGoalHit")] + ",");
		writer.write(data[dataIndex("LowGoalMiss")] + ",");
		writer.write(data[dataIndex("AutonHighHit")] + ",");
		writer.write(data[dataIndex("AutonHighMiss")] + ",");
		writer.write(data[dataIndex("AutonLowHit")] + ",");
		writer.write(data[dataIndex("AutonLowMiss")] + ",");
		booleanWrite(data[dataIndex("AutonDefenseReached")]);
		
		int matchNumber = Integer.parseInt(data[dataIndex("MatchNumber")]);
		String[] match = fieldScoutData.get(matchNumber);
		
		int autonDefenseID = Integer.parseInt(data[dataIndex("AutonDefenseCrossed")]);
		if(autonDefenseID != -1){
			writer.write(match[autonDefenseID + 11] + ",");
		} else {
			writer.write("No Crossing,");
		}
		
		booleanWrite(data[dataIndex("TowerScaled")]);
		booleanWrite(data[dataIndex("TowerChallenged")]);
		writer.write(data[dataIndex("Fouls")] + ",");
		writer.write(data[dataIndex("TechFouls")] + ",");

		String color;
		if(data[dataIndex("ColorAndNumber")].contains("Red")){
			color = "RED";
		} else {
			color = "BLUE";
		}

		booleanWrite(match[10].equals(color) || match[10].equals("BOTH"));
		booleanWrite(match[9].equals(color) || match[9].equals("BOTH"));
		
		boolean redWin = Integer.parseInt(match[7]) > Integer.parseInt(match[8]);
		if(color.equals("RED")){
			booleanWrite(redWin);
		} else {
			booleanWrite(!redWin);
		}
		
		writer.write(data[dataIndex("Comments")].replaceAll(",", "-") + "\n");
	}
	//HighGoalHit,HighGoalMiss,LowGoalHit,LowGoalMiss,AutonHighHit,AutonHighMiss,AutonLowHit,AutonlowMiss,
	//AutonDefenseReached,AutonDefenseCrossed,TowerScaled,TowerChallenged,Fouls,TechFouls,Breach,Capture,Win,Comments
	
	private void booleanWrite(String bool) {
		if(bool.toLowerCase().equals("true")){
			writer.write("1,");
		} else {
			writer.write("0,");
		}
	}
	
	private void booleanWrite(boolean bool) {
		if(bool == true){
			writer.write("1,");
		} else {
			writer.write("0,");
		}
	}
	
	private int dataIndex(String s){
		for(int i = 0; i < robotScoutCSVHeader.length; i++){
			if(robotScoutCSVHeader[i].equals(s))
				return i;
		}
		return -1;
	}
		
	/**
	 * Takes a line of the scout's CSV file and breaks it up along the commas,
	 * while leaving the comment intact even if it contains separators.
	 * @param line The CSV line to be broken; the only field that can contain commas is the 
	 * comment at the end, NOT THE SCOUT NAME
	 * @return A string[] containing the 31 values present in a robot scout CSV file
	 */
	private String[] split(String line){
		String[] retVal = new String[robotScoutCSVHeader.length];
		for(int i = 0; i < robotScoutCSVHeader.length - 1 && line.indexOf(',') >= 0; i++){
			int ind = line.indexOf(',');
			retVal[i] = line.substring(0, ind);
			line = line.substring(ind + 1);
		}
		retVal[robotScoutCSVHeader.length - 1] = line;
		return retVal;
	}
	
	private String defenseCrossings(String[] splitRobotScoutData){
		int[] retVal = new int[18];
		int robotDataStart = dataIndex("RD1Crossings");
		int fieldDataStart = 11;
		String[] fieldDat = fieldScoutData.get(new Integer(splitRobotScoutData[dataIndex("MatchNumber")]));
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 10; j++){
				if(fieldDat[j + fieldDataStart].equals(defenses[i])){
					retVal[i] += Integer.parseInt(splitRobotScoutData[robotDataStart + j]);
					if (j < 5 && retVal[i] == 0){
						retVal[i+9] = 1;
					}
				}
			}
		}

		String s = "";
		for(int i = 0; i < retVal.length; i++){
			s += retVal[i] + ",";
		}
		return s;
	}
	
	private boolean detectFatalError(File robotScoutCSV){
		if (!robotScoutCSV.exists()){
			System.out.println(robotScoutCSV.getName() + " does not exist.");
			return true;
		} 
		try{
			BufferedReader read = new BufferedReader(new FileReader(robotScoutCSV));
			String header = read.readLine();
			read.close();
			if(!Arrays.equals(robotScoutCSVHeader, split(header))){
				System.out.println("CSV header mismatch, unreadable data in " + robotScoutCSV.getName());
				return true;
			}
		} catch (IOException e){
			System.out.println("Could not read " + robotScoutCSV.getName());
			return true;
		}
		return false;
	}
	
	private String detectWorkableError(String[] robotMatch){
		String error = "";
		if(robotMatch.length < robotScoutCSVHeader.length){
			error += "Missing full data; ";
		}
		
		String[] fieldData;
		String matchNumber = robotMatch[dataIndex("MatchNumber")];
		int match = -1;
		if("".equals(matchNumber) || "null".equals(matchNumber)){
			error += "matchNumber does not exist; ";
		} else {
			try{
				match = Integer.parseInt(robotMatch[dataIndex("MatchNumber")]);
			} catch (NumberFormatException e){
				error += "Match number is a string; ";
			}
		}
		
		if((fieldData = fieldScoutData.get(match)) == null){
			error += "No match data for match " + match + "; ";
		} else {
			boolean isInMatch = false;
			try{
				int teamNumber = Integer.parseInt(robotMatch[1]);
				for(int i = 0; i < 6; i++){
					if(Integer.parseInt(fieldData[i + 1]) == teamNumber){
						isInMatch = true;
					}
				}
				if (!isInMatch){
					error += "Team " + teamNumber + " is not in match " + match + " ; ";
				}
			} catch (NumberFormatException e){}
		}
		if(error.equals("")){
			return null;
		} else {
			return error;
		}
	}
	
	public void closeWriter(){
		writer.close();
	}
}
