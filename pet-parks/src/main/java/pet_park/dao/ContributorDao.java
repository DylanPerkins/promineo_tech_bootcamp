package pet_park.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pet_park.entity.Contributor;

public interface ContributorDao extends JpaRepository<Contributor, Long> {

}
