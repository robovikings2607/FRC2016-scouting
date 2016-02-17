package scouting.active;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

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
	private static final int[] defenseMnemonics = {KeyEvent.VK_C, KeyEvent.VK_P, KeyEvent.VK_M, KeyEvent.VK_R, KeyEvent.VK_D, KeyEvent.VK_L, KeyEvent.VK_K, KeyEvent.VK_T,};
	
	private DefenseClickRegion callingRegion;
	private String selectedDefense;
	private ButtonGroup defenseSelectors;
	
	public SelectionPanel(){
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setSize(xDim,yDim);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		
		defenseSelectors = new ButtonGroup();
		RadioPickerListener rpl = new RadioPickerListener();
		
		for(int i = 0; i < defenseList.length; i++){
			JRadioButton jrb = new JRadioButton(defenseList[i]);
			jrb.setActionCommand(defenseList[i]);
			jrb.addActionListener(rpl);
			jrb.setMnemonic(defenseMnemonics[i]);
			defenseSelectors.add(jrb);
			add(jrb);
		}
		
		JButton submitter = new JButton("Set Defense");
		submitter.addActionListener(this);
		submitter.setMnemonic(KeyEvent.VK_S);
		add(submitter);
	}

	private class RadioPickerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			selectedDefense = e.getActionCommand();
			//System.out.println(e.getActionCommand() + " selected");
		}
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		setSize(xDim,yDim);
	}
	
	public void setCallingRegion(DefenseClickRegion callingRegion) {
		this.callingRegion = callingRegion;
		defenseSelectors.clearSelection();
		selectedDefense = null;
	}

	public int getWidth(){
		return xDim;
	}
	
	public int getHeight(){
		return yDim;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("Attempted to set " + selectedDefense + " to the calling region.");
		if(callingRegion != null && selectedDefense != null){
			System.out.println("Set: " + callingRegion.toString());
			callingRegion.setDefenseName(selectedDefense);
		} else {
			if(callingRegion == null)
				System.out.println("Calling region was null");
			if(selectedDefense == null)
				System.out.println("Selected defense was null");
		}
	}
}
