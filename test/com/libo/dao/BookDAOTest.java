package com.libo.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.libo.beans.Book;

public class BookDAOTest {

	private BookDAO bookDao;
	private List<Book> bookList;

	@BeforeClass
	public static void destroyExpensiveResource() {
		System.out.println("BookDAOTest.destroy");
	}

	@Before
	public void setUp() {
		this.bookDao = new BookDAOImpl();
	}

	@Test
	public void TestGetBooks() {
		this.bookList = this.bookDao.getBooks();
		assertNotNull("failure: book list should  not be null/empty", this.bookList);
	}

	@Test
	public void Test_AddBook() {
		assertTrue("failure: the size should be same as actual size", bookDao.getBooks().size() == 5);
		bookDao.addBook("wordpress", "web desing", "vijay yadav", 200, 250);
		assertTrue("failure: the size should be same as actual size", bookDao.getBooks().size() == 6);
	}

	@Test
	public void TestAddBook_EmptyBookName_ReturnNull() {
		assertNull(bookDao.addBook("", "web desing", "vijay yadav", 200, 3));
	}

	@Test
	public void TestAddBook_FreeAmount_ReturnNull() {
		assertNull(bookDao.addBook("", "web desing", "vijay yadav", 200, 3));
	}

	@Test
	public void TestAddBook_ZeroPages_ReturnNull() {
		assertNull(bookDao.addBook("", "web desing", "vijay yadav", 200, 3));
	}

	@Test
	public void TestRemoveBook_UpdateSizeOfList() {
		assertTrue("failure: the size should be same as actual size", bookDao.getBooks().size() == 6);
		bookDao.removeBook("java");
		assertTrue("failure: the size should be 1 less then actual size", bookDao.getBooks().size() == 5);
	}

	@Test
	public void TestRemoveBook_BookNameThatNotExists_NoSuchBookFound() {
		Object result = bookDao.removeBook("flask");
		assertSame("No Such Book Found", result);
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
