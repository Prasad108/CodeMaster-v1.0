import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

	public static void main(String[] args) {
		String fileName = "C:/Users/a562113/git/CodeMaster-v1.0/Problem1/input_1.txt";

		try (Scanner scanner = new Scanner(new File(fileName))) {

			int noOfDays = Integer.parseInt(scanner.nextLine());
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				if (line == null || line.isEmpty()) {
					continue;
				}
				int teaBreakTime = Integer.parseInt(line);

				String[] busArray = scanner.nextLine().split("\\s+");
				int busStartingA = Integer.parseInt(busArray[0]);
				int busStartingB = Integer.parseInt(busArray[1]);

				TestBus testBus = new TestBus();

				for (int rowCOunter = 0; rowCOunter < busStartingA; rowCOunter++) {
					String[] scheduleA = scanner.nextLine().split("\\s+");
					int[] scheduleATiming = { Integer.parseInt(scheduleA[0].replace(":", "")),
							Integer.parseInt(scheduleA[1].replace(":", "")) };
					testBus.getCollectionsA().add(new BusPoint(scheduleATiming[0], scheduleATiming[1]));
					// System.out.println(scheduleATiming[0] + ":" +
					// scheduleATiming[1]);
				}
//				System.out.println("Completed Point A");
				for (int rowCOunter = 0; rowCOunter < busStartingB; rowCOunter++) {
					String[] scheduleB = scanner.nextLine().split("\\s+");
					int[] scheduleATiming = { Integer.parseInt(scheduleB[0].replace(":", "")),
							Integer.parseInt(scheduleB[1].replace(":", "")) };
					// System.out.println(scheduleATiming[0] + ":" +
					// scheduleATiming[1]);

					testBus.getCollectionsB().add(new BusPoint(scheduleATiming[0], scheduleATiming[1]));
				}
				System.out.println("Buses from Point A:" + testBus.aCount);
				System.out.println("Buses from Point B:" + testBus.bCount);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
