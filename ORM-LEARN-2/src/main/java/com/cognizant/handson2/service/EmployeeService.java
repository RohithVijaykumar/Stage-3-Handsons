package com.cognizant.handson2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.handson2.model.Employee;
import com.cognizant.handson2.repository.EmployeeRepository;


@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Transactional
	public Employee get(int id) {
		return repo.findById(id).get();
	}

	@Transactional
	public void save(Employee employee) {
		repo.save(employee);
	}
	
	@Transactional
	public List<Employee> getPermanentEmployee() {
		List<Employee> e= repo.getAllPermanentEmployees();
		return e;
	}
	
	@Transactional
	public double getAverageSalaryOfEmployee() {
		return repo.getAverageSalary();
	}
	
	@Transactional
	public List<Employee> getAllEmployeesNative(){
		return repo.getAllEmployeesNative();
		}
}