package scouting.active;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import scouting.datastorage.AllianceColor;
import scouting.datastorage.MatchData;

public class InfoPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	public static final String noErrorMessage = "Error-Free";
	
	private JCheckBox[] breachBoxes;
	private JCheckBox[] captureBoxes;
	private JTextField[] scoreFields;
	private JTextField[] teamNumbers;
	private JTextField matchNumberField;
	
	private MatchData matchdata;

	public InfoPanel(){
		GridLayout layout = new GridLayout(1,0);
		layout.setHgap(5);
		setLayout(layout);
		
		setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
		
		add(makeMatchPanel());
		add(makeBreachCapturePanel());
		add(makeScorePanel());
		add(makeTeamPanel());
		
		matchNumberField.setText("");
	}
	
	/**
	 * This method accepts team numbers in the following order:
	 * {Red 1, Blue 1, Red 2, Blue 2, Red 3, Blue 3}
	 * @param teamNumbers
	 */
	public void setTeamNumbers(int[] teamNumbers){
		for(int i = 0; i < this.teamNumbers.length; i++){
			this.teamNumbers[i].setText(teamNumbers[i] + "");;
		}
	}
	
	/**
	 * This method check the validity of all entered data and creates part of a {@link MatchData} object which can
	 * be fetched later.  
	 * @return An error message to be displayed or the public String constant noErrorMessage if the data is entirely valid.
	 */
	public String validateData(){
		//Sets up the MatchData object without a fieldLayout
		matchdata = new MatchData();
		
		//Checks to see if all team numbers are actual numbers
		int[] teamNumbers = new int[this.teamNumbers.length];
		for(int i = 0; i < teamNumbers.length; i++){
			try{
				int pos = (i*3)%5;
				if(i == 5)
					pos = 5;
				teamNumbers[pos] = Integer.parseInt(this.teamNumbers[i].getText());
			} catch (NumberFormatException e){
				String err = "The team number for ";
				if (i%2 == 0){
					err += "Red ";
				} else {
					err += "Blue ";
				}
				err += (i+2)/2 + " does not contain a readable integer.";
				return err;
			}
		}
		matchdata.setTeams(teamNumbers);
		
		//Checks to see if the match number is valid
		try{
			matchdata.setMatchNumber(Integer.parseInt(matchNumberField.getText()));
		} catch (NumberFormatException e){
			return "The match number is not a readable integer.";
		}
		
		//Checks to see if the final scores are valid
		int[] finalScores = new int[scoreFields.length];
		for(int i =0; i < scoreFields.length; i++){
			try{
				finalScores[i] = Integer.parseInt(scoreFields[i].getText());
			} catch (NumberFormatException e) {
				String err = "The ";
				if(i == 0){
					err += "Red";
				} else {
					err += "Blue";
				}
				return err + " final score is not a readable integer.";
			}
		}
		matchdata.setFinalScores(finalScores);
		
		//Adds the breach and capture data, but will not return any error messages
		boolean redBreach = breachBoxes[0].isSelected();
		boolean blueBreach = breachBoxes[1].isSelected();
		if(redBreach && blueBreach){
			matchdata.setBreach(AllianceColor.BOTH);
		} else if (redBreach){
			matchdata.setBreach(AllianceColor.RED);
		} else if (blueBreach){
			matchdata.setBreach(AllianceColor.BLUE);
		} else {
			matchdata.setBreach(AllianceColor.NEITHER);
		}
		
		boolean redCapture = captureBoxes[0].isSelected();
		boolean blueCapture = captureBoxes[1].isSelected();
		if(redCapture && blueCapture){
			matchdata.setCapture(AllianceColor.BOTH);
		} else if (redCapture){
			matchdata.setCapture(AllianceColor.RED);
		} else if (blueCapture){
			matchdata.setCapture(AllianceColor.BLUE);
		} else {
			matchdata.setCapture(AllianceColor.NEITHER);
		}
		
		return noErrorMessage;
	}
	
	/**
	 * This method resets all values stored in the InfoPanel, including the stored
	 * {@link MatchData}. Ensure that the MatchData has been extracted before calling reset.
	 * This method also serves to increment the match number up by one. If the reset method is 
	 * called while the match number {@link JTextBox} does not contain a parseable int, the
	 * field is set to a blank String. 
	 */
	public void reset(){
		matchdata = null;
		for(int i = 0; i < breachBoxes.length; i++){
			breachBoxes[i].setSelected(false);
			captureBoxes[i].setSelected(false);
			scoreFields[i].setText("");
		}
		for(int i = 0; i < teamNumbers.length; i++){
			teamNumbers[i].setText("");
		}
		try{
			matchNumberField.setText("" + (Integer.parseInt(matchNumberField.getText()) + 1 ));
		} catch (NumberFormatException e){
			matchNumberField.setText("");
		}
	}

	public MatchData getData(){
		return matchdata;
	}
	
	private JPanel makeMatchPanel(){
		JPanel matchPanel = new JPanel();
		matchPanel.setLayout(new GridLayout(0,2));
		matchPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 3));
		
		matchPanel.add(new JLabel("Match Number:"));
		matchPanel.add(new JPanel()); //Placeholder
		matchNumberField = new JTextField("");
		matchNumberField.setEditable(true);
		matchPanel.add(matchNumberField);
		
		matchPanel.add(new JPanel()); //Placeholder
		matchPanel.add(new JPanel()); //Placeholder

		return matchPanel;
	}
	
	private JPanel makeBreachCapturePanel(){
		JPanel bcPanel = new JPanel();
		GridLayout layout = new GridLayout(0,2);
		layout.setHgap(10);
		bcPanel.setLayout(layout);
		bcPanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));

		JLabel breachLabel = new JLabel("Breach:");
		breachLabel.setToolTipText("Which outer works were breached?");
		
		JLabel captureLabel = new JLabel("Capture:");
		captureLabel.setToolTipText("Which towers were captured?");
		
		breachBoxes = new JCheckBox[2];
		breachBoxes[0] = new JCheckBox("Red");
		breachBoxes[1] = new JCheckBox("Blue");

		captureBoxes = new JCheckBox[2];
		captureBoxes[0] = new JCheckBox("Red");
		captureBoxes[1] = new JCheckBox("Blue");
		
		bcPanel.add(breachLabel);
		bcPanel.add(captureLabel);
		for(int i = 0; i < captureBoxes.length; i++){
			bcPanel.add(breachBoxes[i]);
			bcPanel.add(captureBoxes[i]);
		}

		return bcPanel;
	}
	
	private JPanel makeScorePanel(){
		JPanel scorePanel = new JPanel();
		GridLayout layout = new GridLayout(0,2);
		layout.setHgap(10);
		scorePanel.setLayout(layout);
		scorePanel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		
		scorePanel.add(new JLabel("Final Scores"));
		scorePanel.add(new JPanel());

		
		JLabel[] scoreLabels = new JLabel[2];
		scoreLabels[0] = new JLabel("Red Score:");
		scoreLabels[1] = new JLabel("Blue Score:");
		
		scoreFields = new JTextField[2];
		scoreFields[0] = new JTextField("");
		scoreFields[0].setEditable(true);
		scoreFields[1] = new JTextField("");
		scoreFields[1].setEditable(true);
		
		for(int i = 0; i < scoreFields.length; i++){
			scorePanel.add(scoreLabels[i]);
			scorePanel.add(scoreFields[i]);
		}
				
		return scorePanel;
	}
	
	private JPanel makeTeamPanel(){
		JPanel scorePanel = new JPanel();
		GridLayout layout = new GridLayout(0,2);
		layout.setHgap(10);
		scorePanel.setLayout(layout);
		scorePanel.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 3));
		
		scorePanel.add(new JLabel("Red Teams"));
		scorePanel.add(new JLabel("Blue Teams"));
		
		teamNumbers = new JTextField[6];
		for(int i = 0; i < 6; i++){
			JTextField jtf = new JTextField("");
			jtf.setEditable(true);
			Color borderColor;
			if(i % 2 == 0)
				borderColor = Color.RED;
			else
				borderColor = Color.BLUE;
			jtf.setBorder(BorderFactory.createLineBorder(borderColor,2));
			teamNumbers[i] = jtf;
			scorePanel.add(jtf);
		}
		return scorePanel;
	}
}
