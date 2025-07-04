package qa.automation.java.utils;

import java.util.*;

public class Collections {
    public static void main(String[] arg){
        //firstUniqueCharacter("Mississauga");
        //System.out.println(frequencyOfEachWord("There are five tens and five nines and five eights"));
        //Integer[] num = {1,2,3,4,5,2,4,3,1,5,6};
        //printDuplicateElements(num);
//        sortTheHashMapAplhabetically();
    }

    //Write a Java program that takes a string as input and counts the frequency of each character using a HashMap. Print the result.
    public static void frequencyOfEachChar(String inputString) {

        //Creating a HashMap containing Character as a key and occurrences as  a value
        HashMap<Character,Integer> charCountMap = new HashMap<>();

        // Converting given string to char array
        char[] inputStringArray = inputString.toCharArray();

        //Checking each char of inputStringArray
        for(char c: inputStringArray){
            if(charCountMap.containsKey(c)){
                charCountMap.put(c,charCountMap.get(c)+1);
            }
            else{
                charCountMap.put(c,1);
            }
        }
        System.out.println(charCountMap);
    }

    //Write a Java program to find the first non-repeating character in a given string using a HashMap.
    public static void firstUniqueCharacter(String inputString){
        //Creating a HashMap containing Character as a key and occurrences as  a value
        Map<Character,Integer> charCountMap = new LinkedHashMap<>();

        // Converting given string to char array
        char[] inputStringArray = inputString.toCharArray();

        //Checking each char of inputStringArray
        for(char c: inputStringArray){
            if(charCountMap.containsKey(c)){
                charCountMap.put(c,charCountMap.get(c)+1);
            }
            else{
                charCountMap.put(c,1);
            }
        }
        for(Character c: charCountMap.keySet()){
            if(charCountMap.get(c)==1){
                System.out.println("The first non-repeating character is: "+c);
                break;
            }
        }
    }

    //Write a Java program that takes a sentence and calculates the frequency of each word using a HashMap.
    // Ignore case sensitivity and punctuation.
    public static Map<String, Integer> frequencyOfEachWord(String inputString){
        List<String> listOfWords = new ArrayList<>(List.of(inputString.split(" ")));
        Map<String,Integer> mapOfWords = new HashMap<>();
        for(String word : listOfWords){
            if(mapOfWords.containsKey(word)){
                mapOfWords.put(word,mapOfWords.get(word)+1);
            }else{
                mapOfWords.put(word,1);
            }
        }
        return mapOfWords;
    }

    //Write a Java program that finds and prints duplicate elements from an integer array using a HashMap.
    public static void printDuplicateElements(Integer[] inputIntegerArray){
        Map<Integer,Integer> integerMap = new HashMap<>();
        for(Integer i : inputIntegerArray){
            if(integerMap.containsKey(i)){
                integerMap.put(i,integerMap.get(i)+1);
            }else{
                integerMap.put(i,1);
            }
        }
        for(Integer k : integerMap.keySet()){
            if(integerMap.get(k)>1){
                System.out.println(k);
            }
        }
    }

    // Method to create a HashMap<Integer, String> form a string input
    public static Map<Integer,String> createMap(String str){
        return null;
    }

    //Write a Java program that sorts a HashMap<Integer, String> by its values (names in alphabetical order).
    public static void sortTheHashMapAplhabetically(Map<Integer,String> strMap){
        List<String> strArrayList = new ArrayList<>();
        for(Integer key : strMap.keySet()){
            strArrayList.add(strMap.get(key));
        }
        strArrayList.sort(String::compareToIgnoreCase);
    }

}




