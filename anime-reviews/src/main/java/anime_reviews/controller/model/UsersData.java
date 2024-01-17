package anime_reviews.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

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
