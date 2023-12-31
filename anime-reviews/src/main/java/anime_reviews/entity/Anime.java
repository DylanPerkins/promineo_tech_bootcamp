package anime_reviews.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Anime")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anime_id")
    private Long animeId;

    @Column(name = "title")
    private String title;

    @Column(name = "animation_studio")
    private String animationStudio;

    @Column(name = "episode_count")
    private int episodeCount;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false, mappedBy = "anime")
    private Set<Tags> tags = new HashSet<>();
}
