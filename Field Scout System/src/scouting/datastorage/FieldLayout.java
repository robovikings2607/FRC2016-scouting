package scouting.datastorage;
/**
 * This class contains the layouts of both {@link OuterWorks} in a single match
 * @author Michael
 */
public class FieldLayout {
	private OuterWorks redOuterWorks, blueOuterWorks;
	
	public FieldLayout(OuterWorks red, OuterWorks blue){
		redOuterWorks = red;
		blueOuterWorks = blue;
	}

	public OuterWorks getRedOuterWorks() {
		return redOuterWorks;
	}

	public OuterWorks getBlueOuterWorks() {
		return blueOuterWorks;
	}
}
