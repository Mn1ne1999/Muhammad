package org.example.lession10.lession1.option1;

public class Leg implements Runnable {
    private final String name;
    private final RobotController controller;

    public Leg(String name, RobotController controller) {
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