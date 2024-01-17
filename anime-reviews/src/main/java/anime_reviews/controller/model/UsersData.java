package anime_reviews.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import anime_reviews.entity.Anime;
import anime_reviews.entity.Users;

@Data
@NoArgsConstructor
public class UsersData {
    private Long userId;
    private String username;
    private List<Integer> watchedAnime;
    private List<Integer> watchingAnime;
    private List<Integer> wantToWatch;
    private List<Integer> wontWatch;
    private AnimeReviewData animeReview;

    public UsersData(Users user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.watchedAnime = user.getWatchedAnime();
        this.watchingAnime = user.getWatchingAnime();
        this.wantToWatch = user.getWantToWatch();
        this.wontWatch = user.getWontWatch();

        if (user.getAnimeReview() != null) {
            AnimeReviewData animeReviewData = new AnimeReviewData(user.getAnimeReview());

            this.animeReview = animeReviewData;
        }
    }

    public UsersData(Long userId, String username, List<Integer> watchedAnime, List<Integer> watchingAnime, List<Integer> wantToWatch, List<Integer> wontWatch, AnimeReviewData animeReview) {
        this.userId = userId;
        this.username = username;
        this.watchedAnime = watchedAnime;
        this.watchingAnime = watchingAnime;
        this.wantToWatch = wantToWatch;
        this.wontWatch = wontWatch;
        this.animeReview = animeReview;
    }

    public UsersData(Long userId, String username, List<Integer> watchedAnime, List<Integer> watchingAnime, List<Integer> wantToWatch, List<Integer> wontWatch) {
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

}
