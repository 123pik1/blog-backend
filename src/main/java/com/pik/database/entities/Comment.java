package com.pik.database.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Comment extends Post {

    private int upvotes;
    private int downvotes;

    @ManyToOne
    @JoinColumn(name = "parentPost_id")
    private Post parentPost;
}
