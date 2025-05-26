package org.example.lession9.lession4;

import java.util.List;

interface SearchService {
    List<User> bfs(User me, String name);
    List<User> dfs(User me, String name);
}