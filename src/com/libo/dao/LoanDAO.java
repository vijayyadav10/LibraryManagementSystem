package com.libo.dao;

import java.util.List;

import com.libo.beans.Loan;

public interface LoanDAO {
	void addLoan();

	Object removeLoan();
	
	List<Loan> getLoanedList();
}
