package org.example.lession11.lession2;

public class MethodMetricStat {
    public final String methodName;
    public final long   count;
    public final long   min;
    public final double avg;
    public final long   max;

    public MethodMetricStat(String name, long count, long min, double avg, long max) {
        this.methodName = name; this.count = count;
        this.min = min; this.avg = avg; this.max = max;
    }

    @Override public String toString() {
        return "%s: count=%d, min=%dms, avg=%.2fms, max=%dms"
                .formatted(methodName, count, min, avg, max);
    }
}

