package com.ESD.steamed;

import com.ESD.steamed.game.Game;
import com.ESD.steamed.review.Review;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.List;

public class ReviewTest {

    private List<Review> reviews;
    private Game game1;
    private Game game2;

    @BeforeEach
    public void setup() {
        game1 = new Game();
        game1.setTitle("Game One");

        game2 = new Game();
        game2.setTitle("Game Two");

        reviews = new ReviewTestSetup(game1, game2).getReviews();
    }

    @Test
    void testEntity() {
        SoftAssertions softly = new SoftAssertions();

        Review review1 = reviews.stream()
                .filter(r -> "Amazing Adventure".equals(r.getTitle()))
                .findFirst()
                .orElseThrow();
        softly.assertThat(review1.getRating()).isEqualTo(3L);
        softly.assertThat(review1.getComment()).isEqualTo("Loved the gameplay and story!");
        softly.assertThat(review1.getGame().getTitle()).isEqualTo("Game One");
        softly.assertThat(review1.getCreated_at()).isBeforeOrEqualTo(LocalTime.now());

        Review review3 = reviews.stream()
                .filter(r -> "Not Bad".equals(r.getTitle()))
                .findFirst()
                .orElseThrow();
        softly.assertThat(review3.getRating()).isEqualTo(1L);
        softly.assertThat(review3.getComment()).isEqualTo("Average experience.");
        softly.assertThat(review3.getGame().getTitle()).isEqualTo("Game Two");

        softly.assertAll();
    }
}
