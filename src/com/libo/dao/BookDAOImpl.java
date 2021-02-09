package com.libo.dao;

import java.util.List;
import java.util.Scanner;

import com.libo.beans.Book;
import com.libo.beans.Library;

public class BookDAOImpl implements BookDAO {

	Library lib = Library.getObject();
	Scanner in = new Scanner(System.in);

	public BookDAOImpl() {
	}
	
	@Override
	public Book addBook(String bookName, String subjectName, String authorName, int pageNumber, long price) {

		if(bookName.length() > 0 && subjectName != null && authorName != null && pageNumber > 0 && price > 0) {
			
			Book book = new Book(bookName, subjectName, authorName, pageNumber, price);
			
			System.out.println(bookName);
			
			List<Book> bookShelf = lib.getBookshell();
			bookShelf.add(book);
			lib.setBookshell(bookShelf);
			return book;
		}
		
		return null;
	}

	@Override
	public Object removeBook(String bookName) {
		

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
