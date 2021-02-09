package com.libo.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.libo.beans.BookTest;
import com.libo.dao.BookDAOTest;
//import com.libo.services.ValidateTest;

@RunWith(Suite.class)
@SuiteClasses({
	BookTest.class,
	BookDAOTest.class,
//	ValidateTest.class
})
public class LiboTestSuite {

}
