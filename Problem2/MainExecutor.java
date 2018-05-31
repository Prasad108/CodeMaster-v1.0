import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainExecutor {

	public static void main(String[] args) throws IOException {

		String inputFile = args[0];
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
				BufferedWriter writer = new BufferedWriter(new FileWriter("output_2.txt"))) {
			StringBuffer outputBuffer = new StringBuffer();
			String line;
			int count = 1;
			bufferedReader.readLine();
			while ((line = bufferedReader.readLine()) != null) {

				String[] ins = line.split(" ");

				if (isOn(Integer.parseInt(ins[0]), Integer.parseInt(ins[1]))) {
					outputBuffer.append("Experiment-" + count++ + ": ON");

				} else {
					outputBuffer.append("Experiment-" + count++ + ": OFF");
				}
				outputBuffer.append("\n");

			}
			writer.write(outputBuffer.toString());
		}
	}

	private static boolean isOn(int numberOfclapper, int noOfClaps) {

		StringBuffer binaryBuffer = new StringBuffer();
		for (int i = 0; i < numberOfclapper; i++) {
			binaryBuffer.append("1");
		}

		int clapsToFirstOn = Integer.parseInt(binaryBuffer.toString(), 2) + 1;

		if ((noOfClaps + 1) % clapsToFirstOn == 0) {
			return true;
		}
		return false;
	}

}
