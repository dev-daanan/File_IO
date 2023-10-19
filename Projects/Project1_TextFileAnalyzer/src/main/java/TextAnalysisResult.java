package Projects.Project1_TextFileAnalyzer.src.main.java;

import java.util.HashMap;

public class TextAnalysisResult {
    private int paragraphCount;
    private int wordCount;
    private HashMap<String, Integer> wordFrequency;
    private HashMap<Character, Integer> letterFrequency;

    public TextAnalysisResult(int paragraphCount, int wordCount, HashMap<String, Integer> wordFrequency, HashMap<Character, Integer> letterFrequency) {
        this.paragraphCount = paragraphCount;
        this.wordCount = wordCount;
        this.wordFrequency = wordFrequency;
        this.letterFrequency = letterFrequency;
    }
    public void printAnalytics() {
        System.out.println("ANALYTICS");
        System.out.println("Word count:" + wordCount);
        System.out.println("Paragraph count:" + paragraphCount);
        System.out.println("Word frequency:" + wordFrequency);
        System.out.println("Letter frequency:" + letterFrequency);
    }
    public void printAnalytics(TextAnalysisResult result) {
        System.out.println("ANALYTICS");
        System.out.println("Word count:" + result.getWordCount());
        System.out.println("Paragraph count:" + result.getParagraphCount());
        System.out.println("Word frequency:" + result.getWordFrequency());
        System.out.println("Letter frequency:" + result.getLetterFrequency());
    }

    /**
     * merges data from "other" into the this TextAnalysisResult object
     * @param other - TextAnalysisResult object with data to be added to this object
     */
    public void merge(TextAnalysisResult other) {
        if (other == null) return;

        this.wordCount += other.wordCount;
        this.paragraphCount += other.paragraphCount;
        other.wordFrequency.forEach((k, v) -> this.wordFrequency.merge(k, v, Integer::sum));
        other.letterFrequency.forEach((k, v) -> this.letterFrequency.merge(k, v, Integer::sum));
    }

    public int getParagraphCount() {
        return paragraphCount;
    }
    public int getWordCount() {
        return wordCount;
    }
    public HashMap<String, Integer> getWordFrequency() {
        return wordFrequency;
    }
    public HashMap<Character, Integer> getLetterFrequency() {
        return letterFrequency;
    }
}
