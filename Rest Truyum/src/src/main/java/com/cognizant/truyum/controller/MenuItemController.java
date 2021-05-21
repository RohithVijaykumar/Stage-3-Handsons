package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@RequestMapping("/menu-items")
@RestController
public class MenuItemController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);
	
	@Autowired
	MenuItemService menuItemService;
	
	@GetMapping
	public List<MenuItem> getAllMenuItems() {
		LOGGER.info("START");
		List<MenuItem> menuItems = menuItemService.getMenuItemListCustomer();
		
		LOGGER.debug("MenuItems : {}", menuItems);
		LOGGER.info("END");
		return menuItems;
	}
	
	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable long id) {
		LOGGER.info("START");
		MenuItem menuItem = menuItemService.getMenuItem(id);
		
		LOGGER.debug("MenuItem : {}", menuItem);
		LOGGER.info("END");
		return menuItem;
	}
	
	@PutMapping
	public void modifyMenuItem(@RequestBody MenuItem menuItem) {
		LOGGER.info("START");
		menuItemService.modifyMenuItem(menuItem);
		LOGGER.debug("MenuItem : {}", menuItem);
		LOGGER.info("END");
	}
	
}