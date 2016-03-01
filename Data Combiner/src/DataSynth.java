import java.io.File;

public class DataSynth {
	
	
	private static final String outputFileName = "completeData.csv";
	private static final String inputFieldScoutFileName = "fieldScoutData.csv";
	private static final String inputRobotScoutFileName[] = {};
	
	public static void main(String[] args){
		FieldData fd = new FieldData(new File(inputFieldScoutFileName));
		System.out.println(fd);
		
		CompleteDataWriter dataOut = new CompleteDataWriter(new File(outputFileName), fd);
		
		for(int i = 0; i < inputRobotScoutFileName.length; i++){
			dataOut.write(new File(inputRobotScoutFileName[i]));
		}
	}
}
