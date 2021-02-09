package com.libo.dao;

import java.util.List;

import com.libo.beans.Book;

public interface BookDAO {

	Book addBook(String bookName, String subjectName, String authorName, int pageNumber, long price);

	Object removeBook(String bookName);
	
	List<Book> getBooks();

//	public Object SearchBookByName();

//	public Object SearchBookByAuthor();
	
//	void checkBookOutOfStock();
	
}
