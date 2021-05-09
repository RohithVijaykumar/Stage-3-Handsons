package com.cognizant.handson.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.handson.model.Country;
import com.cognizant.handson.repository.CountryRepository;
import com.cognizant.handson.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	@Autowired
	private CountryRepository cr;
	
	@Transactional
	public List<Country> getAllCountries(){
		return cr.findAll();
	}
	
	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException{
		Optional<Country> result = cr.findById(countryCode);
		Country country= new Country();
		if (!result.isPresent()) {
			country = result.get();
		}
		return country;
	}
	
	@Transactional
	public void addCountry(Country country)
	{
		cr.save(country);
	}
	
	@Transactional
	public void updateCountry(String code, String name) throws CountryNotFoundException
	{
		Country country= new Country();
		Optional<Country> result = cr.findById(code);
		if (!result.isPresent()) {
			country = result.get();
		}
		country.setCode(code);
		country.setName(name);
		cr.save(country);
	}
	
	@Transactional
	public void deleteCountry(Country country)
	{
		cr.deleteById(country.getCode());
	}
	
	@Transactional
	public List<Country> searchCountry(String s){
		List<Country> c=(List<Country>) cr.findByNameContaining(s);
		return c;
	}
	
	@Transactional
	public List<Country> searchCountryOrdered(String s){
		List<Country> c=(List<Country>) cr.findByNameOrderByName(s);
		return c;
	}
	
	@Transactional
	public List<Country> searchCountryStartingWith(String s){
		List<Country> c=(List<Country>) cr.findByNameStartingWith(s);
		return c;
	}
	
}
