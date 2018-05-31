import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Clapper project
 * 
 * @author a581781
 * 
 *         c1 - c2 - c3 - c4 - bulb
 * 
 *         0 - 0 - 0 - 0 - bulb claps
 * 
 * 
 *         1 - 0 - 0 - 0 - bulb 1 
 *         0 - 1 - 0 - 0 - bulb 2 
 *         1 - 1 - 1 - 0 - bulb 3
 *         0 - 0 - 0 - 1 - bulb 4 
 *         1 - 0 - 0 - 1 - bulb 5 
 *         0 - 1 - 0 - 1 - bulb 6
 *         1 - 1 - 1 - 1 - bulb 7 (ON)
 *
 */

public class ClapperMainTest {
	
	public static void main(String[] args) throws IOException {

		ClapperMainTest c = new ClapperMainTest();
		List<String> output = new ArrayList<String>();
		int counter = 0;
		for (String line : c.readFile()) {
			String[] elem = line.split(" ");
			if (elem.length == 2) {
				counter += 1;
				String outputline = "Experiment-" + counter + ":" + validate(Integer.parseInt(elem[0]), Integer.parseInt(elem[1]));
				output.add(outputline);
				System.out.println(outputline);
			}
		}
//		System.out.println(counter);
//		System.out.println(validate(Integer.parseInt("4"), Integer.parseInt("6")));
		
		Path file = Paths.get("output.txt");
		Files.write(file, output, Charset.forName("UTF-8"));
	}
	
	/**
	 * 4,7
	 * 
	 * @param numberOfClappers
	 * @param numberOfClaps
	 * @return
	 */
	private static String validate(int numberOfClappers, int numberOfClaps) {
		boolean bulbOn = false;

		int[] clapperArray = new int[numberOfClappers];
		int[] prevClapperArray = new int[numberOfClappers];
		// making all default as off
		for (int i = 0; i < numberOfClappers; i++) {
			clapperArray[i] = 0;
		}

		//
		for (int i = 0; i < numberOfClaps; i++) {

			copyArray(clapperArray, prevClapperArray);

			// since first clapper is connected to power supply, it will
			// always be off/on on each clap
			if (clapperArray[0] == 1)
				clapperArray[0] = 0;
			else
				clapperArray[0] = 1;

			for (int j = 1; j < clapperArray.length; j++) {
				if (prevClapperArray[j - 1] == 1) {
					// if previous clapper element was 1, then toggle is possible
					if (clapperArray[j] == 0)
						clapperArray[j] = 1;
					else
						clapperArray[j] = 0;
				}
			}
		}

		return checkIfAllClappersAreOn(clapperArray) ? "ON" : "OFF";
	}

	private static void copyArray(int[] src, int[] dest) {
		for (int i = 0; i < src.length; i++) {
			dest[i] = src[i];
		}
	}

	private static boolean checkIfAllClappersAreOn(int[] clapperArray) {
		for (int i = 0; i < clapperArray.length; i++) {
			if (clapperArray[i] == 0)
				return false;
		}
		return true;
	}

	public List<String> readFile() {
		URL url = getClass().getResource("/input_2.txt");
		List<String> list = new ArrayList<>();
		BufferedReader br = null;
		FileReader fr = null;

		try {
			File file = new File(url.toURI());

			// br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				list.add(sCurrentLine);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} catch (URISyntaxException e) {

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
		return list;

	}

}
