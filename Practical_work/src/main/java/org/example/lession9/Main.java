package org.example.lession9;

import org.example.lession9.lession1.WinnerCalculator;
import org.example.lession9.lession2.Post;
import org.example.lession9.lession2.TopPostsService;
import org.example.lession9.lession3.Client;
import org.example.lession9.lession3.ClientAnalytics;
import org.example.lession9.lession3.Phone;
import org.example.lession9.lession3.PhoneType;
import org.example.lession9.lession4.SocialGraphSearch;
import org.example.lession9.lession4.User;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        /* ---------------- ЗАДАЧА 1 ---------------- */
        System.out.println("----------- Задача 1 -------------");
        WinnerCalculator wc = new WinnerCalculator();
        List<String> records = List.of(
                "Ann 3", "Bob 4", "Ann 4",
                "Bob 3", "Cleo 10");

        // 1-а) «Кто первым вышел вперёд»
        System.out.println("first-leader winner:  " + wc.determineWinner(records));

        // 1-б) «Финальный лидер»
        String finalWinner = records.stream()
                .map(s -> s.split("\\s+"))
                .collect(Collectors.toMap(
                        p -> p[0],
                        p -> Integer.parseInt(p[1]),
                        Integer::sum))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("n/a");
        System.out.println("final-score winner:  " + finalWinner);

        /* ---------------- ЗАДАЧА 2 ---------------- */
        System.out.println("\n------------ Задача 2 -------------");
        List<Post> posts = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            posts.add(new Post("Post #" + i, (i * 3) % 17));
        }
        TopPostsService tps = new TopPostsService();
        System.out.println("top-10 posts (likes ↓):");
        tps.findTop10(posts)
                .forEach(p -> System.out.println("  " + p.text() + " -> " + p.likes()));

        /* ---------------- ЗАДАЧА 3 ---------------- */
        System.out.println("\n------------ Задача 3 -------------");
        Client c1 = new Client("Ann", 30,
                List.of(new Phone("123-45-67", PhoneType.MOBILE)));
        Client c2 = new Client("Bob", 42,
                List.of(new Phone("555-55-55", PhoneType.STATIONARY),
                        new Phone("777-77-77", PhoneType.MOBILE)));
        Client c3 = new Client("Ann", 25, List.of());
        Client[] clients = {c1, c2, c3};

        ClientAnalytics a = new ClientAnalytics();
        System.out.println("totalAgeForName(\"Ann\") = " + a.totalAgeForName(clients, "Ann"));
        System.out.println("namesInOrder = " + a.namesInOrder(clients));
        System.out.println("anyOlderThan(40) = " + a.anyOlderThan(clients, 40));

        // печать id->name
        System.out.println("idToName = ");
        a.idToName(clients).forEach((id, name) ->
                System.out.println("  " + id + " -> " + name));

        // печать age->clients
        System.out.println("ageToClients            = ");
        a.ageToClients(clients).forEach((age, list) ->
                System.out.println("  " + age + " -> " + list.stream()
                        .map(Client::name).collect(Collectors.toList())));

        System.out.println("allPhones = " + a.allPhones(clients));
        a.oldestWithStationary(clients)
                .ifPresent(o -> System.out.println("oldestWithStationary = " + o.name()
                        + "(" + o.age() + ")"));

        /* ---------------- ЗАДАЧА 4 ---------------- */
        System.out.println("\n------------- Задача 4 -------------");
        User u1 = new User("Ann");
        User u2 = new User("Bob");
        User u3 = new User("Bob");      // второй «Bob»
        User u4 = new User("Cleo");

        u1.friends(List.of(u2, u4));
        u2.friends(List.of(u3));
        u3.friends(List.of(u4));

        SocialGraphSearch search = new SocialGraphSearch();
        System.out.println("BFS Bob: " + names(search.bfs(u1, "Bob")));
        System.out.println("DFS Bob: " + names(search.dfs(u1, "Bob")));
    }

    /* Вспомогательный метод: берём имена из списка пользователей */
    private static List<String> names(List<User> users) {
        return users.stream().map(User::name).toList();
    }
}
