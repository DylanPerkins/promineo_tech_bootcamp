package anime_reviews.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import anime_reviews.entity.Anime;

public interface AnimeDAO extends JpaRepository<Anime, Long> {
    
}
