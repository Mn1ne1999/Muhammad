package org.example.lession9.lession3;

import java.util.*;
import java.util.stream.Collectors;

public class ClientAnalytics {

    /** Суммарный возраст клиентов с указанным именем. */
    public int totalAgeForName(Client[] clients, String name) {
        return Arrays.stream(clients)
                .filter(c -> c.name().equals(name))
                .mapToInt(Client::age)
                .sum();
    }

    /** Порядок появлений имён без повторений. */
    public Set<String> namesInOrder(Client[] clients) {
        return Arrays.stream(clients)
                .map(Client::name)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /** Есть ли клиент старше заданного возраста? */
    public boolean anyOlderThan(Client[] clients, int age) {
        return Arrays.stream(clients).anyMatch(c -> c.age() > age);
    }

    /** Карта id → name с сохранением порядка в исходном массиве. */
    public Map<Long, String> idToName(Client[] clients) {
        Map<Long, String> map = new LinkedHashMap<>();
        for (Client c : clients) map.put(c.id(), c.name());
        return map;
    }

    /** Группировка клиентов по возрасту. */
    public Map<Integer, List<Client>> ageToClients(Client[] clients) {
        return Arrays.stream(clients).collect(Collectors.groupingBy(Client::age));
    }

    /** Все телефоны через запятую. */
    public String allPhones(Client[] clients) {
        return Arrays.stream(clients)
                .flatMap(c -> c.phones().stream())
                .map(Phone::value)
                .collect(Collectors.joining(", "));
    }

    /** Самый возрастной клиент, у которого есть стационарный телефон. */
    public Optional<Client> oldestWithStationary(Client[] clients) {
        return Arrays.stream(clients)
                .filter(c -> c.phones().stream().anyMatch(p -> p.type() == PhoneType.STATIONARY))
                .max(Comparator.comparingInt(Client::age));
    }
}