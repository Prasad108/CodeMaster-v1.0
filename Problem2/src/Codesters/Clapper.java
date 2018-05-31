package Codesters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Clapper {

	public static void main(String args[]) {
		String bulbState = "OFF";
		BufferedReader br = null;
		FileReader fr = null;
		final String FILENAME = "C:/codemaster_wrkspc/codesters/CodeMaster-v1.0/Problem2/input_2.txt";
		int inputarr[][];
		try {

		//	br = new BufferedReader(new FileReader(""));
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			String sCurrentLine;
			sCurrentLine = br.readLine();
			inputarr = new int[Integer.parseInt(sCurrentLine)][2];
			String [] temp;
			int cnt=0, n=0, c=0;
			
			//creating the input array
			while ((sCurrentLine = br.readLine()) != null) {
				
				temp = sCurrentLine.split(" ");
				inputarr[cnt][0] = Integer.parseInt(temp[0]);
				inputarr[cnt][1] = Integer.parseInt(temp[1]);
				cnt ++;
				
				n = Integer.parseInt(temp[0]);
				c = Integer.parseInt(temp[1]);
				if ((c + 1) % 4 == 0) {
					if (n <= c && !(n+4>c))
						bulbState = "ON";
				}
				System.out.println("Experiment-" + cnt +":" + bulbState);
			
			}
			//actual logic
		

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
}
