package com.cognizant.handson2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.handson2.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query(value="SELECT e FROM Employee e left join fetch e.department d left join fetch e.skillList WHERE e.permanent = 1")
	List<Employee> getAllPermanentEmployees();
	
	@Query(value="SELECT AVG(e.salary) FROM Employee e")
	double getAverageSalary();
	
	@Query(value="SELECT * FROM employee", nativeQuery = true)
	List<Employee> getAllEmployeesNative();
}
