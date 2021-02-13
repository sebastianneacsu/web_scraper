import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


public class CSVWriter {

    public static String getCurrentDate(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = formatter.format(date);
        System.out.println("Date Format with dd-MM-yyyy : "+ strDate);
        return strDate;
    }


    private static final String SAMPLE_CSV_FILE = "./properties" + (int)(Math.random()*1000) + ".csv";
    private static final String PROPERTIES_CSV_FILE = "./properties_" + getCurrentDate() + "_" +(int)(Math.random()*1000) + ".csv";


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


    public static void printHouses(String[] apartmentDetails) throws IOException {
        try (
                BufferedWriter writer = Files.newBufferedWriter(
                        Paths.get(PROPERTIES_CSV_FILE),
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
