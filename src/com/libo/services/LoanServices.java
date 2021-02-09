package com.libo.services;

import java.util.List;

import com.libo.beans.Loan;

public interface LoanServices {

	void addLoan(int studentId, String studentName, String BookName);

	Object removeLoan();
	
	List<Loan> getLoanedList();
}
