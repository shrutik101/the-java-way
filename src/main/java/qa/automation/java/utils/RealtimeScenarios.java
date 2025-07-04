package qa.automation.java.utils;

import java.util.*;

public class RealtimeScenarios {

    public static void main(String[] args){
        exercise1();
        exercise2();
        exercise3();
        exercise4();
        exercise5();
        exercise6();
    }

    private static void exercise5() {
//    5. Duplicate Words Counter
//    Scenario:
//    Write a method to accept a paragraph and count the number of times each word appears (ignoring case and punctuation).
//    Use Map<String, Integer> to return word counts.
        System.out.println(duplicatedWordCounter("I like like to learn and learn java programming programming is good"));
    }

    private static void exercise4() {
//    4. User Role Aggregation
//    Scenario:
//    Input is a list of users and their roles:
//    List<String> data = Arrays.asList("Alice:Admin", "Bob:User", "Alice:User", "Charlie:Guest");
//    Return a Map<String, Set<String>> representing each user and their associated unique roles.
        List<String> data = Arrays.asList("Alice:Admin", "Bob:User", "Alice:User", "Charlie:Guest");
        System.out.println(userRoleAggregation(data));
    }

    private static void exercise3() {
//    3. Find First Non-Repeating Character in a String
//    Scenario:
//    Given a string "aabbccdeeffg", return the first character that does not repeat.
//    Use a LinkedHashMap to preserve order of insertion.
        getFirstNonRepeatingCharacter("aabbccdeeffg");
    }

    private static void exercise2() {
//    2. Grouping Anagrams
//    Scenario:
//    You are given a list of strings: ["listen", "silent", "silent", "google", "gooleg", "cat"].
//    Group the anagrams together and store them in a Map<String, List<String>> where the key is the sorted version of the word.
        List<String> listOfWords = new ArrayList<>();
        listOfWords.add("listen");
        listOfWords.add("silent");
        listOfWords.add("silent");
        listOfWords.add("google");
        listOfWords.add("gooleg");
        listOfWords.add("cat");
        System.out.println(groupAnagrams(listOfWords));
    }

    private static void exercise1() {
//  1.Frequency Counter with Multiple Constraints
//    Scenario:
//    Given a list of log entries as strings (e.g., "INFO-LoginSuccess", "ERROR-DBDown", "INFO-Logout", etc.), write a program to:
//    Count the number of entries for each log level (INFO, ERROR, etc.)
//    Store results in a Map<String, Integer>
//    Ignore malformed entries.
        List<String> listOfLogEntries = new ArrayList<>();
        addLogEntriesToList("INFO-LoginSuccess",listOfLogEntries);
        addLogEntriesToList("ERROR-DBDown",listOfLogEntries);
        addLogEntriesToList("WARNING",listOfLogEntries);
        System.out.println(countOfEntries(listOfLogEntries));
    }

    private static void exercise6() {
//    6. Merge Two Maps with List Values
//    Scenario:
//    Given two Map<String, List<String>>, merge them into a single map.
//    If a key exists in both maps, merge their lists (avoid duplicates in merged lists).
        Map<String, List<String>> map1 = new HashMap<>();
        Map<String, List<String>> map2 = new HashMap<>();
        map1.put("tshirt",Arrays.asList("Banana Republic","Uniqlo","Peter England"));
        map1.put("membership",Arrays.asList("Costco","wholefoods","Sabjimandi"));
        map1.put("Winterjackets", Arrays.asList("Northface","Columbia","EddieBauer"));
        map2.put("dress",Arrays.asList("Banana Republic","Uniqlo","Peter England"));
        map2.put("membership",Arrays.asList("Costco","wholefoods","Oceans"));
        map2.put("Winterjackets", Arrays.asList("Northface","Columbia","EddieBauer"));
        merge2Maps(map1,map2);
    }

    private static void exercise7(){
//    7. Sort Map by Value
//    Scenario:
//    Given a Map<String, Integer> representing items and their sales count, return the map sorted by value descending (most sold item first).

    }

    private static void exercise8(){
//    8. Longest Substring Without Repeating Characters
//    Scenario:
//    Given a string, find the length of the longest substring without repeating characters.
//    Use a Set<Character> and sliding window logic.
    }

    private static void exercise9(){
//    9. Detect Cyclic Dependency in Tasks
//    Scenario:
//    Input is a list of task dependencies:
//    List<String> dependencies = Arrays.asList("A->B", "B->C", "C->A");
//    Write logic to detect if there is a cyclic dependency using a Map<String, List<String>> (graph representation).
    }

    private static void exercise10(){
//    10. Top K Frequent Words
//    Scenario:
//    Given a list of words, find the top K most frequent.
//    Use Map<String, Integer> for frequency and PriorityQueue (min heap) for tracking top K
    }

