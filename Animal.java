package org.example;

public abstract class Animal {
    protected final String name;
    protected final int runLimit;
    protected final int swimLimit;   // 0 → не умеет плавать

    private static int totalAnimals = 0;

    protected Animal(String name, int runLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        totalAnimals++;
    }

    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(name + " пробежал(а) " + distance + " м");
        } else {
            System.out.println(
                    name + " не смог(ла) пробежать " + distance +
                            " м (предел " + runLimit + " м)"
            );
        }
    }

    public void swim(int distance) {
        if (swimLimit == 0) {
            System.out.println(name + " не умеет плавать");
        } else if (distance <= swimLimit) {
            System.out.println(name + " проплыл(а) " + distance + " м");
        } else {
            System.out.println(
                    name + " не смог(ла) проплыть " + distance +
                            " м (предел " + swimLimit + " м)"
            );
        }
    }

    public static int getTotalAnimals() {
        return totalAnimals;
    }
}
