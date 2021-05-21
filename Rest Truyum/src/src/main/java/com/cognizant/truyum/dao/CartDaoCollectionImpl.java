package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Component
public class CartDaoCollectionImpl implements CartDao {
	
	@Autowired
	MenuItemDao menuItemDao;
	
	private static HashMap<String, Cart> userCarts;

	public CartDaoCollectionImpl() {
		super();
		if (userCarts == null) {
			userCarts = new HashMap<String, Cart>();
		}
	}

	@Override
	public void addCartItem(String userId, long menuItemId) {
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);

		if (userCarts.containsKey(userId)) {
			List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
			menuItemList.add(menuItem);
		} else {
			Cart cart = new Cart(new ArrayList<MenuItem>(), 0.0);
			cart.getMenuItemList().add(menuItem);
			userCarts.put(userId, cart);
		}
	}

	@Override
	public List<MenuItem> getAllCartItems(String userId) {
		if (userCarts.containsKey(userId)) {
			List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
			double total = 0.0;
			for (int i = 0; i < menuItemList.size(); i++)
				total += menuItemList.get(i).getPrice();

			userCarts.get(userId).setTotal(total);
			return menuItemList;
		}
		return null;
	}

	@Override
	public void removeCartItem(String userId, long menuItemId) {
		List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItemId) {
				menuItemList.remove(i);
				break;
			}
		}
	}

}
