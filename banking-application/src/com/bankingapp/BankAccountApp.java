package com.bankingapp;

import com.bankingapp.accounts.Checking;
import com.bankingapp.accounts.Savings;

public class BankAccountApp {

	public static void main(String[] args) {
		
		var ch1 = new Checking("Collin Pointer", "321759087", 1000.00);
		ch1.displayAccountInfo();
		
		System.out.println("\n************************************\n");
		
		var sv1 = new Savings("Kyle Pointer", "890673421", 2500.00);
		sv1.displayAccountInfo();
		sv1.deposit(10);
		ch1.transer(sv1, 500);
		sv1.compound();
	}
		
}