package com.techforum.codemaster;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class CodeMaster {

	public static void main(String[] args) throws IOException {

		File theFile = new File("C:\\Users\\a604138\\Documents\\My Received Files\\input_1.txt");

		LineIterator it = FileUtils.lineIterator(theFile, "UTF-8");
		String totalDays;
		String tripBreak = null;
		Long totalTripForDay = null;
		String value = null;
		ArrayList<String> list = null;
		Map<String, List<String>> map = new HashMap<>();

		int rowCount = 0;
		while (it.hasNext()) {
			if (rowCount == 0) {
				value = it.nextLine();
				totalDays = value;
			} else {
				value = it.nextLine();
				if (map.get(tripBreak) == null) {
					map.put(tripBreak, list);
				}
				if (!value.contains(" ")) {
					tripBreak = value;
					list = new ArrayList<>();
					System.out.println("tripBreak" + tripBreak);
				} else {
					if (!value.contains(":")) {
						String[] valueSplit = value.split(" ");
						totalTripForDay = Long.parseLong(valueSplit[0]) + Long.parseLong(valueSplit[1]);
					} else {
						list.add(value);
					}
				}

			}
			rowCount++;

		}

	}
}
