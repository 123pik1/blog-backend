package com.pik.database.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Posts")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    protected User author;

    @Column(columnDefinition = "TEXT")
    protected String content;

    protected LocalDateTime creationDate;

    protected Boolean edited;

    protected LocalDateTime lastEditionDate;

    // private int upvotes;
    // private int downvotes;

}
