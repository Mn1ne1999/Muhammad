package org.example.lession10.lession3.option2;

public class Worker implements Runnable {
    private final int id;
    private final MachineStation station;

    public Worker(int id, MachineStation station) {
        this.id = id;
        this.station = station;
    }

    @Override
    public void run() {
        station.work(id);
    }
}