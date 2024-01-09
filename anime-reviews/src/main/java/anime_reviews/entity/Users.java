package anime_reviews.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

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

    @Column(name = "user_key")
    private String userKey;

    @Column(name = "watched_anime")
    private Anime watchedAnime;

    @Column(name = "watching_anime")
    private Anime watchingAnime;

    @Column(name = "want_to_watch")
    private Anime wantToWatch;

    @Column(name = "wont_watch")
    private Anime wontWatch;

    @Column(name = "reviews")
    private int reviews;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Anime anime;
}
