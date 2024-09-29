import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileReadEx {

    public static void main(String[] args) {
        String fileName = "C:/Users/medis/OneDrive/Desktop/mthree/test/java_codes/example.txt"; // Specify the file name

        // Reading from the file using different methods
        System.out.println("Reading from file using BufferedReader:");
        readWithBufferedReader(fileName);

        System.out.println("\nReading from file using FileInputStream:");
        readWithFileInputStream(fileName);

        System.out.println("\nReading from file using Scanner:");
        readWithScanner(fileName);

        System.out.println("\nReading from file using Files.readAllLines:");
        readWithFilesReadAllLines(fileName);

        System.out.println("\nReading from file using Files.lines with Stream API:");
        readWithFilesLines(fileName);
    }

    // Method 1: Using BufferedReader
    public static void readWithBufferedReader(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Print each line
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Method 2: Using FileInputStream
    public static void readWithFileInputStream(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName)) {
            int content;
            while ((content = fis.read()) != -1) {
                System.out.print((char) content); // Convert byte to char and print
            }
            System.out.println(); // New line after reading
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Method 3: Using Scanner
    public static void readWithScanner(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine()); // Print each line
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    // Method 4: Using Files.readAllLines
    public static void readWithFilesReadAllLines(String fileName) {
        try {
            Files.readAllLines(Paths.get(fileName)).forEach(System.out::println); // Print all lines
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Method 5: Using Files.lines with Stream API
    public static void readWithFilesLines(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(System.out::println); // Print each line from the stream
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
