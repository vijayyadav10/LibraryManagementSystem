package com.libo.dao;

import java.util.List;
import java.util.Scanner;

import com.libo.beans.Book;
import com.libo.beans.Library;

public class BookDAOImpl implements BookDAO {

	Library lib;
	Scanner in = new Scanner(System.in);

	public BookDAOImpl(Library lib) {
		this.lib = lib;
	}
	
	@Override
	public void addBook() {
		System.out.println("Enter Book Details");
		System.out.println("In Following Order: Book Name, Subject Name, Author Name, Page No, Price");
		System.out.println("Enter Book Name");
		String bookName = in.nextLine();
		String subjectName = in.nextLine();
		String authorName = in.nextLine();
		int pageNumber = in.nextInt();
		long price = in.nextLong();

		Book book = new Book(bookName, subjectName, authorName, pageNumber, price);

		System.out.println(bookName);

		List<Book> bookShelf = lib.getBookshell();
		bookShelf.add(book);
		lib.setBookshell(bookShelf);
		
	}

	@Override
	public Object removeBook() {
		System.out.println("Enter book name to delete from book shelf");

		String bookName = in.nextLine();

		List<Book> bookShelf = lib.getBookshell();

		for (Book book : bookShelf) {
			if (bookName.equals(book.getBookName())) {
				bookShelf.remove(book);
				lib.setBookshell(bookShelf);
				return book;
			}
		}
		return "No Such Book Found";
	}

	@Override
	public List<Book> getBooks() {
		return lib.getBookshell();
	}

	

}
