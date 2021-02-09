package com.libo.services.impl;

import java.util.List;
import java.util.Scanner;

import com.libo.beans.Library;
import com.libo.beans.Loan;
import com.libo.dao.LoanDAO;
import com.libo.services.LoanServices;

public class LoanServiceImpl implements LoanServices {

	LoanDAO loanDao;
	Library lib = Library.getObject();
	Scanner in = new Scanner(System.in);

	public LoanServiceImpl( LoanDAO loanDao) {
		this.loanDao = loanDao;
	}

	@Override
	public void addLoan(int studentId, String studentName, String BookName) {

		this.loanDao.addLoan(studentId, studentName, BookName);

	}

	@Override
	public Object removeLoan() {

		return loanDao.removeLoan();

	}

	@Override
	public List<Loan> getLoanedList() {
		return this.loanDao.getLoanedList();
	}

}
