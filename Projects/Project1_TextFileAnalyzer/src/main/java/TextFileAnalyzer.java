package Projects.Project1_TextFileAnalyzer.src.main.java;

import java.util.HashMap;

public class TextFileAnalyzer {
    private String currentLine;
    private HashMap<String, Integer> wordFrequencyMap;
    private HashMap<Character, Integer> letterFrequencyMap;
    private int wordCount;
    private int paragraphCount;

    // CONSTRUCTORS

    public TextFileAnalyzer() {
        this.currentLine = "";
        this.wordFrequencyMap = new HashMap<>();
        this.letterFrequencyMap = new HashMap<>();
        this.wordCount = 0;
        this.paragraphCount = 0;
    }

    // PUBLIC METHODS
    /**
     * @param currentLine sets the current line.
     */
    public void takeInNextLine(String currentLine) {
        if (currentLine != null) this.currentLine = currentLine;
    }

    /**
     * Performs analytics on the currentLine
     */
    public void performAnalytics() {
        paragraphCount();
        preprocessLine();
        wordCount();
        wordFrequency();
        letterFrequency();
    }

    /**
     * Prints out the current analytics
     */
    public void printAnalytics() {
    /*
    private HashMap<String, Integer> wordFrequency;
    private HashMap<String, Integer> letterFrequency;
    private int wordCount;
    private int paragraphCount;
    */
        System.out.println("ANALYTICS");
        System.out.println("Word count:" + wordCount);
        System.out.println("Paragraph count:" + paragraphCount);
        System.out.println("Word frequency:" + wordFrequencyMap);
        System.out.println("Letter frequency:" + letterFrequencyMap);
    }


    /**
     * Resets the analytics
     */
    public void resetStatistics() {
        currentLine = "";
        wordFrequencyMap.clear();
        letterFrequencyMap.clear();
        wordCount = 0;
        paragraphCount = 0;
    }

    // PRIVATE METHODS
    /**
     *
     */
    private void preprocessLine() {
        currentLine = currentLine.toLowerCase().replaceAll("[^a-z0-9 ]", "").trim();
    }

    /**
     *
     */
    private void wordCount() {
        for (int i = 0; i < currentLine.length(); i++) {
            if (currentLine.charAt(i) == ' ') {
                wordCount++;
            }
        }
        wordCount++;
    }

    /**
     *
     */
    private void wordFrequency() {
        String[] words = currentLine.split(" ");
        for (String word : words) {
            if (wordFrequencyMap.containsKey(word)) {
                wordFrequencyMap.put(word, wordFrequencyMap.get(word) + 1);
            } else {
                wordFrequencyMap.put(word, 1);
            }
        }
    }

    /**
     *
     */
    private void letterFrequency() {
        String longString = currentLine.replaceAll(" ", "");
        for (char character : longString.toCharArray()) {
            if (letterFrequencyMap.containsKey(character)) {
                letterFrequencyMap.put(character, letterFrequencyMap.get(character) + 1);
            } else {
                letterFrequencyMap.put(character, 1);
            }
        }
    }

    /**
     * note - must be done before preprocessing
     *
     * @return number of new line characters found in pairs
     */
    private void paragraphCount() {
        paragraphCount += currentLine.split("\n\n").length;
    }


}
