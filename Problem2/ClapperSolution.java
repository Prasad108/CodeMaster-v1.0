import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClapperSolution {
    public static void main(String args[]) {
        String fileName = "input_2.txt";
        List<String> inputInList = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            inputInList = stream.collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintStream out = null;
        PrintStream stdout = System.out;
        try {
            out = new PrintStream(new FileOutputStream("output_2.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(out);

        final ListIterator<String> row = inputInList.listIterator();

        final int testCases = Integer.parseInt(row.next());

        for (int counter = 0; counter < testCases; counter++) {

            String status = "OFF";

            final String[] data = row.next().split(" ");

            final int clapperCount = Integer.parseInt(data[0]);
            int clapCount = Integer.parseInt(data[1]) + 1;

            double onCase = Math.pow(2, clapperCount);
            if (clapCount == onCase || (clapCount > onCase && clapCount % onCase == 0)) {
                status = "ON";
            }

            System.out.println("Experiment-" + (counter + 1) + ": " + status);
        }

        out.close();
        System.setOut(stdout);
    }
}
