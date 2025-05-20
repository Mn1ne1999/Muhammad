package org.example.lession9.lession3;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Client {
    private static final Random RND = new Random();

    private final long   id = RND.nextLong();
    private final String name;
    private final int    age;
    private final List<Phone> phones;

    public Client(String name, int age, List<Phone> phones) {
        this.name   = name;
        this.age    = age;
        this.phones = phones == null ? Collections.emptyList() : List.copyOf(phones);
    }
    public long id()              { return id;     }
    public String name()          { return name;   }
    public int age()              { return age;    }
    public List<Phone> phones()   { return phones; }
}
