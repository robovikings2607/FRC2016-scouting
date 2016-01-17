package scouting.active;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
/**
 * This is the {@link ClickRegion} to be used by the field scouts for interacting
 * with defenses. 
 * @author Michael
 *
 */
public class DefenseClickRegion extends ClickRegion {

	private static final long serialVersionUID = 1L;
	
	private final Color unfilled = Color.RED;
	private final Color filled = Color.GREEN;
	
	private int defenseNumber;
	private String defenseName;
	private boolean isSelected, isFilled;
	
	public DefenseClickRegion(int number){
		
	}
	
	public void mouseEntered(MouseEvent e){
		isSelected = true;
	}
	
	public void mouseExited(MouseEvent e){
		isSelected = false;
	}
	
	public void mouseClicked(MouseEvent e){
		//open up defense selection panel
	}
	
	public void setDefenseName(String defenseName){
		this.defenseName = defenseName;
		isFilled = !defenseName.equals("(none)");
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		if(isFilled){
			setBackground(filled);
		} else {
			setBackground(unfilled);
		}
		g.drawString(defenseNumber + "", getWidth() / 2, getHeight() / 2);
		if(isSelected){
			setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.YELLOW));
		}
	}
}
