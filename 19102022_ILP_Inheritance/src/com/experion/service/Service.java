package com.experion.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.experion.entity.Account;
import com.experion.entity.BankServices;
import com.experion.entity.Card;
import com.experion.entity.Product;

public class Service {

	public static Product createProduct() throws ParseException {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Product Code: ");
		String productCode = scanner.nextLine();
		System.out.println("Enter Product Name: ");
		String productName = scanner.nextLine();
		System.out.println("Enter Product Type: ");
		String productType = scanner.nextLine();
		

		Product product = new Product(productCode, productName, productType);

		return product;
	}
	

	public static void displayProductDetails(ArrayList<Product> productList) {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("SL NO" + "    " + "Product Code" + "    " + "Product Name" + "    " + "Product Description"
				+ "    " + "Product Price" + "Expiry Date" + "    " + "Active");

		for (Product product : productList) {
			System.out.println( "    " + product.getProductCode() + "    "
					+ product.getProductName() + "    " + product.getProductType() + "    ");

		}

	}
	
	

	
	
	public static Product createProduct(String productType) {
		
		ArrayList<BankServices> bankServices = new ArrayList<BankServices>();
		
		bankServices.add(new BankServices("SOB100","Online Banking"));
		bankServices.add(new BankServices("SMB200","Mobile Banking"));
		bankServices.add(new BankServices("SCB300","Cash Deposite"));
		
		Product product = null;
		
		if(productType.compareTo("Cards") == 0) {
			product = new Card("PRDMC100","Master Card","Cards","Master");
		}else if(productType.compareTo("Accounts") == 0) {
			product = new Account("PRDwSA100","Womens Savings Account","Account","Savings Account",bankServices);
		}
		
		return product;
	}

	

	public static void DisplayProductDetails(ArrayList<Product> productList) {
		
		Card card = null;
		Account account = null;
		System.out.println("Product Code "+"  "+"Product Name "+"  "+"Product Types "+"  "+"Accounts/Card"+"  "+"Banking Services");
		for(Product product : productList) {
			if(product instanceof Card) {
				card = (Card)product;
				System.out.println(card.getProductCode()+"  "+card.getProductName()+"  "+card.getProductType()+"  "+card.getCardType());
			}
			else if(product instanceof Account) {
				account = (Account)product;
				System.out.println(account.getProductCode()+"  "+account.getProductName()+"  "+account.getProductType()+"  "+account.getProductType());
			
				System.out.println("The list of services are given below ");
			for(BankServices bankServices : account.getBankServices())
				System.out.println(bankServices.getServiceName());
			}
		}
		
	}



}
