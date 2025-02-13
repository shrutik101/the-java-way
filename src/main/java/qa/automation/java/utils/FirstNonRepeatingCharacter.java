package qa.automation.java.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args){
        FirstNonRepeatingCharacter firstChar = new FirstNonRepeatingCharacter();
        System.out.println(firstChar.firstNonRepeatingCharacter("Mm ississauga"));

    }

    public Character firstNonRepeatingCharacter(String str){
        str = str.toLowerCase().replaceAll(" ","");
        Map<Character,Integer> charCount = new HashMap<>();
        for(int i=0; i<str.length();i++){
            if(charCount.containsKey(str.charAt(i))){
                charCount.put(str.charAt(i), charCount.get(str.charAt(i))+1);
            } else {
                charCount.put(str.charAt(i), 1);
            }
        }

        List<Character> listOfNonRepeatingChar = new ArrayList<>();
        for(Character aChar : charCount.keySet()){
            if(charCount.get(aChar) == 1){
                listOfNonRepeatingChar.add(aChar);
            }
        }

        int indexOfFirstNonRepeatingChar=str.length();
        for(Character nonRepeatingChar :listOfNonRepeatingChar){
            if(str.indexOf(nonRepeatingChar)< indexOfFirstNonRepeatingChar){
                indexOfFirstNonRepeatingChar = str.indexOf(nonRepeatingChar);
            }
        }
        return str.charAt(indexOfFirstNonRepeatingChar);
    }
}
