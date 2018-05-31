package com.awl.codemaster.technomaster;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AtosBusService {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		String fileName = "C:\\Mahesh Mandhare\\CodeMaster\\BusService\\src\\test\\resources\\input\\input.txt";
		List<String> lines = readFileData(fileName);
	   
	    processData(lines);
	}


	private static void processData(List<String> lines) {
	          List<BusDetails> busDetails = new ArrayList<BusDetails>();
	          busDetails.get(0).setNoOfDays(Integer.parseInt(lines.get(0)));
	          for (int lineCounter = 1; lineCounter<lines.size(); lineCounter++) {
	        	  for (int counter = 0; counter <= busDetails.get(0).getNoOfDays(); counter++) {
		        	  String splittedString[] = lines.get(lineCounter).split(" ");
		        	  System.out.println("Length" + splittedString.length);
		        	  int recordCounter;
		        	  try {
		        		  if (splittedString.length == 2) {
			        		  recordCounter = Integer.parseInt(splittedString[0]) + Integer.parseInt(splittedString[1]);
			        		  System.out.println("recordCounter " + recordCounter);
			        	  } 
		        	  } catch(Exception e) {
		        		  
		        	  } 
		          }  
	          }
	          
	}


	private static List<String> readFileData(String fileName) throws IOException {
	    BufferedReader abc = new BufferedReader(new FileReader(fileName));
	    List<String> lines = new ArrayList<String>();

	    String line;
		while((line = abc.readLine()) != null) {
	        lines.add(line);
	        //System.out.println(line);
	    }
	    abc.close();
		return lines;
	}
	
	
	

}
