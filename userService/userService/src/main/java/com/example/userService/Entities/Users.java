package com.example.userService.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String rut;
    private String name;
    private String lastname;
    @Column(nullable = false)
    private int ingreso = 0;
    private Date birthdate;

    @Column(nullable = false)
    private Boolean register = false;
}
