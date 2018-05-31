package com.app.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		
		
		BufferedReader in = new BufferedReader(new FileReader("C:/Users/a664162/Desktop/input_2.txt"));
		String str;

		List<String> list = new ArrayList<String>();

		while((str = in.readLine()) != null){
			//System.out.println(str);
		    list.add(str);
		}
		
		

		
	
		Scanner s=new Scanner(System.in);

		int NumberOfExperiments=Integer.parseInt(list.get(0));
		
		int arr[][]=new int[NumberOfExperiments][2];
		for(int i=1;i<list.size();i++)
		{
		
			String inputTextLine=list.get(i);
			String[] values=inputTextLine.split(" ");
			
				arr[i-1][0]=Integer.parseInt(values[0]);
				arr[i-1][1]=Integer.parseInt(values[1]);		
		}
		
		
		
		
		/*for(int i=0;i<NumberOfExperiments;i++)
		{
			
			for(int j=0;j<2;j++) {
							System.out.println(arr[i][j]);
			}
			
		
		}*/
		
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt"), "utf-8"));
		
		
	
		for(int i=0;i<NumberOfExperiments;i++)
		{
			int circuitArr[]=new int[arr[i][0]];
			for(int j=0;j<arr[i][1];j++) {
				circuitArr=Clapp(circuitArr);				
			}
			
			if(IsBulbOn(circuitArr)==true)
			{
				writer.write("Experiment-"+(i+1)+" : ON ");
				((BufferedWriter) writer).newLine();
				//System.out.println("Experiment-"+(i+1)+" : ON ");
			}else {
				writer.write("Experiment-"+(i+1)+" : OFF ");
				((BufferedWriter) writer).newLine();
				//System.out.println("Experiment-"+(i+1)+" : OFF ");
			}			
		}
		
		
		
	
		
		
	}
	

	
	public static int[] Clapp(int [] arr) {		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==0) {
				arr[i]=1;
				break;
			}else {
				arr[i]=0;
			}
		}
		return arr;
	}
	
	public static boolean IsBulbOn(int [] arr) {
		for(int i=0;i<arr.length;i++) {	
			if(arr[i]==0) {
				return false;
				}
			}
			return true;
	}

}
