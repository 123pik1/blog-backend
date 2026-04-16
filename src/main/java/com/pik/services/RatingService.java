package com.pik.services;

import java.util.List;

import com.pik.database.entities.Vote;
import com.pik.database.repository.VoteRepository;
import com.pik.dtos.RatingDTO;

public class RatingService {
    VoteRepository repository;

    RatingService(VoteRepository repository) {
        this.repository = repository;
    }

    public RatingDTO calculateRatingForPost(Long postId) {
        List<Vote> votes = repository.findByPostId(postId);
        RatingDTO rating = new RatingDTO();
        for (Vote vote : votes) {
            if (vote.getValue() < 0)
                rating.setDownvotes(rating.getDownvotes() + 1);
            else
                rating.setUpvotes(rating.getUpvotes() + 1);
        }
        rating.setRating(rating.getUpvotes() - rating.getDownvotes());
        return rating;
    }
}
