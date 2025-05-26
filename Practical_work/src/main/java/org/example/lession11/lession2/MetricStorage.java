package org.example.lession11.lession2;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.*;

@Component
public class MetricStorage {

    private final ConcurrentMap<String, CopyOnWriteArrayList<MetricEntry>> data = new ConcurrentHashMap<>();

    public void add(String method, MetricEntry entry) {
        data.computeIfAbsent(method, k -> new CopyOnWriteArrayList<>()).add(entry);
    }

    public ConcurrentMap<String, CopyOnWriteArrayList<MetricEntry>> snapshot() {
        return data;
    }
}
