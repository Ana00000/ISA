/**
 * Class User
 * AUTHOR: Aleksandar Hadzibabic
 * DATE: 24/1/2021
 */

package com.example.demo.model;

import javax.persistence.*;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

@Entity
@Inheritance(strategy=TABLE_PER_CLASS)
public abstract class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String userID;

    @Column(name="name", unique=false, nullable=false)
    private String name;

    @Column(name="lastName", unique=false, nullable=false)
    private String lastName;
}