package com.worldline.codemaster.helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FileReader {

	public static void main(String[] args) throws IOException {

		BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter("problem2//output2"));
		
		File inputFile = new File("Problem2//input_2.txt");
		try {
			Scanner scanner = new Scanner(inputFile);
			int numOfLine = 0;

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				numOfLine++;
				if (numOfLine == 1) {
					continue;
				}
				String[] str = line.split(" ");
				System.out.println("Experiment-" + (numOfLine - 1 )+ ": "
						+ FileReader.switchProcessor(Integer.parseInt(str[0]), Integer.parseInt(str[1])));

			}
			scanner.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String switchProcessor(int clapper, int claps) {

		if (claps == 0)
			return "OFF";
		Map<Integer, Boolean> temp = new HashMap<Integer, Boolean>();

		for (int i = 0; i <= clapper; i++) {
			temp.put(i, false);
		}

		temp.put(0, true);
		for (int i = 0; i <= claps; i++) {
			int j = 1;

			if (temp.get(j - 1)) {
				if (temp.get(j)) {
					temp.put(j, true);
				} else {
					temp.put(j, false);
				}
			}

			j++;

			if (j == temp.size() - 1)
				j = 0;

		}

		Iterator it = temp.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			
			if (!(Boolean.parseBoolean(String.valueOf(pair.getValue())))) {
				return "OFF";
			}
		}

		return "ON";
	}

}
