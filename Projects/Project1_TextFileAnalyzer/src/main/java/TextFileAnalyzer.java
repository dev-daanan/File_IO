package Projects.Project1_TextFileAnalyzer.src.main.java;

public class TextFileAnalyzer {


    // METHODS
    // preprocess text file
    public String preprocessLine(String currentLine) {
        return currentLine.toLowerCase().replaceAll("[^a-z0-9 ]", "").trim();
    }

    // word count
    public int wordCount(String currentLine) {
        int count = 0;
        for (int i = 0; i < currentLine.length(); i++) {
            if (currentLine.charAt(i) == ' ') {
                count++;
            }
        }
        count++;
        return count;
    }
    // word frequency
    // letter frequency
    // paragraph count
    // print analytics
}
