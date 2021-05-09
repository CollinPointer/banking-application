package com.bankingapp.accounts;

public class Savings extends Account {
	
	
	// Constructor
	public Savings(String name, String ssn, double deposit) {
		super(name, ssn, deposit);
		acctNumber = "2" + acctNumber; // adds 2 to beginning of account number if savings account
	}
	
	
	@Override
	public void displayAccountInfo() {
		System.out.println("ACCOUNT TYPE: Savings\n");
		super.displayAccountInfo();;
	}
	
}