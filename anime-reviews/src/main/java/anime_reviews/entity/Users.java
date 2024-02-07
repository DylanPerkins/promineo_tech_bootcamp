package anime_reviews.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "watched_anime")
    private Set<Long> watchedAnime = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "watching_anime")
    private Set<Long> watchingAnime = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "want_to_watch")
    private Set<Long> wantToWatch = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "wont_watch")
    private Set<Long> wontWatch = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<AnimeReview> animeReviews = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "anime_users", joinColumns = @JoinColumn(name = "anime_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Anime> anime = new HashSet<>();

    public void addWatchedAnime(Long animeId) {
        watchedAnime.add(animeId);
    }

    public void addWatchingAnime(Long animeId) {
        System.out.println("Adding anime " + animeId + " to watching list");

        watchingAnime.add(animeId);
    }

    public void addWantToWatchAnime(Long animeId) {
        wantToWatch.add(animeId);
    }

    public void addWontWatchAnime(Long animeId) {
        wontWatch.add(animeId);
    }

    public void removeWatchingAnime(Long animeId) {
        watchingAnime.remove(animeId);
    }

    public void removeWatchedAnime(Long animeId) {
        watchedAnime.remove(animeId);
    }

    public void removeWantToWatchAnime(Long animeId) {
        wantToWatch.remove(animeId);
    }

    public void removeWontWatchAnime(Long animeId) {
        wontWatch.remove(animeId);
    }

}
