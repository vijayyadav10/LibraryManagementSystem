package com.libo.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.libo.beans.Admin;
import com.libo.beans.Library;
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
	Library lib = Library.getObject();

	@Before
	public void setUp() {
		lib.setUsers(users);
		this.validate = new ValidateServiceImpl();
	}

	@Test
	public void TestAdminLogin_WithEmptyPassword_ReturnFalse() {
		String userName = "admin";
		String password = "";
		assertFalse("failure: should return false", this.validate.login(userName, password));
	}

	@Test
	public void TestAdminLogin_WithFAKEPassword_ReturnFalse() {
		String userName = "admin";
		String password = "iamnotadmin";
		assertFalse("failure: should return false", this.validate.login(userName, password));
	}

	@Test
	public void TestAdminLogin_AdminCredentials_Pass() {
		String userName = "admin";
		String password = "admin";
		assertTrue("failure: user should be validate", this.validate.login(userName, password));
	}

	@Test
	public void TestStudentLogin_StudentCredentials_Pass() {
		String userName = "jay";
		String password = "student";
		assertTrue("failure: user should be validate", this.validate.login(userName, password));
	}

	@Test
	public void TestAdminAthorization_WithAdminCredentials_Admin() {
		String userName = "admin";
		String password = "admin";
		this.validate.login(userName, password);
		assertEquals("failure: user should be has admin role", this.validate.authorizeUser(userName, password),
				"ADMIN");
	}

	@Test
	public void TestStudentAthorization_WithStudentCredentials_Student() {
		String userName = "jay";
		String password = "student";
		this.validate.login(userName, password);
		assertEquals("failure: user should be has student role", this.validate.authorizeUser(userName, password),
				"STUDENT");
	}
}
