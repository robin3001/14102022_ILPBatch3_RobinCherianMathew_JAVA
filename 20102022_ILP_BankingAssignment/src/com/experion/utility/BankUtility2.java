package com.experion.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.experion.entity.Account;
import com.experion.entity.Customers;
import com.experion.service.Service;

public class BankUtility2 {

	public static void main(String[] args) {
		
		 	int mainChoice;
		 	String customerId;
		 	String customerName;
		 	int accountChoice;
		 	int serviceChoice;
		 	String stringAccountChoice;
		 	boolean tempExist;
		 	double amount;
		 	char countinueChoice;
	
		 	Scanner scanner = new Scanner(System.in);
			System.out.println("*****************WELCOME TO BANK******************");
			
	
			ArrayList<Customers> customerList=new ArrayList<Customers>();
			ArrayList<Account> accountList=new ArrayList<Account>();
	        do {
	            System.out.println("1. Create Account  2. Manage Account  3. Display");
	            System.out.println("Enter your choice: ");
	            mainChoice = scanner.nextInt();
	            
	            switch(mainChoice)
	            { 	
	            case 1 : System.out.println("Enter Customer id: ");
	            		 customerId = scanner.nextLine();
	            		 scanner.nextLine(); // Clear the buffer
	            		 tempExist = Service.checkCustomerExist(customerList,customerId);
//	            		 If Customer exist or not
		            		if(tempExist != true){
		            			System.out.println("Customer Id not available.Create a new Account ");
		            			System.out.println("******Accounts Available***********");
		            			System.out.println("1. Savings Max Account 2. Current Account 3. Loan Account ");
		            			accountChoice = scanner.nextInt();
		            			switch(accountChoice) {
			            			case 1: 
			            					accountList.add(Service.createAccount("Savings Account"));
				               		 		Service.displayCustomerDetails(customerList);
				               		 		
				               		 		break;
			            			case 2:	
//			            					accountList.add(Service.createAccount());
					           		 		break;
			            			case 3:	
//			            					accountList.add(Service.createAccount());
					           		 		break;
			            			}
			                  	 
			            	}else {
			            		System.out.println("Customer Already Exists");
			            	}
		            	break;
	            				 
	            case 2: System.out.println("Enter Customer id: ");
	   		 			customerId = scanner.nextLine();
	   		 			scanner.nextLine(); // Clear the buffer
	   		 			tempExist = Service.checkCustomerExist(customerList,customerId);
			       		//If Customer exist or not
		           		if(tempExist != true){
		           			System.out.println("Customer Not Exist");
		           		}else {
//			           			customerList.get(Service.customerDetails(customerId));
		           				String name = Service.customerDetails(customerList,customerId);
			           			System.out.println(name+" has the following accounts: ");
			           			
			           				//Display Accounts
			           				System.out.println("");
			           				
			           			System.out.println("Enter your Choice: ");
			           			stringAccountChoice = scanner.nextLine();
			           			//If Customer Select Savings Account
			           			if(stringAccountChoice == "Savings Max Account") {
			           				do {
				           				System.out.println("1. Deposit 2. Withdraw 3.Display Accounts");
				           				serviceChoice = scanner.nextInt();
				           				switch(serviceChoice) {
				           				case 1:
				           					System.out.print("Enter the amount to be deposited: ");
				           					amount = scanner.nextDouble();
				           					break;
				           				case 2:
				           					System.out.print("Enter the amount to be Withdrawed: ");
				           					amount = scanner.nextDouble();
				           					break;
				           				case 3:
				           					///Display
				           					break;
				           				}
				           				
				           				System.out.println("Do you want to continue: y/n ");
				           				countinueChoice = scanner.next().charAt(0);
				           			} while (countinueChoice == 'y');
			           			}
			           			//If Customer Select Current Account
			           			else if(stringAccountChoice == "Current Account") {
			           				do {
				           				System.out.println("1. Deposit 2. Withdraw 3.Display Accounts");
				           				serviceChoice = scanner.nextInt();
				           				switch(serviceChoice) {
				           				case 1:
				           					System.out.print("Enter the amount to be deposited: ");
				           					amount = scanner.nextDouble();
				           					break;
				           				case 2:
				           					System.out.print("Enter the amount to be Withdrawed: ");
				           					amount = scanner.nextDouble();
				           					break;
				           				case 3:
				           					///Display
				           					break;
				           				}
				           				System.out.println("Do you want to continue: y/n ");
				           				countinueChoice = scanner.next().charAt(0);
			           				} while (countinueChoice == 'y');
			           				
			           			}//If Customer Select Loan Account
			           			else if(stringAccountChoice == "Loan Account") {
			           				do {
				           				System.out.println("1. Deposit 2. Withdraw 3.Display Accounts");
				           				serviceChoice = scanner.nextInt();
				           				switch(serviceChoice) {
				           				case 1:
				           					System.out.print("Enter the amount you have to deposit: ");
				           					amount = scanner.nextDouble();
				           					break;
				           				case 2:
				           					System.out.print("Enter the due amount you want to take: ");
				           					amount = scanner.nextDouble();
				           					break;
				           				case 3:
				           					///Display
				           					break;
				           				}
				           				System.out.println("Do you want to continue: y/n ");
				           				countinueChoice = scanner.next().charAt(0);
				           				
			           				} while (countinueChoice == 'y');
			           				
			           			}else {
			           				System.out.println("There is no Accounts like "+stringAccountChoice);
			           			}
		           			}
		           		break;
	
	            case 3: Service.displayCustomerDetails(customerList);
//	            	System.out.println("Thank You");
	            		break;
	            		
	            default: System.out.println("Invalid Choice");
	            		break;
	            		
	            }
	            
	        	System.out.println("Do you want to continue: y/n ");
				countinueChoice = scanner.next().charAt(0);
			} while (countinueChoice == 'y');
       }		
}


