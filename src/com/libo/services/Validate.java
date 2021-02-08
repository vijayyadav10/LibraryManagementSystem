package com.libo.services;

import java.util.List;

import com.libo.beans.User;

public interface Validate {
	Boolean login(List<User> users);
	
	String authorizeUser(List<User> users);
}
