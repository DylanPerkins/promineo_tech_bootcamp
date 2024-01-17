package anime_reviews.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import anime_reviews.entity.Tags;

public interface TagsDAO extends JpaRepository<Tags, Long>{
    
}
