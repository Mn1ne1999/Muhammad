package org.example.lession11.lession1;


import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CommandRunner {

    private final DateService dateService;

    public CommandRunner(DateService dateService) {
        this.dateService = dateService;
    }

    public void run() {
        System.out.println("Команды: today | today-iso | exit");
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print("> ");
                String cmd = sc.nextLine().trim();
                switch (cmd) {
                    case "today"     -> System.out.println(dateService.today());
                    case "today-iso" -> System.out.println(dateService.todayIso());
                    case "exit"      -> { return; }
                    default          -> System.out.println("Неизвестная команда");
                }
            }
        }
    }
}

