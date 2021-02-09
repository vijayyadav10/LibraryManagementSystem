package com.libo.services;

import java.util.List;

import com.libo.beans.Book;
import com.libo.beans.Library;

//import com.libo.entity.EntityBook;
//import com.libo.entity.LibraryImpl;

public interface BookServices {


	Book addBook(String bookName, String subjectName, String authorName, int pageNumber, long price);

	Object removeBook(String bookName);
	
	List<Book> getBooks();

	public Object SearchBookByName(String bookName);

	public Object SearchBookByAuthor(String authorName);
	
	void checkBookOutOfStock();
}
