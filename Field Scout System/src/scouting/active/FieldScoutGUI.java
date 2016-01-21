package scouting.active;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * This class extends {@link JFrame} and is the top-level panel in the field scouting gui.
 * It should contain a {@link ClickabeFieldMap}, a {@link SelectionArea}, and a third (as
 * yet undefined) area to enter the information concerning Ranking Points.
 * @author Michael
 *
 */
public class FieldScoutGUI extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private ClickableFieldMap map;
	private SelectionPanel selector;
	
	public static void main(String[] args){
		JFrame.setDefaultLookAndFeelDecorated(true);
		// Create and set up the frame.
		JFrame frame = new JFrame("Field Scouting System v1.0");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FieldScoutGUI fsg = new FieldScoutGUI();
		
		fsg.setOpaque(true); // content panes must be opaque
		frame.setContentPane(fsg);
		// Display the window.
		frame.setSize(1000,800);
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
		//super("Field Scouting System v1.0");
		
		initialize();
		
		setLayout(new BorderLayout());
		add(map);
		//add(new JButton());
		add(selector);
	}
	
	public void initialize(){
		selector = new SelectionPanel();
		SelectionArea redSelector = new SelectionArea(selector);
		SelectionArea blueSelector = new SelectionArea(selector);
		
		map = new ClickableFieldMap("C:\\Users\\Public\\Documents\\fieldMap.PNG");
		
		ClickableOuterWorks blueOuterWorks = new ClickableOuterWorks(blueSelector);
		for(int i = 0; i < 4; i++){
			DefenseClickRegion dcr = new DefenseClickRegion(i, new Rectangle(10, 10 + 30 * i, 20, 20));
			blueOuterWorks.addDefense(dcr);
		}
		
		ClickableOuterWorks redOuterWorks = new ClickableOuterWorks(redSelector);
		for(int i = 0; i < 4; i++){
			DefenseClickRegion dcr = new DefenseClickRegion(i, new Rectangle(150, 10 + 30 * i, 20, 20));
			redOuterWorks.addDefense(dcr);
		}
		
		map.addOuterWorks(blueOuterWorks);
		map.addOuterWorks(redOuterWorks);
	}
}
