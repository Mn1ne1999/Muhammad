package org.example.lession9.lession4;

import java.util.*;

public class SocialGraphSearch implements SearchService {

    @Override
    public List<User> bfs(User me, String name) {
        List<User> result = new ArrayList<>();
        Set<Long> visited = new HashSet<>();
        Deque<User> queue = new ArrayDeque<>();

        queue.add(me);
        visited.add(me.id());

        while (!queue.isEmpty()) {
            User current = queue.poll();
            if (name.equals(current.name())) result.add(current);
            for (User friend : current.friends()) {
                if (visited.add(friend.id())) queue.add(friend);
            }
        }
        return result;
    }

    @Override
    public List<User> dfs(User me, String name) {
        List<User> result = new ArrayList<>();
        dfs(me, name, new HashSet<>(), result);
        return result;
    }

    private void dfs(User u, String name, Set<Long> visited, List<User> result) {
        if (u == null || !visited.add(u.id())) return;
        if (name.equals(u.name())) result.add(u);
        for (User f : u.friends()) dfs(f, name, visited, result);
    }
}