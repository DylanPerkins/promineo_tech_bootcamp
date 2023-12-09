package dog_rescue.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dog_rescue.entity.Location;

public interface LocationDao extends JpaRepository<Location, Long> {

}
