package com.libo.services.impl;

import java.util.List;
import java.util.Scanner;

import com.libo.beans.Library;
import com.libo.beans.User;
import com.libo.services.Validate;

public class ValidateServiceImpl implements Validate {
	String username;
	String password;

	List<User> users = Library.getObject().getUsers();

	@Override
	public Boolean login(String username, String password) {
		if (username != null && password != null) {
			for (User user : users) {
				if (username.equals(user.getName()) && password.equals(user.getPassword())) {
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public String authorizeUser(String username, String password) {
		for (User user : users) {
			if (username.equals(user.getName()) && password.equals(user.getPassword())) {
				String role = user.getRole().toString();
				if ("ADMIN".equals(role)) {
					return "ADMIN";
				}
			}

		}
		return "STUDENT";
	}
}
