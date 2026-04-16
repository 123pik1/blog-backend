package com.pik.database.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "Users")
@Data // Getter and setter for everything
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    @ToString.Exclude
    @Column(length = 60)
    private String passwordHash;

    private Boolean canBlog;

    private String description;

    private String role;
}
