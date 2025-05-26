package org.example.lession13.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String region;
    private String city;
    private String street;
    private String house;
    private String flat;

    private boolean registration; // true = прописка

    @ManyToMany(mappedBy = "addresses")
    private Set<Person> residents = new HashSet<>();
}
