package pet_park.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pet_park.entity.PetPark;

public interface PetParkDao extends JpaRepository<PetPark, Long>{
    
}
