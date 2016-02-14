package scouting.active;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
/**
 * This class is a visual representation of a clickable map.
 * It extends {@link JPanel}, and overrides the paintComponent method to allow for setting the background to an {@link BufferedImage}.
 * A ClickableFieldMap can contain multiple kinds of {@link ClickRegion}s.
 * @author Michael
 */
public class ClickableFieldMap extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private BufferedImage map;
	
	public ClickableFieldMap(String imagePath){
		map = ImageMaker.createImage(imagePath);
		setLayout(null);
		setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
	}
	
	private void addDefenseClickRegion(DefenseClickRegion dcr){
		add(dcr);
		dcr.setBounds(dcr.getDims());
	}
	
	public void addOuterWorks(ClickableOuterWorks cow){
		for(DefenseClickRegion dcr: cow.getDefenses()){
			addDefenseClickRegion(dcr);
		}
	}
	
	public int getWidth(){
		return map.getWidth();
	}
	
	public int getHeight(){
		return map.getHeight();
	}

	protected void paintComponent(Graphics g){
	    super.paintComponent(g);
		setSize(map.getWidth(),map.getHeight());
        g.drawImage(map, 0, 0, null);
	}
}