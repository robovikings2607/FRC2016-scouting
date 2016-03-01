import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

/**
 * A data storage class created from a CSV file that provides storage and access for
 * all of the data collected by the Field Scout. It extends HashMap<Integer, String[]>.
 * The key for each element is the match number, and the value is the String[] generated
 * by breaking up the CSV file along the ',' tokens.
 * @author Michael
 *
 */

public class FieldData extends HashMap<Integer, String[]>{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * This constructor creates the FieldData object from a CSV file. 
	 * @param fieldDataCSV The {@link File} representation of the CSV file containing 
	 * the Field Scout's data
	 */
	public FieldData(File fieldDataCSV){
		try{
			BufferedReader reader = new BufferedReader(new FileReader(fieldDataCSV));
			//Start the reader at the line past the header
			String nextLine = reader.readLine();
			while ((nextLine = reader.readLine()) != null){
				addEntry(nextLine);
			}
			reader.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Takes a line of a CSV file and generates an entry in the {@link FieldData} object.
	 * The Key is set as the match number, and the full line is stored as a String[] as the value.
	 * @param line The line from the CSV file containing data for a match.
	 * Must contain 21 elements.
	 */
	private void addEntry(String line){
		String[] entry = new String[21];
		for(int i = 0; i < 20; i++){
			int j = line.indexOf(',');
			entry[i] = line.substring(0, j);
			line = line.substring(j + 1);
		}
		entry[20] = line;
		
		int matchNumber = Integer.parseInt(entry[0]);
		if(!containsKey(matchNumber)){
			put(matchNumber, entry);
		} else {
			System.out.println("Redundant match found:");
			System.out.println(Arrays.toString(get(matchNumber)));
			System.out.println(Arrays.toString(entry));
		}
	}
	
	/**
	 * This method finds which matches below the maximum match value are missing
	 * an entry in the FieldData.
	 * @return A sorted array (smallest->largest) containing the number of all of the matches 
	 * for which no data is stored
	 */
	public int[] checkForMissingData(){
		int[] missing = new int[size()];
		
		int maxMatch = getMaxMatchNumber();
		int ind = 0;
		for(int i = 1; i <= maxMatch; i++){
			if(!containsKey(i)){
				missing[ind] = i;
				ind++;
			}
		}
		
		int[] missingTrimmed = new int[ind];
		for(int i = 0; i < ind; i++){
			missingTrimmed[i] = missing[i];
		}
			
		return missingTrimmed;
	}
	
	/**
	 * Finds the maximum match value stored in the FieldData.
	 * @return The maximum match value.
	 */
	private int getMaxMatchNumber(){
		String[][] data = new String[0][0];
		data = values().toArray(data);
		
		int maxMatch = 0;
		for(int i = 0; i < data.length; i++){
			int m = Integer.parseInt(data[i][0]);
			if(m > maxMatch){
				maxMatch = m;
			}
		}
		return maxMatch;
	}
		
	/**
	 * Returns all matches stored in the FieldData, followed by information
	 * about which matches are missing data.
	 */
	public String toString(){
		String retVal = "";
		String[][] data = new String[0][0];
		data = values().toArray(data);
		
		for(int i = 0; i < data.length; i++){
			retVal += Arrays.toString(data[i]) + "\n";
		}
		
		retVal += "Missing matches: " + Arrays.toString(checkForMissingData());
		return retVal;
	}
}
