import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOEx {
    public static void writeFile(String fileName, String content) {
        // Using try-with-resources to ensure the writer is closed automatically
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Writing content to the file
            writer.write(content);
            System.out.println("Content written to file successfully.");
        } catch (IOException e) {
            // Handling any IO exceptions that may occur
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    public static void main(String[] args) {                
        String fileName = "C:/Users/medis/OneDrive/Desktop/mthree/test/java_codes/example.txt";
        String content = "Hello, this is a test content.";


        writeFile(fileName, content);
    }
}

   
