package org.example;

public class Main {
    public static void main(String[] args) {

        Animal[] zoo = {
                new Cat("Мурка"),
                new Dog("Бобик"),
                new Tiger("Шерхан"),
                new Hamster("Хома"),
                new Cat("Барсик"),
                new Dog("Рекс")
        };

        int runDist  = 50;
        int swimDist = 8;

        System.out.printf("Испытание: бег " + runDist + " м и плавание " + swimDist + " м \n");

        for (Animal a : zoo) {
            a.run(runDist);
            a.swim(swimDist);
            System.out.println();
        }

        System.out.println("Создано животных: "     + Animal.getTotalAnimals());
        System.out.println("Котов: "                + Cat.getCatCount());
        System.out.println("Собак: "                + Dog.getDogCount());
        System.out.println("Тигров: "               + Tiger.getTigerCount());
        System.out.println("Хомяков: "              + Hamster.getHamsterCount());
    }
}
