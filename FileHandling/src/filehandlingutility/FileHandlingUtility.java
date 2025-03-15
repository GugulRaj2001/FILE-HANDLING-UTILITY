package filehandlingutility;

import java.io.*;
import java.nio.file.*;

public class FileHandlingUtility {
    private static final String FILE_PATH = "CodTech_IT_Solutions.txt";

    // Method to write content to a file
    
    public static void writeToFile() {
        String content = """
                
                Welcome to CODTECH IT SOLUTIONS !
                
                🌟 Discover the Best with CodTech IT Solutions! 🌟
                
                At CodTech IT Solutions, we provide a comprehensive suite of services designed to elevate your digital experience and professional growth:
                
                ✨Web & App Design with Maintenance: Transform your online presence with our cutting-edge design and reliable maintenance services.
                
                📈 Digital Marketing & Sales: Amplify your brand's reach and drive sales with our expert digital marketing strategies.
                
                🚀 IT Training: Stay ahead of the curve with our industry-leading IT training programs, tailored to equip you with the skills you need.
                
                Choose CodTech IT Solutions for top-notch service and unparalleled expertise. Your success is our mission!
                """;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(content);
            System.out.println("==> File written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read content from a file
    public static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            System.out.println("\nReading File Content:\n--------------------------------------");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to modify a specific line in the file
    
    public static void modifyFile(String oldText, String newText) {
        try {
            Path path = Paths.get(FILE_PATH);
            String content = new String(Files.readAllBytes(path));
            content = content.replace(oldText, newText);
            Files.write(path, content.getBytes());
            System.out.println("\nFile modified successfully.");
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    	
        // Writing to file
    	
        writeToFile();

        // Reading from file
        
        readFile();

        // Modifying the file (Example: Changing "IT Training" to "Advanced IT Training")
        
        modifyFile("Welcome to CODTECH IT SOLUTIONS !", "******** Welcome to CODTECH IT SOLUTIONS ! ********");
        modifyFile("IT Training", "Advanced IT Training");

        // Reading again after modification
        
        readFile();
    }
}

