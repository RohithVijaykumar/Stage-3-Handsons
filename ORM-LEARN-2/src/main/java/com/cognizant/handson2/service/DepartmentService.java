package com.cognizant.handson2.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.handson2.model.Department;
import com.cognizant.handson2.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository repo;

	@Transactional
	public Department get(int id) {
		return repo.findById(id).get();
	}

	@Transactional
	public void save(Department department) {
		repo.save(department);
	}
}
