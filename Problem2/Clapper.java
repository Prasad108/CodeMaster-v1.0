package com.test;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


public class Clapper
{

    public static void main(String[] args) throws FileNotFoundException
    {
        int number_of_experiments = 0;
        List<String> sampleString = new ArrayList<String>();
        String line;
        try
        {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader("C:\\a592296\\codeMaster\\CodeMaster-v1.0\\Problem2\\input_2.txt");

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null)
            {
                sampleString.add(line);
            }

            // Always close files.
            bufferedReader.close();
       
        PrintStream out = new PrintStream(new FileOutputStream("C:\\a592296\\codeMaster\\CodeMaster-v1.0\\Problem2\\output_2.txt"));
        for(String aa:sampleString){
        String[] animals = aa.split(" ");

        number_of_experiments++;
            if (number_of_experiments != 1)
            {
        System.out.print("Experiment-" + number_of_experiments + ":");
            System.out.println((Integer.parseInt(animals[1]) % Integer.parseInt(animals[0])) == 0 ? "ON" : "OFF");
            //  System.out.println((0 % 4) == 0 ? "ON" : "OFF");

                out.println((Integer.parseInt(animals[1]) % Integer.parseInt(animals[0])) == 0 ? "ON" : "OFF");
        
        }
        }
        out.close();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Unable to open file");
        }
        catch (IOException ex)
        {
            System.out.println("Error reading file '");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }
    }
