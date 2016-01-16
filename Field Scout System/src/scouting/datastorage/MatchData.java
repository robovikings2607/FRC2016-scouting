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
	
	/**
	 * @param fl The layout of the field for the match
	 * @param match The match number
	 * @param t The list of teams in this match, starting with the Red alliance
	 */
	public MatchData(FieldLayout fl, int match, int[] t){
		teams = t;
		layout = fl;
		matchNumber = match;
	}
	
	/**
	 * @param winningAlliance If the match is tied, use AllianceColor.BOTH
	 */
	public void setWinningAlliance(AllianceColor winningAlliance) {
		this.winningAlliance = winningAlliance;
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
}
