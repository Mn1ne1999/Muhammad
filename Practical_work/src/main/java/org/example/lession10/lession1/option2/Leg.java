package org.example.lession10.lession1.option2;

public class Leg implements Runnable {
    private final String name;
    private final RobotLockController controller;

    public Leg(String name, RobotLockController controller) {
        this.name = name;
        this.controller = controller;
    }

    @Override
    public void run() {
        while (true) {
            controller.step(name);
        }
    }
}
