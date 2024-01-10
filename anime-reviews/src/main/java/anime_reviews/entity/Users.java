package anime_reviews.entity;

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
    private int userId;

    @Column(name = "username")
    private String username;

    @Column(name = "watched_anime")
    private Anime watchedAnime;

    @Column(name = "watching_anime")
    private Anime watchingAnime;

    @Column(name = "want_to_watch")
    private Anime wantToWatch;

    @Column(name = "wont_watch")
    private Anime wontWatch;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private AnimeReview animeReview;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "anime_users", joinColumns = @JoinColumn(name = "anime_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Anime> anime;
}
