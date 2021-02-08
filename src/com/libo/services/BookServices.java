package com.libo.services;

import java.util.List;

import com.libo.beans.Book;
import com.libo.beans.Library;

//import com.libo.entity.EntityBook;
//import com.libo.entity.LibraryImpl;

public interface BookServices {

	void addBook();

	Object removeBook();
	
	List<Book> getBooks();

	public Object SearchBookByName();

	public Object SearchBookByAuthor();
	
	void checkBookOutOfStock();
}
