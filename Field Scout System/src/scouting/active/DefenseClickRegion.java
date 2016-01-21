package scouting.active;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
/**
 * This is the {@link ClickRegion} to be used by the field scouts for interacting
 * with defenses. 
 * @author Michael
 *
 */
public class DefenseClickRegion extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private final Color unfilled = Color.RED;
	private final Color filled = Color.GREEN;
	
	private int defenseNumber;
	private String defenseName;
	private boolean isSelected, isFilled;
	private SelectionArea selector;
	private Rectangle dims;
	

	public DefenseClickRegion(int number, Rectangle dims){
		this.dims = dims;
		defenseNumber = number;
		defenseName = SelectionArea.emptyText;
		this.addMouseListener(new DefenseClickRegionListener());
	}
	
	public void addSelectionArea(SelectionArea selector){
		this.selector = selector;
	}
	
	public Rectangle getDims() {
		return dims;
	}

	private class DefenseClickRegionListener implements MouseInputListener {
		
		public DefenseClickRegionListener(){
			System.out.println("DefenseClickRegion created: " + this);
		}
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			selector.display(getThis());
			System.out.println("Click!");
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			isSelected = true;
			getThis().repaint();
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			isSelected = false;
			getThis().repaint();
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
		repaint();
	}
		
	public String getDefenseName() {
		return defenseName;
	}
	
	public int getDefenseNumber(){
		return defenseNumber;
	}
	
	private DefenseClickRegion getThis(){
		return this;
	}

	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		if(isFilled){
			setBackground(filled);
		} else {
			setBackground(unfilled);
		}
		g.drawString(defenseNumber + 1 + "", getWidth() / 2, getHeight() / 2);
		if(isSelected){
			setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.YELLOW));
		} else {
			setBorder(null);
		}
	}
}
