import java.io.File;
/*import java.io.IOException;
import java.util.Scanner; */

public class DataSynth {
	
	
	private static final String outputFileName = "completeData.csv";
	private static final String inputFieldScoutFileName = "fieldScoutData.csv";
	private static final String inputRobotScoutFileName[] = {"Red1.csv","Red2.csv","Red3.csv","Blue1.csv","Blue2.csv","Blue3.csv"};
	
	public static void main(String[] args){
		System.out.println();
		
		FieldData fd = new FieldData(new File(inputFieldScoutFileName));
		
		CompleteDataWriter dataOut = new CompleteDataWriter(new File(outputFileName), fd);
		
		for(int i = 0; i < inputRobotScoutFileName.length; i++){
			dataOut.write(new File(inputRobotScoutFileName[i]));
		}
		
		dataOut.closeWriter();
		System.out.println("Done, completeData.csv updated");
	/*	System.out.println("Press enter to close.");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		scan.close(); */
	}
}
