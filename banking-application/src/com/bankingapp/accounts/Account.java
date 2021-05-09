package com.bankingapp.accounts;

public abstract class Account implements IBaseRate {
	
	// Instance variables
	protected String name, acctNumber, ssn;
	protected double balance, rate;
	
	// Uniqe 4-digit number used for each Account number
	private static int index = 1000;
	
	
	// Constructor
	public Account(String name, String ssn, double initialDeposit) {
		this.name = name;
		this.ssn = ssn;
		balance = initialDeposit;
		acctNumber = setAccountNumber();
	}
	
	
	// Creates a unique account number
	private String setAccountNumber() {
		String lastTwoDigitsOfSsn = ssn.substring(ssn.length() - 2, ssn.length());
		int randomThreeDigitNumber = (int)Math.round(Math.random() * (999 - 100) + 100); 
		index++;
		
		return lastTwoDigitsOfSsn + index + randomThreeDigitNumber;
	}
	
	
	// Methods to handle banking transactions
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		if (balance - amount >= 0) {
			balance -= amount;
			System.out.println("WITHDRAW SUCCESSFUL\nREMAINING BALANCE: $" + String.format("%.2f", balance));
		}
		else {
			System.out.println("INSUFFICIENT FUNDS\nCURRENT BALANCE: $" + String.format("%.2f", balance));
		}
	}
	
	public void displayAccountInfo() {
		System.out.println(
				"NAME: " + name +
				"\nACCOUNT NUMBER: " + acctNumber +
				"\nBALANCE: $" + String.format("%.2f", balance));
	}
	
}