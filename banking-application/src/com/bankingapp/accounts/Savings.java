package com.bankingapp.accounts;

public class Savings extends Account {
	
	// Instance variables
	private int safetyDepositBoxId, safetyDepositBoxCode;
	
	
	// Constructor to initialize Savings account properties
	public Savings(String name, String ssn, double deposit) {
		super(name, ssn, deposit);
		super.acctNumber = "2" + super.acctNumber; // adds 2 to beginning of account number if savings account
		setSafetyDepositBox();
	}
	
	
	// Set the interest rate for savings account (base rate - .25)
	@Override
	public void setInterestRate() {
		super.rate = getBaseInterestRate() - .25;
	}
	
	// Creates a safety deposit box using a 3-digit ID and a 4-digit code
	private void setSafetyDepositBox() {
		// Random 3-digit number
		safetyDepositBoxId = (int)(Math.random() * Math.pow(10, 3));
		// Random 4-digit number
		safetyDepositBoxCode = (int)(Math.random() * Math.pow(10, 4));
	}
	
	@Override
	public void displayAccountInfo() {
		System.out.println("ACCOUNT TYPE: Savings\n");
		super.displayAccountInfo();
		System.out.println("\nACCOUNT FEATURES:"
				+ "\n   SAFETY DEPOSIT BOX ID: " + safetyDepositBoxId 
				+ "\n   SAFETY DEPOSIT BOX CODE: " + safetyDepositBoxCode);
	}
	
}