package Problems.Problem1_ReadFile.src.main.java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class DisplayFile {
    public static void main(String[] args) {
        String filePath = "/Users/daanandasilva/Downloads/Basic-Input-&-Output-including-java" +
                ".util-Load-Big-Location-and-Exits-Files-Source-code/directions.txt";

        try (
                FileInputStream fileInputStream = new FileInputStream(filePath);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        ) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("READING IS DONE");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
