package Problems.Problem3_ManipulateFile.src.main.java;

import java.io.*;

public class CopyFileToAnother {
    public static void main(String[] args) {
        String sourceFilePathForReader = "/Users/daanandasilva/Java/JavaChatGPT/Folder of read and write files/FunnyZeldaStory.txt";
        String destinationFilePathForWriter = "/Users/daanandasilva/Java/JavaChatGPT/Folder of read and write files/RandomFileToWriteTo.txt";

        try (
                // Reader
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFilePathForReader)));
                // Writer
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destinationFilePathForWriter, true)))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                        writer.write(line);
                        writer.newLine();
            }
            System.out.println("Data appended to file: " + destinationFilePathForWriter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
