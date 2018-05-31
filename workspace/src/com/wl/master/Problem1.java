package com.wl.master;

import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {

		int a = 0;
		int temp =0;
		float b;
		String s;

		
		Scanner in = new Scanner(System.in);
		Scanner schedule = null;

		Scanner tripPerDay = null;
		System.out.println("Enter no of days->");

		try {
			a = in.nextInt();
		} catch (Exception e) {
			System.out.println("Please enter valid no. like - 1, 3, 6 etc.");

		}

		System.out.println("You entered integer " + a);
		int abArray[] = new int[a];
		int baArray[] = new int[a];
		int teaBreak[] = new int[a];
		int totalTrips =0;
		String [][]departArriveSchedule ;
		//For iterate over no of days.
		for (int c = 0; c < a; c++) {

			
			System.out.println("Enter driver's time beak in mintuns( 0, 5, 10 etc) for" + c + " day :-");
			teaBreak[c] = in.nextInt();
			System.out.println("Enter no of trip from Airoli to Borivali");
			tripPerDay = new Scanner(System.in).useDelimiter("\\s"); 
			
			abArray[c] = tripPerDay.nextInt();
			
		//	System.out.println("Enter no of trip from Airoli to Borivali");
			baArray[c] = tripPerDay.nextInt();
			
			totalTrips = abArray[c] + baArray[c];
			
			System.out.println("Todal trips - " + totalTrips);
			//Inner loop for accepting trip schedules;
			for(int i = 0 ; i < totalTrips ; i++){
//				String s1 ;
//				String s2;
				departArriveSchedule = new String[totalTrips ][2] ;
				System.out.println("Enter departure and arrival time in 24 hours formate hh:mm only for " + i+ " :-");
				 schedule = new Scanner(System.in).useDelimiter("\\s");  
//				 System.out.println(s1 + " -" + s2);
				 departArriveSchedule[i][0] = schedule.next();
				 departArriveSchedule[i][1] = schedule.next();
				// System.out.println( + " -- " + schedule.next());
				//
				 System.out.println(departArriveSchedule[i][0] + " " +departArriveSchedule[i][1]);
				
			}
			
		}

	}

}
