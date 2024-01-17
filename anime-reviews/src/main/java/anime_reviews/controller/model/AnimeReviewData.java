package anime_reviews.controller.model;

import anime_reviews.entity.AnimeReview;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnimeReviewData {
    private Long reviewId;
    private AnimeData anime;
    private UsersData user;
    private double rating;
    private String reviewText;

    public AnimeReviewData(Long reviewId, AnimeData anime, UsersData user, double rating, String reviewText) {
        this.reviewId = reviewId;
        this.anime = anime;
        this.user = user;
        this.rating = rating;
        this.reviewText = reviewText;
    }

    public AnimeReviewData(Long reviewId, double rating, AnimeData anime, UsersData user) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.anime = anime;
        this.user = user;
    }

    public AnimeReview toAnimeReview() {
        AnimeReview animeReview = new AnimeReview();

        animeReview.setReviewId(this.reviewId);
        animeReview.setRating(this.rating);
        animeReview.setAnime(this.anime.toAnime());
        animeReview.setUser(this.user.toUsers());
        animeReview.setReviewText(this.reviewText);

        return animeReview;
    }

}
