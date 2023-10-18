package Problems.Problem2_WriteFile.src.main.java;

import java.io.*;

public class WriteToFile {
    public static void main(String[] args) {
        String filePath = "/Users/daanandasilva/Java/JavaChatGPT/Folder of read and write files/EmptyFileToWriteTo2.txt";

        try (
                // Reading input from console
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                // Writing that input to file
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)))
        ) {
            System.out.println("Enter text to write to the file (type 'exit' to stop):");
            String line;
            while (true) {
                line = bufferedReader.readLine();

                if (line.equalsIgnoreCase("exit")) break;

                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            System.out.println("Data written to: " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
