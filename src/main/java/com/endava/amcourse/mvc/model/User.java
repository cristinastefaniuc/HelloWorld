package com.endava.amcourse.mvc.model;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "age")
    private int age;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

}
