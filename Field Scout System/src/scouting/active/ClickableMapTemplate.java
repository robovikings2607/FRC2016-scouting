package scouting.active;

import java.awt.Rectangle;

import javax.swing.JFrame;
/**
 * A ClickableMapTemplate contains all of the information necessary to create an interactive field map
 * @author Michael
 *
 */
public class ClickableMapTemplate<T extends ClickRegion> {
	private Rectangle[] regionMap;
	private String imagePath;
	private ClickRegion areaType;
	
	public ClickableMapTemplate(String imagePath, Rectangle[] regionMap, ClickRegion areaType){
		this.imagePath = imagePath;
		this.regionMap = regionMap;
		this.areaType = areaType;
	}
	
	public Rectangle[] getRegionMap(){
		return regionMap;
	}

	public String getImagePath() {
		return imagePath;
	}

	public T getNewClickRegion(FieldScoutGUI parentFrame){
		
	}
	
	public ClickRegion getAreaType() {
		return areaType;
	}
}
