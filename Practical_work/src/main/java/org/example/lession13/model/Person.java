package org.example.lession13.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "persons")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthDate;
    private boolean active = true;

    

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IdentityDocument> identityDocuments = new ArrayList<>();

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "person_address",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Set<Address> addresses = new HashSet<>();

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();
}