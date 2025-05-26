package org.example.lession10.lession2;

public class SafeAccountThread implements Runnable {
    private final Account from;
    private final Account to;
    private final int amount;

    public SafeAccountThread(Account from, Account to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4000; i++) {
            Account first = from.hashCode() < to.hashCode() ? from : to;
            Account second = from.hashCode() < to.hashCode() ? to : from;

            synchronized (first) {
                synchronized (second) {
                    if (from.takeOffMoney(amount)) {
                        to.addMoney(amount);
                    }
                }
            }
        }
    }
}
