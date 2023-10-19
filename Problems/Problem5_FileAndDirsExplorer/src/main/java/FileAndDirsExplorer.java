package Problems.Problem5_FileAndDirsExplorer.src.main.java;

import java.io.File;

public class FileAndDirsExplorer {

    public static void main(String[] args) {
        String directoryPath = "/Users/";  // Replace with your directory path
        File directory = new File(directoryPath);

        listFilesAndDirs(directory);
    }





    public static void listFilesAndDirs(File directory) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getAbsolutePath());
                    } else if(file.isDirectory()) {
                        listFilesAndDirs(file);
                    }
                }
            }
        }
    }
}
