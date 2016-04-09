package scouting.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import scouting.datastorage.FieldLayout;
import scouting.datastorage.MatchData;
import scouting.datastorage.OuterWorks;

public class DataWriter {
	private PrintWriter writer;
	
	public DataWriter(String filePath){
		try{
			File file = new File(filePath);
			boolean existence = file.exists();
			writer = new PrintWriter(new FileOutputStream(file, true));
			if(!existence){
				System.out.println("Created new file!");
				initialize();
			} else {
				System.out.println("Appending to old file!");
			}
		} catch (IOException e){
			System.out.println("You broked it :(");
		}
	}
	
	public void writeData(MatchData md){
		writer.print(md.getMatchNumber() + ",");
		
		int[] teams = md.getTeams();
		for(int i = 0; i < teams.length; i++){
			writer.print(teams[i] + ",");
		}
		
		int[] finalScores = md.getFinalScores();
		for(int i = 0; i < finalScores.length; i++){
			writer.print(finalScores[i] + ",");
		}
		
		writer.print(md.getCapture().name() + ",");
		writer.print(md.getBreach().name() + ",");
		
		FieldLayout fl = md.getLayout();
		OuterWorks red = fl.getRedOuterWorks();
		OuterWorks blue = fl.getBlueOuterWorks();
		for(int i = 0; i < 5; i++){
			writer.print(red.getDefense(i + 1).getName() + ",");
		}
		for(int i = 0; i < 4; i++){
			writer.print(blue.getDefense(i + 1).getName() + ",");
		}
		writer.println(blue.getDefense(5).getName());
	}
	
	private void initialize() {
		writer.print("MatchNumber,Red1,Red2,Red3,Blue1,Blue2,Blue3,RedFinalScore,BlueFinalScore,");
		writer.println("Capture,Breach,DRed1,DRed2,DRed3,DRed4,DRed5,DBlue1,DBlue2,DBlue3,DBlue4,DBlue5");
	}
	
	public void close(){
		writer.close();
	}
}
