package com.cognizant.handson;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.handson.model.Country;
import com.cognizant.handson.service.CountryService;
import com.cognizant.handson.service.exception.CountryNotFoundException;



@SpringBootApplication
public class OrmLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;

	private static void testGetAllCountries() {

		LOGGER.info("Start");

		List<Country> countries = countryService.getAllCountries();

		LOGGER.debug("countries={}", countries);

		LOGGER.info("End");

	}

	private static void countryByCodeTest() throws CountryNotFoundException {

		LOGGER.info("Start");
		
		Country country= new Country();
		try {
			country = countryService.findCountryByCode("IN");
		}catch(NoSuchElementException e)
		{
			throw new CountryNotFoundException("COUNTRY NOT FOUND !");
		}
		LOGGER.debug("Country:{}", country);

		LOGGER.info("End");

		}
	
	private static void testAddCountry() {
		
		LOGGER.info("Start");
		
		Country country = new Country("ZZ","ZEEZEE");
		countryService.addCountry(country);
		
		LOGGER.debug("Country:{}", country);

		LOGGER.info("End");

		}

	private static void testUpdateCountry() throws CountryNotFoundException {

		LOGGER.info("Start");
		
		countryService.updateCountry("ZZ","ZAAZAA");
		Country country= new Country();
		try {
			country = countryService.findCountryByCode("ZZ");
		}catch(NoSuchElementException e)
		{
			throw new CountryNotFoundException("COUNTRY NOT FOUND !");
		}
		LOGGER.debug("Country:{}", country);

		LOGGER.info("End");

		}
	
	private static void testDeleteCountry() {

		LOGGER.info("Start");
		
		Country country = new Country("ZZ","ZEEZEE");
		countryService.deleteCountry(country);
		
		LOGGER.debug("Country:{}", country);

		LOGGER.info("End");

		}
	
	private static void searchCountryContaining() {

		LOGGER.info("Start");
		
		List<Country> country= countryService.searchCountry("ou");
		
		LOGGER.debug("Country:{}", country);

		LOGGER.info("End");

		}
	private static void searchCountryContainingOrdered() {

		LOGGER.info("Start");
		
		List<Country> country= countryService.searchCountryOrdered("ou");
		
		LOGGER.debug("Country:{}", country);

		LOGGER.info("End");

		}
	private static void searchCountryStartingWith() {

		LOGGER.info("Start");
		
		List<Country> country= countryService.searchCountryStartingWith("Z");
		
		LOGGER.debug("Country:{}", country);

		LOGGER.info("End");

		}

	public static void main(String[] args) throws CountryNotFoundException {

		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

		countryService = context.getBean(CountryService.class);
		
//		Fetch all
		testGetAllCountries();
		
//		Country by code 
		countryByCodeTest();
		
//		Add Country
		testAddCountry();
		
//		Update Country
		testUpdateCountry();
		
//		Delete Country
		testDeleteCountry();
		
//		search countries containing input string
		searchCountryContaining();
		
//		search countries containing input string ordered asc
		searchCountryContainingOrdered();
		
//		search countries starting with input string
		searchCountryStartingWith();
	}
}
