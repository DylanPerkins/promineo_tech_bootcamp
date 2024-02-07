package anime_reviews.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

import anime_reviews.entity.AnimeReview;
import anime_reviews.entity.Users;

@Data
@NoArgsConstructor
public class UsersData {
    private Long userId;
    private String username;
    private Set<Long> watchedAnime;
    private Set<Long> watchingAnime;
    private Set<Long> wantToWatch;
    private Set<Long> wontWatch;
    private Set<AnimeReviewData> animeReviews = new HashSet<>();

    public UsersData(Users user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.watchedAnime = user.getWatchedAnime();
        this.watchingAnime = user.getWatchingAnime();
        this.wantToWatch = user.getWantToWatch();
        this.wontWatch = user.getWontWatch();

        // Null checking
        removeNullValues();

        if (user.getAnimeReviews() != null) {
            for (AnimeReview review : user.getAnimeReviews()) {
                AnimeReviewData reviewData = new AnimeReviewData(review);

                this.animeReviews.add(reviewData);
            }
        }
    }

    public UsersData(Long userId, String username, Set<Long> watchedAnime, Set<Long> watchingAnime,
            Set<Long> wantToWatch, Set<Long> wontWatch) {
        this.userId = userId;
        this.username = username;
        this.watchedAnime = watchedAnime;
        this.watchingAnime = watchingAnime;
        this.wantToWatch = wantToWatch;
        this.wontWatch = wontWatch;
    }

    public UsersData(Long userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public Users toUsers() {
        Users user = new Users();

        user.setUserId(this.userId);
        user.setUsername(this.username);
        user.setWatchedAnime(this.watchedAnime);
        user.setWatchingAnime(this.watchingAnime);
        user.setWantToWatch(this.wantToWatch);
        user.setWontWatch(this.wontWatch);

        if (this.animeReviews != null) {
            for (AnimeReviewData reviewData : this.animeReviews) {
                AnimeReview review = reviewData.toAnimeReview(user, null);

                user.getAnimeReviews().add(review);
            }
        }

        return user;
    }

    public void removeNullValues() {
        if (this.watchedAnime == null) {
            this.watchedAnime = Set.of();
        }

        if (this.watchingAnime == null) {
            this.watchingAnime = Set.of();
        }

        if (this.wantToWatch == null) {
            this.wantToWatch = Set.of();
        }

        if (this.wontWatch == null) {
            this.wontWatch = Set.of();
        }
    }

    public UsersData(Long userId2, String username2, Set<Long> watchedAnime2, Set<Long> watchingAnime2,
            Set<Long> wantToWatch2, Set<Long> wontWatch2, Set<AnimeReview> animeReviews2) {
        this.userId = userId2;
        this.username = username2;
        this.watchedAnime = watchedAnime2;
        this.watchingAnime = watchingAnime2;
        this.wantToWatch = wantToWatch2;
        this.wontWatch = wontWatch2;

        if (animeReviews2 != null) {
            for (AnimeReview review : animeReviews2) {
                AnimeReviewData reviewData = new AnimeReviewData(review);
                this.animeReviews.add(reviewData);
            }
        }
    }

}
