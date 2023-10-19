package Projects.Project1_TextFileAnalyzer.src.main.java;

public class Main {
    public static void main(String[] args) {
        String testString = "one# two,,, three four five si---x";
        TextFileAnalyzer textFileAnalyzer = new TextFileAnalyzer();
        System.out.println(testString = textFileAnalyzer.preprocessLine(testString));
        System.out.println(textFileAnalyzer.wordCount(testString));
    }
}
