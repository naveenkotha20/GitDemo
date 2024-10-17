package com.tijori.main;
import java.util.HashMap;
import java.util.Map;

public class StringStringMapWithCounter {
    public static void main(String[] args) {
        // Create a HashMap to store pairs of strings
        Map<String, String> stringMap = new HashMap<>();
        Map<String, Integer> valueCounter = new HashMap<>();

        // Add pairs of strings to the map
        stringMap.put("TCS", "Revenue");
        
        stringMap.put("TCS", "Revenue");
        stringMap.put("TCS", "Revenue");
        stringMap.put("Key2", "Value2");
        stringMap.put("Key3", "Value1");
        stringMap.put("Key4", "Value3");
        stringMap.put("Key5", "Value2");

        // Populate the valueCounter map and print all key-value pairs
        for (Map.Entry<String, String> entry : stringMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            
            // Print key-value pair
            System.out.println("Key: " + key + ", Value: " + value);

            // Increment counter if the value already exists
            if (valueCounter.containsKey(value)) {
                int counter = valueCounter.get(value);
                valueCounter.put(value, counter + 1);
            } else {
                valueCounter.put(value, 1);
            }
        }

        // Print the counters for each unique value
        System.out.println("\nValue Counters:");
        for (Map.Entry<String, Integer> entry : valueCounter.entrySet()) {
            String value = entry.getKey();
            int counter = entry.getValue();
            System.out.println("Value: " + value + ", Count: " + counter);
        }
    }
}
