package com.bankingapp.accounts;

public class Checking extends Account {
	
	// Instance variables
	private int debitCardNumber, debitCardPin;
	
	
	// Constructor to initialize Checking account properties
	public Checking(String name, String ssn, double deposit) {
		super(name, ssn, deposit);
		super.acctNumber = "1" + super.acctNumber; // adds 1 to beginning of account number if checking account
		setDebitCard();
	}
	
	
	// Set the interest rate for checking account (15% of base rate)
	@Override
	public void setInterestRate() {
		super.rate = getBaseInterestRate() * .15;
	}
	
	// Creates a debit card using a 12-digit number and 4-digit pin
	private void setDebitCard() {
		// Random 12-digit debit card number
		debitCardNumber = (int)(Math.random() * Math.pow(10,  12));
		// Random 4-digit pin
		debitCardPin = (int)(Math.random() * Math.pow(10,  4));
	}
	
	@Override
	public void displayAccountInfo() {
		System.out.println("ACCOUNT TYPE: Checking\n");
		super.displayAccountInfo();
		System.out.println("\nACCOUNT FEATURES:"
				+ "\n   DEBIT CARD NUMBER: " + debitCardNumber 
				+ "\n   DEBIT CARD PIN: " + debitCardPin);
	}
	
}