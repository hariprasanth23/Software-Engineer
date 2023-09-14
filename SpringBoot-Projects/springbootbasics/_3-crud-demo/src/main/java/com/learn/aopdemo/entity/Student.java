package com.learn.aopdemo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="student")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;
}
