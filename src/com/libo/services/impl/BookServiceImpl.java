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

	Library lib;
	BookDAO bookDao;

	Scanner in = new Scanner(System.in);

	public BookServiceImpl(Library lib, BookDAO bookDao) {
		this.lib = lib;
		this.bookDao = bookDao;
	}

	@Override
	public void addBook() {
//		System.out.println("Enter Book Details");
//		System.out.println("In Following Order: Book Name, Subject Name, Author Name, Page No, Price");
//		System.out.println("Enter Book Name");
//		String bookName = in.nextLine();
//		String subjectName = in.nextLine();
//		String authorName = in.nextLine();
//		int pageNumber = in.nextInt();
//		long price = in.nextLong();
//
//		Book book = new Book(bookName, subjectName, authorName, pageNumber, price);
//
//		System.out.println(bookName);
//
//		List<Book> bookShelf = lib.getBookshell();
//		bookShelf.add(book);
//		lib.setBookshell(bookShelf);
		this.bookDao.addBook();
	}

	@Override
	public Object removeBook() {
//		bookName = "f#";
//		System.out.println("Enter book name to delete from book shelf");
//
//		String bookName = in.nextLine();
//
//		List<Book> bookShelf = lib.getBookshell();
//
//		for (Book book : bookShelf) {
//			if (bookName.equals(book.getBookName())) {
//				bookShelf.remove(book);
//				lib.setBookshell(bookShelf);
//				return book;
//			}
//		}
//		return "No Such Book Found";
		return this.bookDao.removeBook();

	}

	@Override
	public List<Book> getBooks() {

		return this.bookDao.getBooks();
//		return lib.getBookshell();
	}

	@Override
	public Object SearchBookByName() {

		System.out.println("Enter book name to search from book shelf");

		String bookName = in.nextLine();
		System.out.println(bookName);
		List<Book> bookShelf = lib.getBookshell();

		for (Book book : bookShelf) {
			if (bookName.equals(book.getBookName())) {
				return book;
			}
		}

		return "No" + bookName + "Book Found";
	}

	@Override
	public Object SearchBookByAuthor() {

		System.out.println("Enter author name to search from book shelf");

		String authorName = in.nextLine();

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
