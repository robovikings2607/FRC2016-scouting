import java.io.File;

public class DataSynth {
	
	private static final String outputCSVHeader = "TeamNumber,MatchNumber,ColorAndNumber,ScoutName,EsBrokien,Absent,Cheval de Frise,Portcullis,Moat,Ramparts,Drawbridge,Sally Port,Rock Wall,Rough Terrain,Low Bar,HighGoalHit,HighGoalMiss,LowGoalHit,LowGoalMiss,AutonHighHit,AutonHighMiss,AutonLowHit,AutonlowMiss,AutonDefenseReached,AutonDefenseCrossed,TowerScaled,TowerChallenged,Fouls,TechFouls,Breach,Capture,Win,Comments";
	
	private static final String outputFileName = "completeData.csv";
	private static final String inputFieldScoutFileName = "fieldScoutData.csv";
	private static final String inputRobotScoutFileName = "";
	
	public static void main(String[] args){
		FieldData fd = new FieldData(new File(inputFieldScoutFileName));
		System.out.println(fd);
	}
}
