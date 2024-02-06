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
    private AnimeData anime;
    private UsersData user;
    private double rating;
    private String reviewText;

    public AnimeReviewData(AnimeReview animeReview) {
        this.reviewId = animeReview.getReviewId();
        this.anime = new AnimeData(animeReview.getAnime());
        this.user = new UsersData(animeReview.getUser());
        this.rating = animeReview.getRating();
        this.reviewText = animeReview.getReviewText();
    }

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
