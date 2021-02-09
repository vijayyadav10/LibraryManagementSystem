package com.libo.services;

import java.util.List;

import com.libo.beans.User;

public interface Validate {
	Boolean login(String username, String password);
	
	String authorizeUser(String username, String password);
}
