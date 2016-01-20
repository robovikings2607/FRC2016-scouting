package scouting.active;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * This class is a visual representation of a clickable map.
 * It extends {@link JPanel}, and overrides the paintComponent method to allow for setting the background to an {@link BufferedImage}.
 * A ClickableFieldMap can contain multiple kinds of {@link ClickRegion}s.
 * @author Michael
 */
public class ClickableFieldMap extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private Image map;
	private JFrame parentFrame;
	
	public ClickableFieldMap(ClickableMapTemplate template, JFrame parentFrame){
		map = ImageMaker.createImage(template.getImagePath());
		setLayout(null);
		addClickRegion(template);
		this.parentFrame = parentFrame;
	}
	
	public void addClickRegion(Rectangle dim, ClickRegion cr){
		add(cr);
		cr.setBounds(dim);
	}
	
	public void addClickRegion(ClickableMapTemplate crt){
		Rectangle[] dims = crt.getRegionMap();
		for(int i = 0; i < dims.length; i++){
			addClickRegion(dims[i], crt.getAreaType());
		}
	}
	
	protected void paintComponent(Graphics g){
	    super.paintComponent(g);
        g.drawImage(map, 0, 0, null);
	}
}
