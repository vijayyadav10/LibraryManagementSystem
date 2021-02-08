package com.libo.services.impl;

import java.util.List;
import java.util.Scanner;

import com.libo.beans.User;
import com.libo.services.Validate;

public class ValidateServiceImpl implements Validate {
	String username;
	String password;

	@Override
	public Boolean login(List<User> users) {

		Scanner in = new Scanner(System.in);

		System.out.println("Enter your username and password");

		username = in.nextLine();
		password = in.nextLine();

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
	public String authorizeUser(List<User> users) {

		for (User user : users) {
			if (username.equals(user.getName()) && password.equals(user.getPassword())) {

				String role = user.getRole().toString();

				if ("ADMIN".equals(role)) {
					return "ADMIN";
				}
			}

//			return null;
		}
		return "STUDENT";
	}
}

//					String role = user.getRole().toString();
//
//					if ("ADMIN".equals(role)) {
//		Admin admin = new Admin(1, "admin", "abcd");
//		Student jay = new Student(11, "jay", "pimpri", "pune", "1234");
//		Student shimona = new Student(22, "shimona", "dighi", "pune", "password");
//		Student bobby = new Student(33, "bobby", "dighi", "pune", "password");
//
//		List<User> users = List.of(admin, jay, shimona, bobby);