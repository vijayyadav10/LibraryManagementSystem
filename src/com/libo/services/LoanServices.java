package com.libo.services;

import java.util.List;

import com.libo.beans.Loan;

public interface LoanServices {

	void addLoan();

	Object removeLoan();
	
	List<Loan> getLoanedList();
}
