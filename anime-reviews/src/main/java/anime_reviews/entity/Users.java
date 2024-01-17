package anime_reviews.entity;

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

    // TODO - change to 
    @Column(name = "watched_anime")
    private List<Integer> watchedAnime;

    @Column(name = "watching_anime")
    private List<Integer> watchingAnime;

    @Column(name = "want_to_watch")
    private List<Integer> wantToWatch;

    @Column(name = "wont_watch")
    private List<Integer> wontWatch;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private AnimeReview animeReview;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "anime_users", joinColumns = @JoinColumn(name = "anime_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Anime> anime = new HashSet<>();

    public void addWatchedAnime(Anime watchedAnime) {
        anime.add(watchedAnime);
        watchedAnime.getUsers().add(this);
    }

    public void addWatchingAnime(Anime watchingAnime) {
        anime.add(watchingAnime);
        watchingAnime.getUsers().add(this);
    }

    public void addWantToWatchAnime(Anime wantToWatchAnime) {
        anime.add(wantToWatchAnime);
        wantToWatchAnime.getUsers().add(this);
    }

    public void addWontWatchAnime(Anime wontWatchAnime) {
        anime.add(wontWatchAnime);
        wontWatchAnime.getUsers().add(this);
    }
}
