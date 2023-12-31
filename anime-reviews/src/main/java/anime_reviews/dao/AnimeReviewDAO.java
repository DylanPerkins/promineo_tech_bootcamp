package anime_reviews.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import anime_reviews.entity.AnimeReview;

public interface AnimeReviewDAO extends JpaRepository<AnimeReview, Integer> {
    
}
