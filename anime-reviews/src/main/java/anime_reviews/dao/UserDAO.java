package anime_reviews.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import anime_reviews.entity.Users;

public interface UserDAO extends JpaRepository<Users, Integer>{
    
}
