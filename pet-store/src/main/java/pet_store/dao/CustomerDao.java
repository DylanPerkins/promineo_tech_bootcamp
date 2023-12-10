package pet_store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pet_store.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long> {

}
