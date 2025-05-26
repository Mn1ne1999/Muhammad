package org.example.lession11.lession2;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MetricStatProviderImpl implements MetricStatProvider {

    private final MetricStorage storage;

    public MetricStatProviderImpl(MetricStorage storage) {
        this.storage = storage;
    }

    @Override
    public List<MethodMetricStat> getTotalStatForPeriod(LocalDateTime from, LocalDateTime to) {
        return storage.snapshot().entrySet().stream()
                .map(e -> toStat(e.getKey(), e.getValue(), from, to))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public MethodMetricStat getTotalStatByMethodForPeriod(String method,
                                                          LocalDateTime from,
                                                          LocalDateTime to) {
        var list = storage.snapshot().get(method);
        return list == null ? null : toStat(method, list, from, to);
    }

    private MethodMetricStat toStat(String name, List<MetricEntry> entries,
                                    LocalDateTime from, LocalDateTime to) {
        var filtered = entries.stream()
                .filter(m -> !m.start().isBefore(from) && !m.start().isAfter(to))
                .toList();
        if (filtered.isEmpty()) return null;
        long min = filtered.stream().mapToLong(MetricEntry::durationMs).min().orElse(0);
        long max = filtered.stream().mapToLong(MetricEntry::durationMs).max().orElse(0);
        double avg = filtered.stream().mapToLong(MetricEntry::durationMs).average().orElse(0);
        return new MethodMetricStat(name, filtered.size(), min, avg, max);
    }
}

