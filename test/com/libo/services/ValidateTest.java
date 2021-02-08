package com.libo.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.libo.beans.Admin;
import com.libo.beans.Student;
import com.libo.beans.User;
import com.libo.services.impl.ValidateServiceImpl;

public class ValidateTest {

	private Validate validate;

	Admin admin = new Admin(1, "admin", "admin");
	Student jay = new Student(11, "jay", "pimpri", "pune", "student");
	Student shimona = new Student(22, "shimona", "dighi", "pune", "student");
	Student bobby = new Student(33, "bobby", "dighi", "pune", "student");
	
	List<User> users = List.of(admin, jay, shimona, bobby);

	@Before
	public void setUp() {
		this.validate = new ValidateServiceImpl();
	}

	@Test
	public void testValidateCredentials() {
		System.out.println("Please Enter Valid User Credentials So that we can test the validate unit");
		assertTrue("failure: user should be validate", this.validate.login(users));

		System.out.println("Please Enter Non Valid User Credentilas so that we can test the validate unit");
		assertFalse("failure: user should be not validate", this.validate.login(users));
	}

	@Test
	public void testAdminAthorization() {
		System.out.println("Please Enter Admin Credentials");
		this.validate.login(users);
		assertEquals("failure: user should be has admin role", this.validate.authorizeUser(users), "ADMIN");
	}
	
	@Test
	public void testUserAthorization() {
		System.out.println("Please Enter Student Credentials");
		this.validate.login(users);
		assertEquals("failure: user should be has student role", this.validate.authorizeUser(users), "STUDENT");
	}
}
