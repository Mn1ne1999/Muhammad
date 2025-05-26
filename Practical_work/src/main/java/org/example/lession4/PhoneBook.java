package org.example.lession4;

import java.util.*;

class PhoneBook {
    private Map<String, List<String>> book = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        book.computeIfAbsent(surname, k -> new ArrayList<>()).add(phoneNumber);
    }

    public List<String> get(String surname) {
        return book.getOrDefault(surname, Collections.emptyList());
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "12345");
        phoneBook.add("Петров", "67890");
        phoneBook.add("Иванов", "54321");

        System.out.println("Телефоны Иванова: " + phoneBook.get("Иванов"));
        System.out.println("Телефоны Петрова: " + phoneBook.get("Петров"));
        System.out.println("Телефоны Сидорова: " + phoneBook.get("Сидоров")); // пустой список
    }
}
