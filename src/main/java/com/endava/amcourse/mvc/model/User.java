package com.endava.amcourse.mvc.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {

    private int id;
    private String username;
    private String password;
    private int age;
    private Status status;

}
