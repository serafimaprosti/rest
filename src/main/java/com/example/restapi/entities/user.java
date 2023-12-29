package com.example.restapi.entities;

import lombok.*;
import javax.persistence.*;


@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_surname")
    private String userSurname;

    @Column(name = "user_age")
    private int userAge;

    @Column(name = "user_email")
    private String userEmail;
}
