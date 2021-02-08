package com.libo.beans;

import java.util.Date;

public class Loan {
	int studentId;
	String studentName;
	String bookName;
	Date issuedDate;
	Date dueDate;

	public Loan(int studentId, String studentName, String bookName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.bookName = bookName;
		this.issuedDate = new Date();

		long ltime = this.issuedDate.getTime() + 5 * 24 * 60 * 60 * 1000;
		this.dueDate = new Date(ltime);

	}

	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Override
	public String toString() {
		return "Loan [studentId=" + studentId + ", studentName=" + studentName + ", bookName=" + bookName + "]";
	}

}
