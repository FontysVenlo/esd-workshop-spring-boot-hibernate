package com.ESD.steamed;

import com.ESD.steamed.game.Game;
import com.ESD.steamed.review.Review;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ReviewTestSetup {

    private final List<Review> reviews = new ArrayList<>();
    //TODO: Make this get a List
    public ReviewTestSetup(Game game1, Game game2) {
        fillReviewsList(game1, game2);
    }

    public List<Review> getReviews() {
        return reviews;
    }

    private void fillReviewsList(Game game1, Game game2) {
        Review review1 = new Review();
        review1.setTitle("Amazing Adventure");
        review1.setRating(3L);
        review1.setComment("Loved the gameplay and story!");
        review1.setCreated_at(LocalTime.now());
        review1.setGame(game1);

        Review review2 = new Review();
        review2.setTitle("Pretty Good");
        review2.setRating(2L);
        review2.setComment("Fun but had some bugs.");
        review2.setCreated_at(LocalTime.now());
        review2.setGame(game1);

        Review review3 = new Review();
        review3.setTitle("Not Bad");
        review3.setRating(1L);
        review3.setComment("Average experience.");
        review3.setCreated_at(LocalTime.now());
        review3.setGame(game2);

        reviews.add(review1);
        reviews.add(review2);
        reviews.add(review3);
    }
}
