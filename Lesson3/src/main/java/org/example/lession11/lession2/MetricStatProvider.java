package org.example.lession11.lession2;


import java.time.LocalDateTime;
import java.util.List;

public interface MetricStatProvider {
    List<MethodMetricStat> getTotalStatForPeriod(LocalDateTime from, LocalDateTime to);
    MethodMetricStat getTotalStatByMethodForPeriod(String method, LocalDateTime from, LocalDateTime to);
}

