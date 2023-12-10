package pet_store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pet_store.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long> {

}
