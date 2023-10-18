package pet_store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pet_store.entity.PetStore;

public interface PetStoreDao extends JpaRepository<PetStore, Long>{
    
}
