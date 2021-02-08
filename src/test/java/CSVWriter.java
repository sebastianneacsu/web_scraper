import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;


public class CSVWriter {
    private static final String SAMPLE_CSV_FILE = "./sample.csv";
    private static final String HOUSES_CSV_FILE = "./houses.csv";

    public static void main(String[] args) throws IOException {
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));

                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("ID", "Name", "Designation", "Company"));
        ) {
            csvPrinter.printRecord("1", "Sundar Pichai ♥", "CEO", "Google");
            csvPrinter.printRecord("2", "Satya Nadella", "CEO", "Microsoft");
            csvPrinter.printRecord("3", "Tim Cook", "CEO", "Apple");

            csvPrinter.printRecord(Arrays.asList("4", "Mark Zuckerberg", "CEO", "Facebook"));

            csvPrinter.flush();
        }
    }


    public static void printApartments(String[] apartmentDetails) throws IOException {
        try (

                BufferedWriter writer = Files.newBufferedWriter(
                        Paths.get(SAMPLE_CSV_FILE),
                        StandardOpenOption.APPEND,
                        StandardOpenOption.CREATE);

                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
        ) {
            csvPrinter.printRecord(Arrays.asList(apartmentDetails));
           // csvPrinter.printRecord(Arrays.asList("4", "Mark Zuckerberg", "CEO", "Facebook"));

            csvPrinter.flush();
        }
    }

    public static void printHouses(String[] apartmentDetails) throws IOException {
        try (

                BufferedWriter writer = Files.newBufferedWriter(
                        Paths.get(HOUSES_CSV_FILE),
                        StandardOpenOption.APPEND,
                        StandardOpenOption.CREATE);

                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
        ) {
            csvPrinter.printRecord(Arrays.asList(apartmentDetails));
            // csvPrinter.printRecord(Arrays.asList("4", "Mark Zuckerberg", "CEO", "Facebook"));

            csvPrinter.flush();
        }
    }
}
