package scouting.active;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SelectionPanel extends JPanel implements ActionListener{
	
	private int xDim = 125;
	private int yDim = 275;
	private static final long serialVersionUID = 1L;
	private static final String[] defenseList = {"Cheval de Frise", "Portcullis", "Moat", "Ramparts", "Drawbridge", "Sally Port", "Rock Wall", "Rough Terrain"};

	private DefenseClickRegion callingRegion;
	private String selectedDefense;
	
	public SelectionPanel(){
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setSize(xDim,yDim);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		
		ButtonGroup defenseSelectors = new ButtonGroup();
		RadioPickerListener rpl = new RadioPickerListener();
		
		for(int i = 0; i < defenseList.length; i++){
			JRadioButton jrb = new JRadioButton(defenseList[i]);
			jrb.setActionCommand(defenseList[i]);
			jrb.addActionListener(rpl);
			defenseSelectors.add(jrb);
			add(jrb);
		}
		
		JButton submitter = new JButton("Set Defense");
		submitter.addActionListener(this);
		add(submitter);
	}

	private class RadioPickerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			selectedDefense = e.getActionCommand();
			System.out.println(e.getActionCommand() + " selected");
		}
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		setSize(xDim,yDim);
	}
	
	public void setCallingRegion(DefenseClickRegion callingRegion) {
		this.callingRegion = callingRegion;
	}

	public int getWidth(){
		return xDim;
	}
	
	public int getHeight(){
		return yDim;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Attempted to set " + selectedDefense + " to the calling region.");
		if(!(callingRegion == null)){
			callingRegion.setDefenseName(selectedDefense);
			System.out.println("Set: " + callingRegion.toString());
		} else {
			System.out.println("Calling region was null");
		}
	}
}
