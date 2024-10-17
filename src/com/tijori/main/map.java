package com.tijori.main;

import java.util.HashMap;
import java.util.Map;

public class map {
    public static void main(String[] args) {
        // Create a HashMap to store pairs of strings
        Map<String, String> stringMap = new HashMap<>();

        // Add pairs of strings to the map
        stringMap.put("Key1", "Value1");
        stringMap.put("Key2", "Value2");
        stringMap.put("Key3", "Value3");
        stringMap.put("Key3", "Value3");
        // Print all the key-value pairs
        for (Map.Entry<String, String> entry : stringMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }
}
