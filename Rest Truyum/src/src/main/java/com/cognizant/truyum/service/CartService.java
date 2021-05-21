package com.cognizant.truyum.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.model.MenuItem;

import org.springframework.stereotype.Service;

@Service
public class CartService {
	
	@Autowired
	CartDao cartDao;
	
	@Transactional
	public void addCartItem(String userId, long menuItemId) {
		cartDao.addCartItem(userId, menuItemId);
	}
	
	@Transactional
	public List<MenuItem> getAllCartItems(String userId) {
		return cartDao.getAllCartItems(userId);
	}
	
	@Transactional
	public void deleteCartItems(String userId, long menuItemId) {
		cartDao.removeCartItem(userId, menuItemId);	
	}
}
