package org.example.lession10.lession1.option2;

public class Main {
    public static void main(String[] args) {
        RobotLockController controller = new RobotLockController();
        new Thread(new Leg("left", controller)).start();
        new Thread(new Leg("right", controller)).start();
    }
}
