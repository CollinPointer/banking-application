package com.bankingapp;

import java.util.LinkedList;
import java.util.List;

import com.bankingapp.accounts.Account;
import com.bankingapp.accounts.Checking;
import com.bankingapp.accounts.Savings;
import com.bankingapp.utilities.CSV;

public class BankAccountApp {

	public static void main(String[] args) {
		
		List<Account> accounts = new LinkedList<Account>();
		
		String file = "/Users/collin/Desktop/NewBankAccounts.csv";
		List<String[]> newAccounts = CSV.read(file);
		
		for (String[] account : newAccounts) {
			String name = account[0];
			String ssn = account[1];
			String accountType = account[2];
			double initialDeposit = Double.parseDouble(account[3]);
			
			if (accountType.equals("Checking")) {
				accounts.add(new Checking(name, ssn, initialDeposit));
			}
			else if (accountType.equals("Savings")) {
				accounts.add(new Savings(name, ssn, initialDeposit));
			}
			else {
				System.out.println("ERROR READING ACCOUNT TYPE");
			}
		}
		
		for (Account acc : accounts) {
			acc.displayAccountInfo();
			System.out.println("\n***********************************");
		}
		
	}
		
}