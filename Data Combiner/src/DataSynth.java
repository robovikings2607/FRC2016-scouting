import java.io.File;

public class DataSynth {
	
	
	private static final String outputFileName = "completeData.csv";
	private static final String inputFieldScoutFileName = "fieldScoutData.csv";
	private static final String inputRobotScoutFileName[] = {"Red1.csv","Red2.csv","Red3.csv","Blue1.csv","Blue2.csv","Blue3.csv"};
	
	public static void main(String[] args){
		FieldData fd = new FieldData(new File(inputFieldScoutFileName));
		System.out.println("Extracted Field Data");
		
		CompleteDataWriter dataOut = new CompleteDataWriter(new File(outputFileName), fd);
		
		for(int i = 0; i < inputRobotScoutFileName.length; i++){
			dataOut.write(new File(inputRobotScoutFileName[i]));
		}
		
		dataOut.closeWriter();
		System.out.println("Done, completeData.csv updated");
	}
}
