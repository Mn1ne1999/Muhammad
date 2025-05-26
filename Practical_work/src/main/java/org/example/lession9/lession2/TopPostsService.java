package org.example.lession9.lession2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TopPostsService {

    /**
     * @param posts список всех постов
     * @return топ‑10 по лайкам, упорядоченный по убыванию
     */
    public List<Post> findTop10(List<Post> posts) {
        PriorityQueue<Post> heap = new PriorityQueue<>(Comparator.comparingInt(Post::likes));

        for (Post p : posts) {
            if (heap.size() < 10) {
                heap.offer(p);
            } else if (p.likes() > heap.peek().likes()) {
                heap.poll();
                heap.offer(p);
            }
        }
        List<Post> result = new ArrayList<>(heap);
        result.sort(Comparator.comparingInt(Post::likes).reversed());
        return result;
    }
}