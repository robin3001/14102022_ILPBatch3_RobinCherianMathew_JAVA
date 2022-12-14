package com.bank.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.bank.entity.Account;
import com.bank.entity.Customer;

public class Service {
	static Customer customer = null;
	public static Account createAccount(String accountType) {
		
		Account account = null;
		if(accountType.compareTo("Savings Max Account")==0)
		{
			account = new Account("Savings Max Account",1000);			
		}
		else if(accountType.compareTo("Current Account")==0)
		{
			account = new Account("Current Account",1000);
		}
		else if(accountType.compareTo("Loan Account")==0)
		{
			account = new Account("Loan Account",0);
		}else {
			System.out.println("Invalid Accound");
		}
		
		return account;
		
		
	}
	
	public static Customer createCustomer(ArrayList<Account> accountList) {
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine(); // Clear the buffer
			System.out.println("Enter Customer Id: ");
			String customerId = scanner.nextLine();
	 		System.out.println("Enter Customer Name: ");
	 		String customerName = scanner.nextLine();
			
			customer = new Customer(customerId,customerName,accountList);
	
		
		return customer;
	}
	
	public static void depositMoney(String account, Customer customer) {
		
		ArrayList<Account>customerAccountList = new ArrayList<Account>();
		Scanner scanner = new Scanner(System.in);
		customerAccountList = customer.getAccountList();
		
//		System.out.println("Account Name " + "     "+"Account Balance");
//		for(Account account : customerAccountList)
//			System.out.println(account.getProductName() + "     "+ account.getAccountBalance());
			
//		System.out.println("Select the account you want to deposit money - ");
//		String account = scanner.nextLine();
		System.out.println("Enter the amount to be deposited - ");
		
		double depositMoney = scanner.nextDouble();
		for(Account selectedAccount : customerAccountList)
			if(selectedAccount.getProductName().compareTo(account)==0)
			{
				
				selectedAccount.setAccountBalance(selectedAccount.getAccountBalance() + depositMoney);
			}
		
		
	}
	public static void displayCustomerAccount(Customer customer, ArrayList<Account> accountList) {
		
		System.out.println(customer.getCustomerName()+" has the following accounts: ");
		for(Account account : accountList)
			System.out.println(" "+ account.getProductName());
			
		
	}
	
	
	
	public static void displayAccountDetails(Customer customer,ArrayList<Account> accountList) {
		
		System.out.println("*************************Customer-Account Details****************");
		System.out.println("Customer id "+"   "+"Customer Name "+"   "+"Account Name " +"   "+"Account Balance");
		System.out.println("************************************************");
		
		for(Account account : accountList) {
			System.out.println("  "+customer.getCustomerId()+ "     "+customer.getCustomerName() + "     "+account.getProductName() + "     "+ account.getAccountBalance());
		}
		
	}

	public static boolean checkCustomerExist(String customerId) {
		
		boolean result = false;
		
		
		
		return result;
	}

	public static void withdrawMoney(String account, Customer customer) {
		
		ArrayList<Account>customerAccountList = new ArrayList<Account>();
		Scanner scanner = new Scanner(System.in);
		customerAccountList = customer.getAccountList();
		
		System.out.println("Enter the amount to be withdraw - ");
		
		double withdrawMoney = scanner.nextDouble();
		for(Account selectedAccount : customerAccountList)
			if(selectedAccount.getProductName().compareTo(account)==0)
			{
				
				selectedAccount.setAccountBalance(selectedAccount.getAccountBalance() - withdrawMoney);
			}	
		
	}


}
