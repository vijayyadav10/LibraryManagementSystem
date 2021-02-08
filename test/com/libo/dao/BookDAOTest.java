package com.libo.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.libo.beans.Book;
import com.libo.beans.Library;

public class BookDAOTest {

	private BookDAO bookDao;
	private List<Book> bookList;

	@BeforeClass
	public static void destroyExpensiveResource() {
		System.out.println("BookDAOTest.destroy");
	}

	@Before
	public void setUp() {
		this.bookDao = new BookDAOImpl(new Library());
	}

	@Test
	public void testGetBooks() {
		this.bookList = this.bookDao.getBooks();
		assertTrue("failure: size should be greater then 1", this.bookList.size() > 0);
		assertNotNull("failure: book list should  not be null/empty", this.bookList);
	}

	@Test
	public void testAddBook() {
		assertTrue("failure: the size should be same as actual size", this.bookList.size() == 5);
		bookDao.addBook();
		assertTrue("failure: the size should be same as actual size", this.bookList.size() == 6);
	}

	@Test
	public void testRemoveBook() {
		assertTrue("failure: the size should be same as actual size", this.bookList.size() == 5);
		bookDao.removeBook();
		assertTrue("failure: the size should be 1 less then actual size", this.bookList.size() == 4);
	}

	@After
	public void tearDown() {
		this.bookDao = null;
		System.out.println("BookDAOTest.initExpensiveResource().tearDown");
	}

	@AfterClass
	public static void initExpensiveResource() {
		System.out.println("BookDAOTest.initExpensiveResource().destroy");
	}
}
