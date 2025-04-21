package org.example;

public class Hamster extends Animal {
    private static int hamsterCount = 0;

    public Hamster(String name) {
        super(name, 100, 0);
        hamsterCount++;
    }

    public static int getHamsterCount() {
        return hamsterCount;
    }
}
