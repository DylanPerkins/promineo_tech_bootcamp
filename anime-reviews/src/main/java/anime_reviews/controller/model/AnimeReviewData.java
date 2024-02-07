package anime_reviews.controller.model;

import anime_reviews.entity.Anime;
import anime_reviews.entity.AnimeReview;
import anime_reviews.entity.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnimeReviewData {
    private Long reviewId;
    private Long animeId;
    private Long userId;
    private double rating;
    private String reviewText;

    public AnimeReviewData(AnimeReview animeReview) {
        this.reviewId = animeReview.getReviewId();
        this.animeId = animeReview.getAnime().getAnimeId();
        this.userId = animeReview.getUser().getUserId();
        this.rating = animeReview.getRating();
        this.reviewText = animeReview.getReviewText();
    }

    public AnimeReviewData(Long reviewId, Long anime, Long user, double rating, String reviewText) {
        this.reviewId = reviewId;
        this.animeId = anime;
        this.userId = user;
        this.rating = rating;
        this.reviewText = reviewText;
    }

    public AnimeReviewData(Long reviewId, double rating, Long anime, Long user) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.animeId = anime;
        this.userId = user;
    }

    public AnimeReview toAnimeReview(Users user, Anime anime) {
        AnimeReview animeReview = new AnimeReview();

        animeReview.setReviewId(this.reviewId);
        animeReview.setAnime(anime);
        animeReview.setUser(user);
        animeReview.setRating(this.rating);
        animeReview.setReviewText(this.reviewText);

        return animeReview;
    }

}
