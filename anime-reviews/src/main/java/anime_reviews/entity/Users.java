package anime_reviews.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "watched_anime", columnDefinition = "SET")
    private Set<Long> watchedAnime;

    @Column(name = "watching_anime", columnDefinition = "SET")
    private Set<Long> watchingAnime;

    @Column(name = "want_to_watch", columnDefinition = "SET")
    private Set<Long> wantToWatch;

    @Column(name = "wont_watch", columnDefinition = "SET")
    private Set<Long> wontWatch;

    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    private AnimeReview animeReview;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "anime_users", joinColumns = @JoinColumn(name = "anime_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Anime> anime = new HashSet<>();

    public void addWatchedAnime(Long watchedAnime) {
        this.watchedAnime.add(watchedAnime);
    }

    public void addWatchingAnime(Long watchingAnime) {
        this.watchingAnime.add(watchingAnime);
    }

    public void addWantToWatchAnime(Long wantToWatchAnime) {
        this.wantToWatch.add(wantToWatchAnime);
    }

    public void addWontWatchAnime(Long wontWatchAnime) {
        this.wontWatch.add(wontWatchAnime);
    }
}
