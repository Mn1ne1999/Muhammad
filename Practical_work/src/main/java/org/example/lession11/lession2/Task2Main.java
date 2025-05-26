package org.example.lession11.lession2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.time.LocalDateTime;

public class Task2Main {
    public static void main(String[] args) throws InterruptedException {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TimedConfig.class)) {

            DemoService svc = ctx.getBean(DemoService.class);
            MetricStatProvider stats = ctx.getBean(MetricStatProvider.class);

            // генерируем вызовы
            for (int i = 0; i < 5; i++) { svc.fast(); }
            for (int i = 0; i < 2; i++) { svc.slow(); }

            LocalDateTime from = LocalDateTime.now().minusMinutes(10);
            LocalDateTime to   = LocalDateTime.now().plusMinutes(1);

            System.out.println("\nСтатистика по всем методам:");
            stats.getTotalStatForPeriod(from, to).forEach(System.out::println);

            System.out.println("\nТолько slow():");
            System.out.println(stats.getTotalStatByMethodForPeriod(
                    "DemoService#slow", from, to));
        }
    }
}

