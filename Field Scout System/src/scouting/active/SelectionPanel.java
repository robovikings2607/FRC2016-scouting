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
	
	public SelectionPanel(){
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setSize(xDim,yDim);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		
		ButtonGroup defenseSelectors = new ButtonGroup();
		for(int i = 0; i < defenseList.length; i++){
			JRadioButton jrb = new JRadioButton(defenseList[i]);
			defenseSelectors.add(jrb);
			add(jrb);
		}
		
		JButton submitter = new JButton("Set Defense");
		submitter.addActionListener(this);
		add(submitter);
	}
/*
	public void replaceSelector(SelectionArea selector){
		removeAll();
		add(selector);
	}
	*/
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		setSize(xDim,yDim);
	}
	
	public int getWidth(){
		return xDim;
	}
	
	public int getHeight(){
		return yDim;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(callingRegion != null){
			callingRegion.setDefenseName(defenseName);
		}
	}
}
