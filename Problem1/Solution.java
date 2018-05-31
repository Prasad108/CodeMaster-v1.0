import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {

	static int nb_bus_in_A = 0;
	int nb_bus_in_b = 0;
	static int nb_bus_needed_A = 0;
	int nb_bus_needed_B = 0;
	int date_NumberofTravel;
	static long teaTime;
	static int nbDay=100;

	private static Map<String, String> mapAB = new HashMap<String, String>();
	private static Map<String, String> mapBA = new HashMap<String, String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String fileName = "C:/CadeCatalyst/CodeMaster-v1.0/Problem1/input_1.txt";
		File file = new File(fileName);
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		String line;
		long teaTime;
		try {
			while ((line = br.readLine()) != null) {
				// process the line
				System.out.println(line);
				for(int i=0;i<=nbDay;i++){
					teaTime=Long.parseLong(line);
					
					
				}
				
				mapAB.put(key, teaTime)
			}
		} catch (IOException e) {
			e.printStackTrace();
		}


		for (String date_TravlerNumber : mapAB.get(date_TravlerNumber)) {
			if (mapAB.get(date_TravlerNumber) == DepartureOrArrival.Departure) {
				if (nb_bus_in_A == 0) {
					nb_bus_needed_A++;
				} else {
					nb_bus_in_A--;
				}
			} else if (mapAB.get(date_TravlerNumber) == DepartureOrArrival.Arrival) {
				nb_bus_in_A++;
			}

		}

		for (String date_TravlerNumber : mapBA.get(date_TravlerNumber)) {
			if (mapAB.get(date_TravlerNumber) == DepartureOrArrival.Departure) {
				if (nb_bus_in_A == 0) {
					nb_bus_needed_A++;
				} else {
					nb_bus_in_A--;
				}
			} else if (mapAB.get(date_TravlerNumber) == DepartureOrArrival.Arrival) {
				nb_bus_in_A++;
			}

		}

	}

}