    public static void addLogEntriesToList(String logEntry, List<String> listOfLogEntries){
        listOfLogEntries.add(logEntry);
    }

    public static Map<String, Integer> countOfEntries(List<String> listOfLogEntries){
        int countInfo = 0;
        int countError = 0;
        int countWarning = 0;
        for(String logEntry: listOfLogEntries){
            if(logEntry.contains("INFO")){
                countInfo= countInfo+1;
            }else if(logEntry.contains("ERROR")){
                countError = countError+1;
            }else if(logEntry.contains("WARNING")){
                countWarning = countWarning+1;
            }
        }
        Map<String,Integer> mapOfLogEntriesCount = new LinkedHashMap<>();
        mapOfLogEntriesCount.put("INFO",countInfo);
        mapOfLogEntriesCount.put("ERROR",countError);
        mapOfLogEntriesCount.put("WARNING",countWarning);
        return mapOfLogEntriesCount;
    }

    public static boolean isAnagram(String string1, String string2){
        char[] charArray1 = string1.toCharArray();
        Arrays.sort(charArray1);
        string1 = new String(charArray1);
        char[] charArray2 = string2.toCharArray();
        Arrays.sort(charArray2);
        string2 = new String(charArray2);
        return string1.equalsIgnoreCase(string2);
    }

    public static Map<String, List<String>> groupAnagrams(List<String> listOfWords){
        Map<String, List<String>> mapOfAnagrams = new LinkedHashMap<>();
        for(String word : listOfWords){
            char[] wordCharArray = word.toCharArray();
            Arrays.sort(wordCharArray);
            String sortedWord = new String(wordCharArray);
            if(!mapOfAnagrams.containsKey(sortedWord)){
                List<String> listOfAnagrams = new ArrayList<>();
                listOfAnagrams.add(word);
                mapOfAnagrams.put(sortedWord,listOfAnagrams);
            }else{
                mapOfAnagrams.get(sortedWord).add(word);
            }
        }
        return mapOfAnagrams;
    }

    public static void getFirstNonRepeatingCharacter(String inputString){
        Map<Character, Integer> mapOfCharacters = new LinkedHashMap<>();
        char[] characterArray = inputString.toCharArray();
        for(Character c: characterArray){
            if(!mapOfCharacters.containsKey(c)){
                mapOfCharacters.put(c,1);
            }else{
                mapOfCharacters.put(c,mapOfCharacters.get(c)+1);
            }
        }
        for(Character k: mapOfCharacters.keySet()){
            if(mapOfCharacters.get(k)==1){
                System.out.println("The first non-repeating character: "+k);
                break;
            }
        }
    }

    public static Map<String,Set<String>> userRoleAggregation(List<String> listOfUsersAndRoles){
        Map<String,Set<String>> mapOfUserAndRole = new LinkedHashMap<>();
        for(String s: listOfUsersAndRoles){
            String[] usernameRoleArray= s.split(":");
            String username = usernameRoleArray[0];
            String role = usernameRoleArray[1];
            if(!mapOfUserAndRole.containsKey(username)){
                Set<String> setOfRoles = new HashSet<>();
                setOfRoles.add(role);
                mapOfUserAndRole.put(username,setOfRoles);
            }else{
                mapOfUserAndRole.get(username).add(role);
            }
        }
        return mapOfUserAndRole;
    }

    public static Map<String, Integer> duplicatedWordCounter(String inputString){
        Map<String, Integer> wordCountMap = new LinkedHashMap<>();
        String[] words = inputString.split(" ");
        for(String w: words){
            w= w.toLowerCase();
            if(!wordCountMap.containsKey(w)){
                wordCountMap.put(w,1);
            }else{
                wordCountMap.put(w,wordCountMap.get(w)+1);
            }
        }
        return wordCountMap;
    }

    public static void merge2Maps(Map<String, List<String>> map1, Map<String, List<String>> map2){
//    6. Merge Two Maps with List Values
//    Scenario:
//    Given two Map<String, List<String>>, merge them into a single map.
//    If a key exists in both maps, merge their lists (avoid duplicates in merged lists).
        for(String map1Key : map1.keySet()){
            if(!map2.containsKey(map1Key)){
                map2.put(map1Key,map1.get(map1Key));
            }else {
                List<String> listMap1 = new ArrayList<>(map1.get(map1Key));
                List<String> listMap2 = new ArrayList<>(map2.get(map1Key));
                for(String listElementMap1 : listMap1){
                    if(!listMap2.contains(listElementMap1)){
                        listMap2.add(listElementMap1);
                    }
                }
                map2.put(map1Key,listMap2);
            }
        }
        System.out.println(map2);
    }

}
