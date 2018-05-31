package com.app.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the number of Experiments");
		int NumberOfExperiments=s.nextInt();
		int arr[][]=new int[NumberOfExperiments][2];
		for(int i=0;i<NumberOfExperiments;i++)
		{
			System.out.println("Enter the number of circuits for experiment :"+ (i+1) );
			arr[i][0]=s.nextInt();
			System.out.println("Enter the number of clapping experiment :"+(i+1));
			arr[i][1]=s.nextInt();
		}
	
		for(int i=0;i<NumberOfExperiments;i++)
		{
			int circuitArr[]=new int[arr[i][0]];
			for(int j=0;j<arr[i][1];j++) {
				circuitArr=Clapp(circuitArr);				
			}
			
			if(IsBulbOn(circuitArr)==true)
			{
				System.out.println("Experiment-"+(i+1)+" : ON ");
			}else {
				System.out.println("Experiment-"+(i+1)+" : OFF ");
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
