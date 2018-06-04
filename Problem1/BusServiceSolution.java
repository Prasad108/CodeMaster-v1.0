import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BusServiceSolution {

    public static void main(String args[]) {

        String fileName = "input_1.txt";
        List<String> inputInList = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            inputInList = stream.collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintStream out = null;
        PrintStream stdout = System.out;
        try {
            out = new PrintStream(new FileOutputStream("output_1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(out);

        final ListIterator<String> row = inputInList.listIterator();

        final int testCases = Integer.parseInt(row.next());

        for (int testCaseCount = 0; testCaseCount < testCases; testCaseCount++) {

            final int breakTime = Integer.parseInt(row.next());

            final String[] schedule = row.next().split(" ");

            final int airoliSchedule = Integer.parseInt(schedule[0]);
            final int borivaliSchedule = Integer.parseInt(schedule[1]);

            List<Date> airoliDeparture = new ArrayList<>();
            List<Date> borivaliArrival = new ArrayList<>();
            List<Date> borivaliDeparture = new ArrayList<>();
            List<Date> airoliArrival = new ArrayList<>();

            parseTimeTable(row, airoliSchedule, airoliDeparture, borivaliArrival);
            parseTimeTable(row, borivaliSchedule, borivaliDeparture, airoliArrival);

            Collections.sort(airoliDeparture);
            Collections.sort(borivaliArrival);
            Collections.sort(borivaliDeparture);
            Collections.sort(airoliArrival);

            int airoliDepartureCount = getBusCount(breakTime, airoliSchedule, airoliDeparture, airoliArrival);
            int borivaliDepartureCount = getBusCount(breakTime, borivaliSchedule, borivaliDeparture, borivaliArrival);

            System.out.println("Day-" + (testCaseCount + 1) + ": " + airoliDepartureCount + " " + borivaliDepartureCount);
        }

        out.close();
        System.setOut(stdout);
    }

    private static int getBusCount(int breakTime, int route, List<Date> departure, List<Date> arrival) {
        int busCount = 0;
        for (int i = 0; i < route; i++) {
            busCount++;
            for (int j = 0; j < arrival.size(); j++) {
                if (departure.get(i).getTime() >= arrival.get(j).getTime() + breakTime * 60000) {
                    busCount--;
                    arrival.remove(j);
                    break;
                }
            }
        }
        return busCount;
    }

    private static void parseTimeTable(ListIterator<String> row, int route, List<Date> departure, List<Date> arrival) {
        for (int routeCount = 0; routeCount < route; routeCount++) {
            final String[] time = row.next().split(" ");

            DateFormat format = new SimpleDateFormat("HH:mm");
            try {
                departure.add(format.parse(time[0]));
                arrival.add(format.parse(time[1]));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
