package net.atos.wlp.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Solution {

	private static final String FILENAME = "C:\\Saurabh\\CodingCompition\\CodeMaster-v1.0\\Problem1\\input_1.txt";
	private static BufferedReader br = null;
	private static FileReader fr = null;

	public static void main(String[] args) {

		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine = br.readLine();

			int noOfDays = Integer.parseInt(sCurrentLine);

			System.out.println("No of days bus required: " + sCurrentLine);

			for (int i = 0; i < noOfDays; i++) {

				// get tea break time

				int teaBreakTime = 0;
				int ab = 0;
				int ba = 0;
				int counter = 0;
				while ((sCurrentLine = br.readLine()) != null) {

					String[] lineValues = sCurrentLine.split(" ");

					if (lineValues.length == 1) {
						teaBreakTime = Integer.parseInt(lineValues[0]);
//						System.out.println("tea time break is: " + teaBreakTime);
						continue;
					} else if (sCurrentLine.contains(":")) {

						List<BusTiming> airoliTimings = new ArrayList<>();
						List<BusTiming> borivaliTimings = new ArrayList<>();

						while (true) {
							// time
							if (counter >= (ab + ba)) {
								counter = 0;
								break;
							}
							sCurrentLine = counter == 0 ? sCurrentLine : br.readLine();

							if (counter < ab) {
								BusTiming busTimings = busTimings(sCurrentLine, "airoli");
								airoliTimings.add(busTimings);
								counter++;
							} else {
								BusTiming busTimings = busTimings(sCurrentLine, "borivali");
								borivaliTimings.add(busTimings);
								counter++;
							}

						}

						airoliTimings.sort(new Comparator<BusTiming>() {

							@Override
							public int compare(BusTiming o1, BusTiming o2) {
								return o1.getArrivalTime().compareTo(o2.getArrivalTime());
							}
						});

						borivaliTimings.sort(new Comparator<BusTiming>() {

							@Override
							public int compare(BusTiming o1, BusTiming o2) {
								return o1.getArrivalTime().compareTo(o2.getArrivalTime());
							}
						});

						int noOfBusesRequiredFromAiroli = 0; 
						for (BusTiming busTiming : airoliTimings) {
//							System.out
//									.print("bus departure timing from " + "airoli" + ": " + busTiming.getArrivalTime());
//							System.out.println(
//									"---> bus departure timing from " + "airoli" + ": " + busTiming.getDepartureTime());

							boolean isBusAvalable = isBusAvailableFromArrivalListOfAiroli(teaBreakTime, airoliTimings,
									busTiming);
							
							if(!isBusAvalable){
								noOfBusesRequiredFromAiroli++;
							}

						}

						int noOfBusesRequiredFromBorivali = 0; 
						for (BusTiming busTiming : borivaliTimings) {
//							System.out.print(
//									"bus departure timing from " + "bolivali" + ": " + busTiming.getArrivalTime());
//							System.out.println("---> bus departure timing from " + "bolivali" + ": "
//									+ busTiming.getDepartureTime());

							boolean isBusAvalable = isBusAvailableFromArrivalListOfAiroli(teaBreakTime, airoliTimings,
									busTiming);
							
							if(!isBusAvalable){
								noOfBusesRequiredFromBorivali++;
							}

						}
						
//						System.out.println("No. of buses requiredFromAiroli is " + noOfBusesRequiredFromAiroli);
//						System.out.println("No. of buses requiredFromBolivali is " + noOfBusesRequiredFromBorivali);

						int a = airoliTimings.size()>borivaliTimings.size()? airoliTimings.size() : noOfBusesRequiredFromAiroli;
						int b = borivaliTimings.size()<airoliTimings.size()? borivaliTimings.size() : noOfBusesRequiredFromBorivali;
						
						System.out.println("Day-" + i + ": " + a + " " + b);
						continue;
					} else {
						// no of trips
						String[] noOfBusesFromEachStation = sCurrentLine.split(" ");
						ab = Integer.parseInt(noOfBusesFromEachStation[0]);
						ba = Integer.parseInt(noOfBusesFromEachStation[1]);
//						System.out.print("No. of buses from Airoli: " + ab);
//						System.out.println("--> No. of buses from Boribali: " + ba);
						continue;
					}

				}
				// no. of trips --> AB BA
				// no. of Ab trips
				// no. of BA trips

			}
			/*
			 * while ((sCurrentLine = br.readLine()) != null) {
			 * System.out.println(sCurrentLine); }
			 */
		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}

	private static boolean isBusAvailableFromArrivalListOfAiroli(int teaBreakTime, List<BusTiming> busTimings,
			BusTiming busTiming) {

		boolean busAvailable = false;
		for (BusTiming busFromAiroli : busTimings) {
			busAvailable = (busTiming.getArrivalTime().getTime() + teaBreakTime * 60 + 1000) <= busFromAiroli
					.getDepartureTime().getTime();
			if (busAvailable) {
				break;
			}
		}

		return busAvailable;
	}

	private static BusTiming busTimings(String sCurrentLine, String station) {
		String[] busTiming = sCurrentLine.split(" ");

		String arrivalTime = busTiming[0];
		String departureTime = busTiming[1];

		// System.out.print("bus departure timing from " + station + ": " +
		// arrivalTime);
		// System.out.println("---> bus departure timing from " + station + ": "
		// + departureTime);

		String[] arivalArr = arrivalTime.split(":");
		String[] depArr = departureTime.split(":");

		BusTiming timing = new BusTiming(getDate(arivalArr[0], arivalArr[1]), getDate(depArr[0], depArr[1]));

		return timing;
	}

	private static Date getDate(String hrsStr, String minsStr) {

		int hrs = Integer.parseInt(hrsStr);

		int mins = Integer.parseInt(minsStr);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, hrs);
		cal.set(Calendar.MINUTE, mins);
		cal.set(Calendar.SECOND, 0);

		return cal.getTime();
	}

}
