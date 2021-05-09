package com.bankingapp.accounts;

public interface IBaseInterestRate {

	// Default interest rate
	default double getBaseInterestRate() {
		return 2.50;
	}
	
}