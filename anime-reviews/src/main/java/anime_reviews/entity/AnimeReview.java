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
@Table(name = "AnimeReview")
public class AnimeReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int reviewId;

    @ManyToOne
    @JoinColumn(name = "anime_id")
    private Anime anime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "rating")
    private double rating;

    @Column(name = "review_text")
    private String reviewText;
}