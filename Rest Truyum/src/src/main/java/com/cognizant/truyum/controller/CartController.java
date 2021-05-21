package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);
	
	@Autowired
	CartService cartService;

	@PostMapping("/{userId}/{menuItemId}")
	public ResponseEntity<String> addCartItem(@PathVariable("userId") String userId,@PathVariable("menuItemId") long menuItemId) {
		LOGGER.info("START");
		
		cartService.addCartItem(userId, menuItemId);
		LOGGER.info("END");
		return new ResponseEntity<String>("Item saved in cart successfully", HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public List<MenuItem> getAllCartItems(@PathVariable String userId) {
		LOGGER.info("START");
		List<MenuItem> cartItems = cartService.getAllCartItems(userId);
		
		LOGGER.debug("CartItems : {}", cartItems);
		LOGGER.info("END");
		return cartItems;
	}
	
	@DeleteMapping("/{userId}/{menuItemId}")
	public void deleteCartItems(@PathVariable("userId") String userId,@PathVariable("menuItemId") long menuItemId) {
		LOGGER.info("START");
		cartService.deleteCartItems(userId, menuItemId);
		LOGGER.info("Item deleted");
		LOGGER.info("END");
	}
}
