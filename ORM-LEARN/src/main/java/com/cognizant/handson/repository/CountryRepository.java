package com.cognizant.handson.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.handson.model.Country;

@Repository

public interface CountryRepository extends JpaRepository<Country, String> {

//	@Query("Select * from country where co_name like %?1%;")
//	public <List>Country findAllThatContains(String s);

	public List<Country> findByNameContaining(String s);
	public List<Country> findByNameOrderByName(String s);
	public List<Country> findByNameStartingWith(String s);
	
}