package test.net.atos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		int noOfExperiments = 0;
		int numberOfClappers;
		int numberOfClaps;
		ArrayList<Integer> clapperArray = new ArrayList<Integer>();
		ArrayList<Integer> clapsArray = new ArrayList<Integer>();

		noOfExperiments = readInputFile(noOfExperiments, clapperArray, clapsArray);

		for (int i = 0; i < noOfExperiments; i++) {
			numberOfClappers = clapperArray.get(i);
			numberOfClaps = clapsArray.get(i);
			int[] clappers = new int[numberOfClappers];
			int[] initialClappers = new int[numberOfClappers];
			;

			initialiseClapperStatus(numberOfClappers, clappers);
			setBulbState(numberOfClaps, clappers, initialClappers);

			System.out.println("Experiment- " + i + ":" + getClapperStatus(clappers));
		}

	}

	private static int readInputFile(int noOfExperiments, ArrayList<Integer> clapperArray,
			ArrayList<Integer> clapsArray) {
		try {
			BufferedReader brTest = new BufferedReader(new FileReader("src/main/resources/input_2.txt"));

			String line = brTest.readLine();
			noOfExperiments = Integer.parseInt(line);
			while (line != null) {
				line = brTest.readLine();
				if (line != null) {
					String[] strArray = line.split(" ");
					clapperArray.add(Integer.parseInt(strArray[0]));
					clapsArray.add(Integer.parseInt(strArray[1]));
				}
			}

		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		return noOfExperiments;
	}

	private static void setBulbState(int numberOfClaps, int[] clappers, int[] initialClappers) {

		for (int j = 0; j < numberOfClaps; j++) {

			initialClappers = Arrays.copyOf(clappers, clappers.length);

			if (clappers[0] == 1) {
				clappers[0] = 0;
			} else {
				clappers[0] = 1;
			}
			for (int k = 1; k < clappers.length; k++) {
				if (initialClappers[k - 1] == 1) {

					if (clappers[k] == 0) {
						clappers[k] = 1;
					}

					else {
						clappers[k] = 0;
					}

				}
			}
		}
	}

	private static void initialiseClapperStatus(int numberOfClappers, int[] clappers) {
		for (int i = 0; i < numberOfClappers; i++) {
			clappers[i] = 0;
		}
	}

	private static String getClapperStatus(int[] clapperArray) {
		for (int i = 0; i < clapperArray.length; i++) {
			if (clapperArray[i] == 0) {
				return "OFF";
			}

		}
		return "ON";
	}

}
