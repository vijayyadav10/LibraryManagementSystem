package com.libo.services.impl;

import java.util.List;
import java.util.Scanner;

import com.libo.beans.Book;
import com.libo.beans.Library;
//import com.libo.beans.services.EntityBook;
//import com.libo.beans.services.LibraryImpl;
import com.libo.dao.BookDAO;
import com.libo.services.BookServices;

public class BookServiceImpl implements BookServices {

	Library lib = Library.getObject();
	BookDAO bookDao;

	Scanner in = new Scanner(System.in);

	public BookServiceImpl(BookDAO bookDao) {
		
		this.bookDao = bookDao;
	}

	@Override
	public Book addBook(String bookName, String subjectName, String authorName, int pageNumber, long price) {
//		String bookName = in.nextLine();
//		String subjectName = in.nextLine();
//		String authorName = in.nextLine();
//		int pageNumber = in.nextInt();
//		long price = in.nextLong();
		return this.bookDao.addBook(bookName,subjectName, authorName, pageNumber, price);
		
	}

	@Override
	public Object removeBook(String bookName) {
		return this.bookDao.removeBook(bookName);
	}

	@Override
	public List<Book> getBooks() {

		return this.bookDao.getBooks();
//		return lib.getBookshell();
	}

	@Override
	public Object SearchBookByName(String bookName) {

//		System.out.println("Enter book name to search from book shelf");

//		String bookName = in.nextLine();
//		System.out.println(bookName);
		List<Book> bookShelf = lib.getBookshell();

		for (Book book : bookShelf) {
			if (bookName.equals(book.getBookName())) {
				return book;
			}
		}

		return "No" + bookName + "Book Found";
	}

	@Override
	public Object SearchBookByAuthor(String authorName) {

//		System.out.println("Enter author name to search from book shelf");

//		String authorName = in.nextLine();

		List<Book> bookShelf = lib.getBookshell();

		for (Book book : bookShelf) {
			if (authorName.equals(book.getAuthorName())) {
				return book;
			}
		}

		return "No" + authorName + "Book Found";

	}

	@Override
	public void checkBookOutOfStock() {
		// TODO Auto-generated method stub
		System.out.println(lib.getBookOutOfStock());
	}

}
