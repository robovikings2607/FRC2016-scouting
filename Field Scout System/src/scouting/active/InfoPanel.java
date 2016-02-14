package scouting.active;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class InfoPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JRadioButton[] victoryButtons;
	private JCheckBox[] breachBoxes;
	private JCheckBox[] captureBoxes;
	private JTextField[] scoreFields;
	private JTextField[] teamNumbers;

	public InfoPanel(int matchNumber){
		GridLayout layout = new GridLayout(1,0);
		layout.setHgap(5);
		setLayout(layout);
		
		setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
		
		add(makeVictoryPanel());
		add(makeBreachCapturePanel());
		add(makeScorePanel());
		add(makeTeamPanel());
	}
	
	public void setTeamNumbers(int[] teamNumbers){
		for(int i = 0; i < this.teamNumbers.length; i++){
			this.teamNumbers[i].setText(teamNumbers[i] + "");;
		}
	}
	
	private JPanel makeVictoryPanel(){
		JPanel victoryPanel = new JPanel();
		victoryPanel.setLayout(new GridLayout(0,1));
		victoryPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 3));
		
		victoryPanel.add(new JLabel("Winning Alliance:"));
		victoryButtons = new JRadioButton[3];
		ButtonGroup victoryGroup = new ButtonGroup();
		victoryButtons[0] = new JRadioButton("Red");
		victoryButtons[1] = new JRadioButton("Blue");
		victoryButtons[2] = new JRadioButton("Tie");
		for(int i = 0; i < victoryButtons.length; i++){
			victoryGroup.add(victoryButtons[i]);
			victoryPanel.add(victoryButtons[i]);
		}
		
		return victoryPanel;
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
		scoreFields[0] = new JTextField(4);
		scoreFields[0].setEditable(true);
		scoreFields[1] = new JTextField(4);
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
			JTextField jtf = new JTextField();
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
