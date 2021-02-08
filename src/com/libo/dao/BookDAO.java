package com.libo.dao;

import java.util.List;

import com.libo.beans.Book;

public interface BookDAO {

	void addBook();

	Object removeBook();
	
	List<Book> getBooks();

//	public Object SearchBookByName();

//	public Object SearchBookByAuthor();
	
//	void checkBookOutOfStock();
	
}
