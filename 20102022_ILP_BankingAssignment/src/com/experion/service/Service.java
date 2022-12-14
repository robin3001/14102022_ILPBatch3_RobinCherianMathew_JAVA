package com.experion.service;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.experion.entity.Account;
import com.experion.entity.Customers;
import com.experion.entity.SavingMaxAccount;

public class Service {

	public static boolean checkCustomerExist(ArrayList<Customers> customerList, String customerId) {
		for (Customers customers : customerList) {
			if(customerId == customers.getCustomerId()) {
				return true;
			}
		}
		return false;
	}

	public static Account createAccount(String accounts) {
		
		//To get an random account number
		Random rand = new Random();
		int accountNumber = rand.nextInt(1000);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Customer Id: ");
		scanner.nextLine(); // Clear the buffer
		String customerId = scanner.nextLine();
 		System.out.println("Enter Customer Name: ");
 		String customerName = scanner.nextLine();
		 
		Account account = new SavingMaxAccount(accountNumber,accounts,0);
		
		
//		Customers customer = new Customers(customerId,customerName,"");
		
		System.out.println("Account is active.!!!!!! ");
		
		return account;
	}
	


	public static String customerDetails(ArrayList<Customers> customerList, String customerId) {
		
		for (Customers customers : customerList) {
			if(customerId == customers.getCustomerId()) {
				return customers.getCustomerName();
			}
		}
		return null;	
	}

	public static void displayCustomerDetails(ArrayList<Customers> customerList) {

		for (Customers customers : customerList) {
			System.out.println("Id : "+" "+customers.getCustomerId()+"Name : "+customers.getCustomerName()+" "+ "Account : "+customers.getCustomerAccounts());
		}
		
	}

}
