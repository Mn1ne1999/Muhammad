package org.example.lession9.lession1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinnerCalculator {

    /**
     * @param records список строк формата «имя количество_очков»
     * @return имя победителя
     */
    public String determineWinner(List<String> records) {
        Map<String, Integer> scores = new HashMap<>();
        String winner = null;
        int best = Integer.MIN_VALUE;

        for (String r : records) {
            String[] parts = r.split("\\s+");
            String name = parts[0];
            int points = Integer.parseInt(parts[1]);

            int total = scores.getOrDefault(name, 0) + points;
            scores.put(name, total);

            if (total > best) {          // первый, кто превысил максимум
                best = total;
                winner = name;
            }
        }
        return winner;
    }
}
