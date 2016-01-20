package scouting.active;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.event.MouseInputListener;

import scouting.datastorage.Defense;
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
	
	/**
	 * I have no clue if this actually works. It may lose the ability to be clicked,
	 * who knows. 
	 * @param number the number of the defense in the outer works
	 */
	public DefenseClickRegion(int number, FieldScoutGUI parentFrame){
		super(parentFrame);
		defenseNumber = number;
		defenseName = SelectionArea.emptyText;
		this.addMouseMotionListener(new DefenseClickRegionListener());
	}
	
	private class DefenseClickRegionListener implements MouseInputListener {
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			FieldScoutGUI parent = getParentFrame();
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			isSelected = true;
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			isSelected = false;
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			
		}

		@Override
		public void mouseDragged(MouseEvent arg0) {			
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {	
		}
	}
	
	public void setDefenseName(String defenseName){
		this.defenseName = defenseName;
		isFilled = !defenseName.equals("(none)");
	}
		
	public String getDefenseName() {
		return defenseName;
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
