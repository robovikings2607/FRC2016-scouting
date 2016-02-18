package scouting.active;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import scouting.datastorage.AllianceColor;
import scouting.datastorage.FieldLayout;
import scouting.datastorage.MatchData;
import scouting.io.DataWriter;
/**
 * This class extends {@link JFrame} and is the top-level panel in the field scouting gui.
 * It should contain a {@link ClickabeFieldMap}, a {@link SelectionArea}, and a third (as
 * yet undefined) area to enter the information concerning Ranking Points.
 * @author Michael
 *
 */
public class FieldScoutGUI extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private static final String outputFile = "fieldScoutData.txt";
	
	private ClickableFieldMap map;
	private SelectionPanel selector;
	private InfoPanel info;
	private ClickableOuterWorks[] cowList = new ClickableOuterWorks[2];
	private JTextField errorDisplay;
	private DataWriter writer;
	
	public static void main(String[] args){

		JFrame frame = new JFrame("Field Scouting System v1.7");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FieldScoutGUI fsg = new FieldScoutGUI();
		
		fsg.setOpaque(true); 
		frame.setContentPane(fsg);
		// Display the window.
		frame.setSize(fsg.map.getWidth() + fsg.selector.getWidth() + 21, 542);
		//frame.pack();
		frame.setVisible(true);
		
		//fsg.createAndShowGui();
	}
	
	public void createAndShowGui(){
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000,800);
		//pack();
		setVisible(true);
	}
	
	public FieldScoutGUI(){		
		initialize();
		
		setLayout(null);
		add(map);
		map.setBounds(0, 0, map.getWidth(), map.getHeight());
		
		add(selector);
		selector.setBounds(map.getWidth()+5, 0, selector.getWidth(), selector.getHeight());
		
		add(info);
		info.setBounds(0, map.getHeight() + 5, map.getWidth(), 100);
		
		add(errorDisplay);
		errorDisplay.setBounds(0, map.getHeight() + 105, map.getWidth(), 30);
		
		JButton submitinator = new JButton("Submit");
		submitinator.addActionListener(this);
		add(submitinator);
		submitinator.setBounds(map.getWidth() + 5, selector.getHeight() + 5, selector.getWidth(), 50);
	}
	
	public void initialize(){
		
		selector = new SelectionPanel();
		info = new InfoPanel();
		
		map = new ClickableFieldMap("fieldMap.PNG");
		
		ClickableOuterWorks blueOuterWorks = new ClickableOuterWorks(selector, AllianceColor.BLUE);
		for(int i = 0; i < 4; i++){
			DefenseClickRegion dcr = new DefenseClickRegion(i, new Rectangle(244, 78 + 54 * i, 23, 51));
			blueOuterWorks.addDefense(dcr);
		}
		
		ClickableOuterWorks redOuterWorks = new ClickableOuterWorks(selector, AllianceColor.RED);
		for(int i = 0; i < 4; i++){
			DefenseClickRegion dcr = new DefenseClickRegion(i, new Rectangle(469, 237 - 54 * i, 23, 51));
			redOuterWorks.addDefense(dcr);
		}
		
		cowList[0] = blueOuterWorks;
		cowList[1] = redOuterWorks;
		
		map.addOuterWorks(blueOuterWorks);
		map.addOuterWorks(redOuterWorks);
		
		errorDisplay = new JTextField("");
		errorDisplay.setEditable(false);
		errorDisplay.setBorder(BorderFactory.createLineBorder(Color.PINK, 3));
		

	}
	
	/**
	 * Resets the data in the {@link InfoPanel} and both {@link ClickableOuterWorks}'s
	 * to the state they were in at the start of the program. Sets the error display field
	 * to an empty string.
	 * Increments match number up by one.
	 */
	public void reset(){
		errorDisplay.setText("");
		cowList[0].reset();
		cowList[1].reset();
		info.reset();
	}
	/**
	 * Displays a given error message in the errorDisplay {@link JTextField} and returns a boolean representing whether
	 * or not the data is valid.
	 * @param error The error message to display
	 * @return true if the error message is InfoPanel.noErrorMessage
	 */
	public boolean DisplayError(String error){
		if(error.equals(InfoPanel.noErrorMessage)){
			return true;
		} else {
			errorDisplay.setText(error);
			return false;
		}
	}
	
	/**
	 * Will extract the match data, reset all input fields, and send the data into other storage.
	 * DO NOT CALL unless the validateData method has been called on both {@link ClickableOuterWorks}'s and the {@link InfoPanel}.
	 */
	private void extractData(){
		FieldLayout fl = new FieldLayout(cowList[0].getData(), cowList[1].getData());
		MatchData md = info.getData();
		md.setLayout(fl);
		
		writer = new DataWriter(outputFile);
		writer.writeData(md);
		writer.close();
		
		System.out.println(md.toString());
		reset();
	}

	public void actionPerformed(ActionEvent e) {
		boolean[] validInfo = new boolean[3];
		
		validInfo[0] = DisplayError(info.validateData());
		validInfo[1] = DisplayError(cowList[0].validateData());
		validInfo[2] = DisplayError(cowList[1].validateData());

		if(validInfo[0] && validInfo[1] && validInfo[2]){
			extractData();
		} 
		//if(validInfo[0]) extractData();
	}
}
