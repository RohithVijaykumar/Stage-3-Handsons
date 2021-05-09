package com.cognizant.handson2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.handson2.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
