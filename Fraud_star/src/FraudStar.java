 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
/**
 * This program demonstrates how to read characters from a text file
 * using a BufferedReader for efficiency.
 * @author www.codejava.net
 *
 */
public class FraudStar {
 
    public static void main(String[] args) {
        try {
        	
        	String basePath = new File("").getAbsolutePath();
            FileReader reader = new FileReader(basePath+"\\src\\Input\\Input.txt");  // Input File destination
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line; // To store Line Data
            List inputDataLine = new ArrayList();
            
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);			// Output Per Line Data
                inputDataLine.add(line);
            }
            reader.close();
            outputWriter(inputDataLine);
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
    
 
}