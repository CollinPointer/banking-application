package com.bankingapp.accounts;

public abstract class Account implements IBaseInterestRate {
	
	// Instance variables
	private String name, ssn;
	private double balance;
	protected String acctNumber;
	protected double rate;
	
	// Uniqe 4-digit number used for each Account number
	private static int index = 1000;
	
	
	// Constructor
	public Account(String name, String ssn, double initialDeposit) {
		this.name = name;
		this.ssn = ssn;
		balance = initialDeposit;
		acctNumber = setAccountNumber();
		setInterestRate();
	}
	
	
	// Getter methods
	public String getName() {
		return name;
	}

	public String getAcctNumber() {
		return acctNumber;
	}

	public String getSsn() {
		return ssn;
	}

	public double getBalance() {
		return balance;
	}

	public double getRate() {
		return rate;
	}


	// Abstract method used to set the rates of checking and savings accounts
	protected abstract void setInterestRate();
	
	// Adds the accrued compund interest to the balance
	public void compound() {
		double accruedInterest = balance * (rate / 100);
		balance += accruedInterest;
		System.out.println("ACCRUED INTEREST: $" + String.format("%.2f", accruedInterest));
		displayBalance();
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
		System.out.println("DEPOSITING $" + String.format("%.2f", amount));
		displayBalance();
	}
	
	public void withdraw(double amount) {
		if (balance - amount >= 0) {
			balance -= amount;
			System.out.println("WITHDRAW SUCCESSFUL");
			displayBalance();
		}
		else {
			System.out.println("INSUFFICIENT FUNDS");
			displayBalance();
		}
	}
	
	public void transer(Account toAccount, double amount) {
		if (balance - amount >= 0) {
			balance -= amount;
			toAccount.balance += amount;
			System.out.println("$" + String.format("%.2f", amount) + " TRANSFERRED TO ACCOUNT# " +
					toAccount.acctNumber + " SUCCESSFULLY");
		}
		else {
			System.out.println("INSUFFICIENT FUNDS");
			displayBalance();
		}
		
	}
	
	public void displayBalance() {
		System.out.println("YOUR CURRENT BALANCE IS: $" + String.format("%.2f", balance));
	}
	
	// Displays the account information
	public void displayAccountInfo() {
		System.out.println(
				"NAME: " + name +
				"\nACCOUNT NUMBER: " + acctNumber +
				"\nBALANCE: $" + String.format("%.2f", balance) +
				"\nRATE: " + String.format("%.2f", rate) + "%");
	}
	
}