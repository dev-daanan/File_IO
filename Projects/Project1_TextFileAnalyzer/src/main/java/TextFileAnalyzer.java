package Projects.Project1_TextFileAnalyzer.src.main.java;

import java.util.HashMap;

public class TextFileAnalyzer {

    // PUBLIC METHODS

    /**
     * @param text sets the current line.
     */
    private void validateInputText(String text) {
        if (text == null) {
            throw new NullPointerException("Invalid Input Text!");
        }
    }

    /**
     * Performs analytics on the inputText
     * @return TextAnalysisResult
     */
    public TextAnalysisResult analyzeText(String inputText) {
        // Validate input
        validateInputText(inputText);
        // Preprocess string
        String processedText = preprocessText(inputText);
        // Perform Analytics
        int paragraphCount = paragraphCount(processedText);
        int wordCount = wordCount(processedText);
        HashMap<String, Integer> wordFrequency = wordFrequency(processedText);
        HashMap<Character, Integer> letterFrequency = letterFrequency(processedText);
        return new TextAnalysisResult(paragraphCount, wordCount, wordFrequency, letterFrequency);
    }


    // PRIVATE METHODS

    /**
     * @return preprocessed line
     */
    private String preprocessText(String inputText) {
        inputText = inputText.toLowerCase()
                .replaceAll("[^a-z0-9 \\n]", "") // Remove any character not a-z, 0-9, space, or newline
                .replaceAll("[ ]{2,}", " ")      // Replace two or more whitespace-characters with a single space
                .replaceAll("\\n{2,}", " \n\n")  // Insert a space before and after two newline characters
                .trim();
        return inputText;
    }

    /**
     * @return word count
     */
    private int wordCount(String inputText) {
        return inputText.split(" ").length;
    }

    /**
     * @return word frequency hashmap, keys being the words, and values being the frequencies of those words
     */
    private HashMap<String, Integer> wordFrequency(String inputText) {
        // preprocess more - removes newlines
        String modifiedInputText = inputText.replaceAll("[\n]", "");

        HashMap<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : modifiedInputText.split(" ")) {
            if (wordFrequencyMap.containsKey(word)) {
                wordFrequencyMap.put(word, wordFrequencyMap.get(word) + 1);
            } else {
                wordFrequencyMap.put(word, 1);
            }
        }
        return wordFrequencyMap;
    }

    /**
     * @return word frequency hashmap, keys being the letters, and values being the frequencies of those letters
     */
    private HashMap<Character, Integer> letterFrequency(String inputText) {
        // preprocess more - removes spaces and newlines
        String longString = inputText.replaceAll("[\\s\n]", "");

        HashMap<Character, Integer> letterFrequencyMap = new HashMap<>();
        for (char character : longString.toCharArray()) {
            if (letterFrequencyMap.containsKey(character)) {
                letterFrequencyMap.put(character, letterFrequencyMap.get(character) + 1);
            } else {
                letterFrequencyMap.put(character, 1);
            }
        }
        return letterFrequencyMap;
    }

    /**
     * @return number of new line characters found in pairs
     */
    private int paragraphCount(String inputText) {
        return inputText.split("\n\n").length;
    }
}
