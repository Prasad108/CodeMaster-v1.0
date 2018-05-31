import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) throws IOException {
		File dir = new File(".");
		String dest = dir.getAbsolutePath() + File.separator + "Problem2/output_2.txt";
		FileWriter fstream = new FileWriter(dest, false);
		BufferedWriter out = new BufferedWriter(fstream);
		Scanner s = new Scanner(new File("Problem2/input_2.txt"));
		int experiments = s.nextInt();
		String bulb = "OFF";
		int clappers = 0;
		int claps = 0;
		for (int i = 0; i < experiments; i++) {
			clappers = s.nextInt();
			claps = s.nextInt();
			if (claps >= clappers) {
				if ((clappers % 2 != 0) && (claps % 2 != 0)) {
					bulb = "ON";
				} else if ((clappers % 2 == 0) && (claps % 2 == 0)) {
					bulb = "OFF";
				} else if ((clappers % 2 != 0) && (claps % 2 == 0)) {
					bulb = "OFF";
				} else if ((clappers % 2 == 0) && (claps % 2 != 0)) {
					bulb = "ON";
				}
			} else {
				bulb = "OFF";
			}
			out.write("Experiment-" + (i + 1) + ": " + bulb);
			out.newLine();
		}
		out.close();
		s.close();
	}
}