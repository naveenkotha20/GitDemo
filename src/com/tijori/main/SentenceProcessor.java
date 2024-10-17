package com.tijori.main;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SentenceProcessor {
    public void getkeywords (String ss) throws FileNotFoundException {
        String inputSentences = ss;
        Map<String, Integer> wordFrequency = countWordFrequency(inputSentences);
        printWordFrequency(wordFrequency);
    }

    private static Map<String, Integer> countWordFrequency(String inputSentences) {
        String[] words = inputSentences.split("\\W+");
        
        ArrayList<String> allwords = new ArrayList<>();
       
        for (int i=0;i<words.length-1;i++)
        {
    String s=words[i]+" "+words[i+1];

        
        //	allwords.add(s);
        allwords.add( words[i]); 
        }
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (int i = 0; i < allwords.size();i++) 
	      { 
        	
	         // System.out.println(allwords.get(i)); 	
	          
	            String lowercaseWord = allwords.get(i).toLowerCase();
	           wordFrequency.put(lowercaseWord, wordFrequency.getOrDefault(lowercaseWord, 0) + 1);
	      }   
       
     //   Map<String, Integer> wordFrequency = new HashMap<>();

        
        
        for (String word : words) {
        //    String lowercaseWord = word.toLowerCase();
           // wordFrequency.put(lowercaseWord, wordFrequency.getOrDefault(lowercaseWord, 0) + 1);
        }

        return sortByValueDescending(wordFrequency);
    }

    private static Map<String, Integer> sortByValueDescending(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());

        // Custom comparator to sort by value in descending order
        Collections.sort(list, (a, b) -> b.getValue().compareTo(a.getValue()));

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    private static void printWordFrequency(Map<String, Integer> wordFrequency) throws FileNotFoundException {
        PrintStream myconsole= new PrintStream(("C:\\Users\\Owner\\Desktop\\test.log"));

        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            String word = entry.getKey();
            int frequency = entry.getValue();
            System.out.println(word + ": " + frequency);
            myconsole.println(word + ": " + frequency);

          ExcelSearch obj=new ExcelSearch();

            obj.getsector(word,myconsole);
        }
    }
}