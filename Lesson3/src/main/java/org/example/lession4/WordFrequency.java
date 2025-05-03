package org.example.lession4;

import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        String[] words = {"дом", "кот", "собака", "кот", "дом", "птица", "дом", "рыба", "собака", "кот"};

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Уникальные слова: " + wordCount.keySet());

        System.out.println("\nЧастота встречаемости слов:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}