package com.cognizant.truyum.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;

public interface CartDao {
	
	public void addCartItem(String userId, long menuItemId);

	public List<MenuItem> getAllCartItems(String userId);

	public void removeCartItem(String userId, long menuItemId);
}
