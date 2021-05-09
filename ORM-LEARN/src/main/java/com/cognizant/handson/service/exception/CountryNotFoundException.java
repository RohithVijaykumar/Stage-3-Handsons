package com.cognizant.handson.service.exception;

@SuppressWarnings("serial")
public class CountryNotFoundException extends Throwable{
	
	public CountryNotFoundException(String s) {
		super(s);
	}
}