package org.example.lession10.lession2;

public class AccountThread implements Runnable {
    private final Account from;
    private final Account to;
    private final int amount;

    public AccountThread(Account from, Account to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4000; i++) {
            synchronized (from) {
                synchronized (to) {
                    if (from.takeOffMoney(amount)) {
                        to.addMoney(amount);
                    }
                }
            }
        }
    }
}
