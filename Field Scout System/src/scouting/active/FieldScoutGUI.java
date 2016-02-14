package scouting.active;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;

import scouting.datastorage.AllianceColor;
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
	private InfoPanel info;
	private ClickableOuterWorks[] cowList = new ClickableOuterWorks[2];
	
	public static void main(String[] args){

		JFrame frame = new JFrame("Field Scouting System v1.0");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FieldScoutGUI fsg = new FieldScoutGUI();
		
		fsg.setOpaque(true); 
		frame.setContentPane(fsg);
		// Display the window.
		frame.setSize(fsg.map.getWidth() + fsg.selector.getWidth() + 21,600);
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
	}
	
	public void initialize(){
		selector = new SelectionPanel();
		info = new InfoPanel(1);
		
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
	}
}
