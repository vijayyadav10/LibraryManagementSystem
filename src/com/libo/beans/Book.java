package com.libo.beans;

public class Book {

	private String bookName;
	private String subject;
	private String authorName;
	private int pageNumber;
	private long price;

	Book() {
	}

	public Book(String bookName, String subject, String authorName, int pageNumber, long price) {
		super();
		this.bookName = bookName;
		this.subject = subject;
		this.authorName = authorName;
		this.pageNumber = pageNumber;
		this.price = price;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", subject=" + subject + ", authorName=" + authorName + ", pageNumber="
				+ pageNumber + ", price=" + price + "]";
	}

}
