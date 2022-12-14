package com.bank.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.bank.entity.Account;
import com.bank.entity.Customer;
import com.bank.service.MisService;
import com.bank.service.Service;

public class BankUtility {

	public static void main(String[] args) {

//		String customerId;
//		String customerName;
//		char choice;
		char countinueChoice;
		int serviceChoice;
		String accountChoice;
		String customerId;
		Scanner scanner = new Scanner(System.in);
		System.out.println("*****************WELCOME TO BANK******************");

		ArrayList<Account> accountList = new ArrayList<Account>();
		
		Customer customer = null;

		char choice;
		do {
			System.out.println("1.Create Account\n2.Manage Account\n3.Display Account Details\n4.Exit ");
			System.out.println("Enter Your Choice: ");
			int mainChoice = scanner.nextInt();

			switch (mainChoice) {
			case 1:
				System.out.println("Check your Customerid here: ");
				scanner.nextLine(); // Clear the buffer
				customerId = scanner.nextLine();
//				if (Service.checkCustomerExist(customerId) != true) {
				if(customer == null) {
					System.out.println("Customerd id is not available.You can create a new Account ");
					System.out.println("********Accounts Available***********");
					
					String customerAccountChoice = MisService.enterAccountChoice();
					accountList.add(Service.createAccount(customerAccountChoice));
					
					customer = Service.createCustomer(accountList);
					System.out.println(customerAccountChoice + "  created for "+customer.getCustomerName());
					System.out.println("Account is active.!!!!!!");
					
				} else {
					System.out.println("Customer ID Already exist");
						Service.displayCustomerAccount(customer,accountList);
						System.out.println("You can create a new Account ");
						String customerAccountChoice = MisService.enterAccountChoice();
						accountList.add(Service.createAccount(customerAccountChoice));
						
//						customer = Service.createCustomer(accountList);
						System.out.println(customerAccountChoice + "  created for "+customer.getCustomerName());
						System.out.println("Account is active.!!!!!!");
				}
				break;

			case 2:
					System.out.println("Enter Customer id: ");
					scanner.nextLine(); // Clear the buffer
					
					customerId = scanner.nextLine();
					if (Service.checkCustomerExist(customerId) == true) {
						System.out.println("Customer Not Exist");
					} else {
						do {
							Service.displayCustomerAccount(customer,accountList);
		//					String customerAccountChoice = MisService.enterAccountChoice();
							System.out.println("Select Account: ");
							scanner.nextLine(); // Clear the buffer
							accountChoice = scanner.nextLine();
		
							// If Customer Select Savings Account
							if (accountChoice.compareTo("Savings Max Account") == 0) {
								do {
									System.out.println("1. Deposit\n2. Withdraw\n3.Display Accounts");
		
									serviceChoice = scanner.nextInt();
									switch (serviceChoice) {
									case 1:
										Service.depositMoney("Savings Max Account", customer);		
										break;
									case 2:
					           			Service.withdrawMoney("Savings Max Account", customer);
			           					break;
									case 3:
										Service.displayAccountDetails(customer,accountList);
		           						break;
									}
		
									System.out.println("Do you want to continue in Savings Max Account Account: y/n \" ");
									countinueChoice = scanner.next().charAt(0);
								} while (countinueChoice == 'y');
							}
				
							// If Customer Select Current Account
							else if (accountChoice.compareTo("Current Account") == 0 ) {
								do {
					           				System.out.println("1. Deposit\n2. Withdraw\n3.Display Accounts");
					           				serviceChoice = scanner.nextInt();
					           				switch(serviceChoice) {
						           				case 1: Service.depositMoney("Current Account", customer);
						           					break;
						           				case 2:
						           					Service.withdrawMoney("Current Account", customer);
						           					break;
						           				case 3:
						           					Service.displayAccountDetails(customer,accountList);
					           						break;
					           				}
					           				System.out.println("Do you want to continue in Current Account: y/n ");
					           				countinueChoice = scanner.next().charAt(0);
								} while (countinueChoice == 'y');
		
							} // If Customer Select Loan Account
							else if (accountChoice.compareTo("Loan Account") == 0 ) {
								do {
					           				System.out.println("1. Deposit\n2. Withdraw\n3.Display Accounts");
					           				serviceChoice = scanner.nextInt();
					           				switch(serviceChoice) {
					           				case 1: Service.depositMoney("Loan Account", customer);
					           					break;
					           				case 2:
							           			Service.withdrawMoney("Loan Account", customer);
					           					break;
					           				case 3: Service.displayAccountDetails(customer,accountList);
					           						break;
					           				}
					           				System.out.println("Do you want to continue in Loan Account: y/n ");
					           				countinueChoice = scanner.next().charAt(0); 
					           	}while (countinueChoice == 'y');
		
							} else {
								System.out.println("There is no Accounts like " + accountChoice);
							}
							System.out.println("Do you want to continue with your account (y/n): - ");
							choice = scanner.next().charAt(0);
						}while(choice=='y');
					}
				
				break;		
			case 3: Service.displayAccountDetails(customer,accountList);
					break;				
			default: 
					break;
				
			}
			System.out.println("Do you want to continue to main menu (y/n): - ");
			choice = scanner.next().charAt(0);
			
		} while (choice == 'y');

		System.out.println("Thank You");
	}

}
