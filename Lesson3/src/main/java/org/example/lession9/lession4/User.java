package org.example.lession9.lession4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class User {
    private static final Random RND = new Random();

    private final long id = RND.nextLong();
    private final String name;
    private List<User> friends = new ArrayList<>();

    public User(String name) { this.name = name; }
    public long id()        { return id;   }
    public String name()    { return name; }
    public List<User> friends() { return friends; }
    public void friends(List<User> f)      { friends = f; }
}