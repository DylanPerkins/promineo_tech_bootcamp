package anime_reviews.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

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
    private AnimeReviewData animeReview;

    public UsersData(Users user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.watchedAnime = user.getWatchedAnime();
        this.watchingAnime = user.getWatchingAnime();
        this.wantToWatch = user.getWantToWatch();
        this.wontWatch = user.getWontWatch();

        // Null checking
        removeNullValues();

        if (user.getAnimeReviews() != null && !user.getAnimeReviews().isEmpty()) {
            this.animeReview = new AnimeReviewData(user.getAnimeReviews().get(0));
        }
    }

    public UsersData(Long userId, String username, Set<Long> watchedAnime, Set<Long> watchingAnime,
            Set<Long> wantToWatch, Set<Long> wontWatch, AnimeReviewData animeReview) {
        this.userId = userId;
        this.username = username;
        this.watchedAnime = watchedAnime;
        this.watchingAnime = watchingAnime;
        this.wantToWatch = wantToWatch;
        this.wontWatch = wontWatch;
        this.animeReview = animeReview;
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

}
