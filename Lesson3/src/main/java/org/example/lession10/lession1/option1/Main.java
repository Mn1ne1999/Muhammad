package org.example.lession10.lession1.option1;

public class Main {
    public static void main(String[] args) {
        RobotController controller = new RobotController();
        new Thread(new Leg("left", controller)).start();
        new Thread(new Leg("right", controller)).start();
    }

}
