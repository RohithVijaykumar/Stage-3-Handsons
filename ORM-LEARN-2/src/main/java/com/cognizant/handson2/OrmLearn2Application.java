package com.cognizant.handson2;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.handson2.model.Department;
import com.cognizant.handson2.model.Employee;
import com.cognizant.handson2.service.DepartmentService;
import com.cognizant.handson2.service.EmployeeService;
import com.cognizant.handson2.service.SkillService;

@SpringBootApplication
public class OrmLearn2Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearn2Application.class);
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;

	private static void testGetEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList());
		LOGGER.info("End");
	}

	private static void testAddEmployee() {
		LOGGER.info("Start");
		Employee employee = new Employee();
		employee.setName("Rohith");
		employee.setSalary(10000);
		Department department = departmentService.get(1);
		employee.setDepartment(department);
		employeeService.save(employee);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.info("End");
	}

	private static void testUpdateEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		Department department = departmentService.get(2);
		employee.setDepartment(department);
		employeeService.save(employee);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.info("End");
	}

	private static void testGetDepartment() {
		LOGGER.info("Start");
		Department department = departmentService.get(2);
		LOGGER.debug("Department:{}", department.getEmployeeList());

		LOGGER.info("End");
	}

	private static void testAddSkillToEmployee() {
		LOGGER.info("Start");

		LOGGER.info("End");
	}

	public static void testGetAllPermanentEmployees() {
		LOGGER.info("Start");
		List<Employee> employees = employeeService.getPermanentEmployee();
		LOGGER.debug("Permanent Employees:{}", employees);
		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
		LOGGER.info("End");
	}

	public static void testGetAverageSalaryOfEmployees() {
		LOGGER.info("Start");
		LOGGER.debug("Average Salary of Employees:{}", employeeService.getAverageSalaryOfEmployee());
		LOGGER.info("End");
	}

	private static void testGetAllEmployeesNative() {
		LOGGER.info("Start");
		List<Employee> employee = employeeService.getAllEmployeesNative();
		LOGGER.debug("Employee:{}", employee);
		LOGGER.info("End");
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearn2Application.class, args);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);

		testGetEmployee();
		testAddEmployee();
		testUpdateEmployee();
		testGetDepartment();
		testAddSkillToEmployee();
		testGetAllPermanentEmployees();
		testGetAverageSalaryOfEmployees();
		testGetAllEmployeesNative();

	}

}
