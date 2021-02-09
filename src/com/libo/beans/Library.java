package com.libo.beans;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Library {

	static Library obj = new Library(); 
	
	// Object realtion ship
	private List<Book> bookshell = new ArrayList<Book>();
	private List<Student> studentList = new ArrayList<Student>();

	private List<Loan> bookIssuedList = new ArrayList<Loan>();

	private Queue<String> bookOutOfStock = new LinkedList<String>();

	private List<User> users = new ArrayList<User>();
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Queue<String> getBookOutOfStock() {
		return bookOutOfStock;
	}

	public void setBookOutOfStock(Queue<String> bookOutOfStock) {
		this.bookOutOfStock = bookOutOfStock;
	}

	private Library() {
		bookshell.add(new Book("java", "cs", "tom", 100, 20));
		bookshell.add(new Book("f#", "computer programming", "mark", 200, 40));
		bookshell.add(new Book("perl", "coding with perl", "john mike", 200, 270));
		bookshell.add(new Book("flutter", "build muli platform app with flutter", "jems tomas", 300, 370));
		bookshell.add(new Book("python", "make use of python", "tonny", 300, 370));
		
		bookOutOfStock.add("mysql");
	}

	public static Library getObject() {
		return obj;
	}
	
	public List<Book> getBookshell() {
		return bookshell;
	}

	public void setBookshell(List<Book> bookshell) {
		this.bookshell = bookshell;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public List<Loan> getBookIssuedList() {
		return bookIssuedList;
	}

	public void setBookIssuedList(List<Loan> bookIssuedList) {
		this.bookIssuedList = bookIssuedList;
	}

	@Override
	public String toString() {
		return "Library [bookshell=" + bookshell + ", studentList=" + studentList + ", bookIssuedList=" + bookIssuedList
				+ "]";
	}

}

//lib has book
//lib has student