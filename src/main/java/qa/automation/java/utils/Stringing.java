package qa.automation.java.utils;

import java.util.*;

public class Stringing {
    public static void main(String args[]){
        //System.out.println(countOfOccurrences("I am, I am! going. to have have food food.....",'a'));
        //System.out.println(sentenceWithReversedWords("I am learning Java"));
        isKangarooWord("miss","mississauga");
    }

    // Task 1
    // Write a utility to detect if a given string is a palindrome
    public static boolean isPalindrome1(String str){
        if(str==null){
            return false;
        }
        str=str.toLowerCase();
        String reverse = "";
        Character ch;
        for(int i=0; i< str.length(); i++){
            ch = str.charAt(i);
            reverse = ch + reverse;
        }
        System.out.println(reverse);
        if(reverse.equalsIgnoreCase(str)){
            return true;
        }
        return false;
    }

//    Write a method to identify if given string is a palindrome
    public static boolean isPalindrome2(String str){
        if (str==null){
            return false;
        }
        str= str.toLowerCase();
        int left=0, right = str.length()-1;
        while(left<right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Task 2
    // Write a utility to reverse a string
    public static String reverseString(String str){
        if(str == null){
            System.out.println("Please give string input");
        }
//        str = str.toLowerCase();
        String reverse = "";
        char ch;
        for(int i=0; i<str.length();i++){
            ch = str.charAt(i);
            reverse = ch+reverse;
        }
        return reverse;
    }

    // Task 3
    // Check if String1 is kangaroo word of String2
    public static void isKangarooWord(String str1, String str2){
        if(str2.contains(str1)){
            System.out.println(str1+" is Kangaroo word of "+str2);
        }
    }
//    }

    // Task 4
    // Print the count of each words in a given paragraph
    public static Map<String,Integer> countOfWords(String str){
        str = str.replaceAll("\\.*,*!*","");
        String words[] = str.split(" ");
        Map<String,Integer> output = new HashMap<>();
        for(String word: words){
            if(!output.containsKey(word)){
                output.put(word,1);
            }
            else{
                int count = output.get(word)+1;
                output.put(word,count);
            }
        }
        return output;
    }

    //Write a Java program to count the total number of occurrences of a given character in a string without using any loop
    public static int countOfOccurrences(String str, char ch){
        str = str.toLowerCase();
        int count = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == ch){
                count +=1;
            }
        }
        return count;
    }

    //Reverse Words in a Sentence
    public static String sentenceWithReversedWords(String str){
        // I am learning Java
        List<String> words = new ArrayList<>(List.of(str.split(" ")));
        List<String> reversedWords = new ArrayList<>();
        for(String word: words){
            String reversedWord = "";
            for(int i=0; i<word.length();i++){
                reversedWord = word.charAt(i) + reversedWord;
            }
            reversedWords.add(reversedWord);
        }
        String StringOfReversedWords = String.join(" ",reversedWords);
        return StringOfReversedWords;
    }

    //Write a Java program to count the total number of occurrences of a given character in a string without using any loop

}


