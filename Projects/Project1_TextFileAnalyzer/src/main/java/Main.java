package Projects.Project1_TextFileAnalyzer.src.main.java;

public class Main {
    public static void main(String[] args) {
        String testString = """
                one# two,,, three three four five si---x      
                one five, four three""";

        TextFileAnalyzer textFileAnalyzer = new TextFileAnalyzer();

        textFileAnalyzer.takeInNextLine(testString);
        textFileAnalyzer.performAnalytics();
        textFileAnalyzer.printAnalytics();
        textFileAnalyzer.resetStatistics();
    }
}
