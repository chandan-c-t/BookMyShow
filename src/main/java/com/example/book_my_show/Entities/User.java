package com.example.book_my_show.Entities;


import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @Column(unique = true)
    @NonNull
    private String email;

    @Column(unique = true)
    @NonNull
    private String mobNo;

    private String address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Ticket> bookedTickets = new ArrayList<>();

}
