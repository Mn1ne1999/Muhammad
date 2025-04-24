package org.example.springExample;

public class Robot implements Participant {

    private final String name;
    private final int maxRun;
    private final int maxJump;

    public Robot(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }


    @Override
    public boolean run(int distance) {
        if (distance <= maxRun) {
            System.out.println(name + " успешно пробежал " + distance + " м.");
            return true;
        } else {
            System.out.println(name + " не смог пробежать " + distance + " м.");
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if (height <= maxJump) {
            System.out.println(name + " успешно прыгнул на " + height + " м.");
            return true;
        } else {
            System.out.println(name + " не смог прыгнуть на " + height + " м.");
            return false;
        }    }
}
