package org.example.lession11.lession1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Task1Main {
    public static void main(String[] args) {
        // активируем профиль через JVM-параметр: -Dspring.profiles.active=ru  или  en
        try (AnnotationConfigApplicationContext ctx =
                     new AnnotationConfigApplicationContext(DateAppConfig.class)) {
            ctx.getBean(CommandRunner.class).run();
        }
    }
}

