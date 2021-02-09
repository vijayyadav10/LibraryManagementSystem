package com.libo.dao;

import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import com.libo.beans.Book;
import com.libo.beans.Library;
import com.libo.beans.Loan;

public class LoanDAOImpl implements LoanDAO {

	Library lib = Library.getObject();
	Scanner in = new Scanner(System.in);

	public LoanDAOImpl() {
	}

	@Override
	public void addLoan(int studentId, String studentName, String bookName) {
//		System.out.println("Enter you Student Id and Student Name and Book Name");
//
//		int studentId = in.nextInt();
//		in.nextLine();
//		String studentName = in.nextLine();
//
//		String bookName = in.nextLine();

		Loan loan = new Loan(studentId, studentName, bookName);

		List<Book> bookShell = lib.getBookshell();

		for (Book book : bookShell) {

			if (bookName.equals(book.getBookName())) {
				List<Loan> loanListed = lib.getBookIssuedList();
				loanListed.add(loan);
				break;
			}

			if (!bookName.equals(book.getBookName())) {
				Queue<String> bookOutOfStock = lib.getBookOutOfStock();
				bookOutOfStock.add(bookName);
				lib.setBookOutOfStock(bookOutOfStock);
				System.out.println("Sorry For Inconvenience Once book is read be will contact you");
				break;
			}

		}

	}

	@Override
	public Object removeLoan() {
		List<Loan> loanListed = lib.getBookIssuedList();

		String bookName = "python";
		int studentId = 1;

		for (Loan loan : loanListed) {
			if (bookName.equals(loan.getBookName()) && studentId == loan.getStudentId()) {
				loanListed.remove(loan);
				System.out.println("Successfully removed" + loan);
				return loan;
			}
		}

		return "No such details found";
	}

	@Override
	public List<Loan> getLoanedList() {
		// TODO Auto-generated method stub
		return this.lib.getBookIssuedList();
	}

}
