package com.libo.dao;

import java.util.List;

import com.libo.beans.Loan;

public interface LoanDAO {
	void addLoan(int studentId, String studentName, String bookName);

	Object removeLoan();
	
	List<Loan> getLoanedList();
}
