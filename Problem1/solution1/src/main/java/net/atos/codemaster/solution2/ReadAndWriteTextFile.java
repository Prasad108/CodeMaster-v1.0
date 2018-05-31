package net.atos.codemaster.solution2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ReadAndWriteTextFile {
	public static String inputFile = "src/main/java/input_1.txt";
	public static String outputFile = "src/main/java/output_1.txt";
	 public static void main(String srgs[]) {
		 
	        System.out.println("Writing to file: " + outputFile);
	      
	        try {
	        	BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile));
	        	
	        	int lineCount=0;
	        	int totalNumberOfdays=0;
	        	int dayCount=0;
	        	BufferedReader reader;
	    		try {
	    			reader = new BufferedReader(new FileReader(
	    					inputFile));
	    			String line = reader.readLine();
	    			while (line != null) {
	    				
	    				 if(lineCount ==0){
	    	        		 totalNumberOfdays=new Integer(line);
	    	        		 lineCount++;
	    	        	 }else{
	    	        		if(!line.contains(" ")){
	    	        			dayCount++;
	    	        		int teaTime=new Integer(line);
	    	        		}else{
	    	        			if(line.contains(":")){
	    	        				
	    	        			}else{
	    	        				String trips[] =line.split(" ");
	    	        				
	    	        				writer.write("Day-"+dayCount+ ": "+trips[0] +" "+trips[1]+"\n");
	    	        				System.out.println("Write");
	    	        			}
	    	        		}
	    	        			
	    	        	 }
	    				// read next line
	    				line = reader.readLine();
	    			}
	    			reader.close();
	    			writer.close();
	    		} catch (IOException e) {
	    			e.printStackTrace();
	    		}
	        	
	        
	        	
	        	
	        	 
	        	
	        	 
	        	 
	        }catch (NoSuchFileException e) {
	 				System.out.println("Please provide valid file name");
	 			}
	         catch (IOException e1) {
				// TODO Auto-generated catch block
	        	 System.out.println("Some thing went wrong");
			}
		System.out.println("Done");
		//return true;
		
	
	 }
}