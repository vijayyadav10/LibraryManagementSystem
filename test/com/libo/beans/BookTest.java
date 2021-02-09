package com.libo.beans;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public class BookTest {

	Book book;

	@Before
	public void setUp() {
		book = new Book("ruby", "rubyonrails", "rubex", 300, 500);
	}

	@Test
	public void testGetBookName() {
		assertEquals("failure: name should be ruby", "ruby", book.getBookName());
		assertNotEquals("failure: name should be anything leaving ruby", "python", book.getBookName());
		assertNotNull("failure: name should note be null", book.getBookName());
	}

	@Test
	public void testBook() {
		Book copyBook = new Book("ruby", "rubyonrails", "rubex", 300, 500);
		assertSame("failure: something went wrong the object should be same", copyBook.getAuthorName(),
				book.getAuthorName());
		assertSame("failure: something went wrong the object should be same", copyBook.getBookName(),
				book.getBookName());
		assertEquals("failure: something went wrong the object should be same", copyBook.getPageNumber(),
				book.getPageNumber());
		assertEquals("failure: something went wrong the object should be same", copyBook.getPrice(), book.getPrice());
		assertSame("failure: something went wrong the object should be same", copyBook.getSubject(), book.getSubject());
	}

	// @Test
//	public void testBookStringStringStringIntLong() {
//		fail("Not yet implemented");
//	}
//
//
//	@Test
//	public void testSetBookName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetSubject() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSetSubject() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetAuthorName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSetAuthorName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetPageNumber() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSetPageNumber() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetPrice() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSetPrice() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testToString() {
//		fail("Not yet implemented");
//	}

}
