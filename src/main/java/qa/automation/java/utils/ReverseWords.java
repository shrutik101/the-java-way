package qa.automation.java.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseWords {

    public static void main(String[] args){
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWordsInSentence("Hi Shruti, how are you doing?"));
    }


    public String reverseWordsInSentence(String sentence) {
        if (sentence != null) {
            String[] words = sentence.split(" ");
            List<String> wordsList = Arrays.asList(words);
            List<String> reversedWordsList = new ArrayList<>();
            String onlyWord;
            for (int i = wordsList.size()-1; i >= 0; i--) {
                onlyWord = wordsList.get(i);
                reversedWordsList.add(onlyWord);
            }
            return String.join(" ", reversedWordsList);
        }
        return null;
    }
}
