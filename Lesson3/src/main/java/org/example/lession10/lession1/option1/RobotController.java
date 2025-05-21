package org.example.lession10.lession1.option1;

class RobotController {
    private boolean leftTurn = true;

    public synchronized void step(String leg) {
        try {
            while ((leg.equals("left") && !leftTurn) || (leg.equals("right") && leftTurn)) {
                wait();
            }
            System.out.println(leg);
            leftTurn = !leftTurn;
            notifyAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

