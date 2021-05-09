package com.cognizant.truyum.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.App;
import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;

@Service
public class MenuItemService {

	@Autowired
	MenuItemDao menuItemDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemDao.getMenuItemListAdmin();
		
	}


	public List<MenuItem> getMenuItemListCustomer() {
		return menuItemDao.getMenuItemListCustomer();
		
	}

	public MenuItem getMenuItem(int menuItemId) {
		return menuItemDao.getMenuItem(menuItemId);
		
	}


	public void editMenuItem(MenuItem menuItem) {
		
		LOGGER.info("Start");
		 menuItemDao.modifyMenuItem(menuItem);
		LOGGER.info("End");
	}

}
