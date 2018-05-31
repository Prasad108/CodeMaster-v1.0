 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
 
/**
 * This program demonstrates how to read characters from a text file
 * using a BufferedReader for efficiency.
 * @author www.codejava.net
 *
 */
public class FraudStar {
 
    public static void main(String[] args) {
        try {
        	/**********************File Reader*************************/
        	String basePath = new File("").getAbsolutePath();
            FileReader reader = new FileReader(basePath+"\\src\\Input\\input_2.txt");  // Input File destination
            BufferedReader bufferedReader = new BufferedReader(reader);
            int nfExperiments = 0;
            int i = 0;
            String line; // To store Line Data
            List inputDataLine = new ArrayList();		// Storage for Input Line
            
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);			// Output Per Line Data
                if(i == 0){
                	nfExperiments = Integer.valueOf(line);
                }else{
                	String[] array = line.split(" ");
                	int clapper = Integer.parseInt(array[0]);
                	int claps = Integer.parseInt(array[1]);
                	inputDataLine.add("Experiment-"+i+" : "+processor(clapper,claps));
                }
                i++;
            }
            reader.close();
            outputWriter(inputDataLine);
            
          /**************Send to Writer*******************/  
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
        	e.printStackTrace();
        }
    }
    
    public static void outputWriter(Object obj) throws IOException{	
    	try {
    		
    		String basePath = new File("").getAbsolutePath();
    		FileOutputStream outputStream = new FileOutputStream(basePath+"\\src\\Output\\output.txt");
    		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-16");
    		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

    		if(obj instanceof ArrayList)
    		{
    			List iterate  = (ArrayList)obj;
    			for (Iterator iterator = iterate.iterator(); iterator.hasNext();) {
					String strLine = (String) iterator.next();
					bufferedWriter.write(strLine);
            		bufferedWriter.newLine();
				}
    			
        		bufferedWriter.close();
    		}
    		
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    
    
    /***Returns Tru or false based on Clappers and claps***/
    public static String processor(int clapper,int claps){
		
    	if(claps == 0){
    		return "OFF";
    	}
		Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();
		
		for (int i =1 ; i<= clapper;i++) {
			map.put(i,true);
		}
	//	System.out.println(map);
	//	System.out.println(map.get(1));
		for (int i = 0; i<claps-clapper; i++) {
			int j=1;
			if (j <= clapper) {
				if (map.get(j)) {
					map.put(j, false);
				} else {
					map.put(j, true);
				}
				j++;
			} else {
				j=1;
			}
		}
		
	//	System.out.println("Map ::"+map);
		if(map.values().contains(false)){
		//	System.out.println("OFF");
			return "OFF";
		}else{
		//	System.out.println("ON");
			return "ON";
		}
    }
    
 
}