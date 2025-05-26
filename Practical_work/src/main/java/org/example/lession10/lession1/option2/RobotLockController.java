package org.example.lession10.lession1.option2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class RobotLockController {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private boolean leftTurn = true;

    public void step(String leg) {
        lock.lock();
        try {
            while ((leg.equals("left") && !leftTurn) || (leg.equals("right") && leftTurn)) {
                condition.await();
            }
            System.out.println(leg);
            leftTurn = !leftTurn;
            condition.signalAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}
