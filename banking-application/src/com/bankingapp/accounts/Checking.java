package com.bankingapp.accounts;

public class Checking extends Account {
	
	
	// Constructor
	public Checking(String name, String ssn, double deposit) {
		super(name, ssn, deposit);
		acctNumber = "1" + acctNumber; // adds 1 to beginning of account number if checking account
	}
	
	
	@Override
	public void displayAccountInfo() {
		System.out.println("ACCOUNT TYPE: Checking\n");
		super.displayAccountInfo();
	}
	
}