package scouting.datastorage;

/**
 * This class represents the overall data for a match that is not robot-specific
 * These data were pulled out so as to eliminate redundant work by the robot scouts
 * @author Michael
 */
public class MatchData {
	private AllianceColor winningAlliance, breach, capture;
	private FieldLayout layout;
	private int matchNumber;
	private int[] teams;
	private int[] finalScores;
	


	/**
	 * @param fl The layout of the field for the match
	 */
	public MatchData(){
	//	teams = t;
	//	layout = fl;
    //	matchNumber = match;
	}
	
	/**
	 * @param winningAlliance If the match is tied, use AllianceColor.BOTH
	 */
	public void setWinningAlliance(AllianceColor winningAlliance) {
		this.winningAlliance = winningAlliance;
	}
	
	public void setLayout(FieldLayout layout) {
		this.layout = layout;
	}

	public void setMatchNumber(int matchNumber) {
		this.matchNumber = matchNumber;
	}

	public void setTeams(int[] teams) {
		this.teams = teams;
	}
	
	public int[] getFinalScores() {
		return finalScores;
	}

	public void setFinalScores(int[] finalScores) {
		this.finalScores = finalScores;
		if(finalScores[0] > finalScores[1]){
			setWinningAlliance(AllianceColor.RED);
		} else if (finalScores[0] < finalScores[1]){
			setWinningAlliance(AllianceColor.BLUE);
		} else {
			setWinningAlliance(AllianceColor.BOTH);
		}
	}
	
	/**
	 * This refers to which alliance's defenses were breached, NOT which alliance did the breaching 
	 */
	public void setBreach(AllianceColor breach) {
		this.breach = breach;
	}

	/**
	 * This refers to which alliance's tower was captured, NOT which alliance did the capturing 
	 */
	public void setCapture(AllianceColor capture) {
		this.capture = capture;
	}

	public AllianceColor getWinningAlliance() {
		return winningAlliance;
	}
	
	/**
	 * This refers to which alliance's defenses were breached, NOT which alliance did the breaching 
	 */
	public AllianceColor getBreach() {
		return breach;
	}
	
	/**
	 * This refers to which alliance's tower was captured, NOT which alliance did the capturing 
	 */
	public AllianceColor getCapture() {
		return capture;
	}
	
	public FieldLayout getLayout() {
		return layout;
	}

	public int getMatchNumber() {
		return matchNumber;
	}

	public int[] getTeams() {
		return teams;
	}
	
	public String toString(){
		String s = "";
		s += "Match: " + matchNumber + "\n";
		s += "Red Teams: ";
		for(int i =0; i < 3; i++){
			s+= teams[i] + ", ";
		}
		s += "\n" + "Blue Teams: ";
		for(int i =3; i < 6; i++){
			s+= teams[i] + ", ";
		}
		s += "\n" + "Red Final Score: " + finalScores[0] + "\n";
		s += "Blue Final Score: " + finalScores[1] + "\n";
		s += "Winner: " + winningAlliance.name() + "\n";
		s += "Defenses Breached: " + breach.name() + "\n";
		s += "Towers Captured: " + capture.name() + "\n";
		
		s += layout.toString();
		
		return s;
	}
}
