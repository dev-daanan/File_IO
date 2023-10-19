package Projects.Project1_TextFileAnalyzer.src.main.java;

public class Main {
    public static void main(String[] args) {
        String testString = """
                one two three
                                
                four five six six
                                
                eight nine ten.
                """;
        TextFileAnalyzer analyzer = new TextFileAnalyzer();

        TextAnalysisResult text = analyzer.analyzeText(testString);
        text.printAnalytics();

    }
}
