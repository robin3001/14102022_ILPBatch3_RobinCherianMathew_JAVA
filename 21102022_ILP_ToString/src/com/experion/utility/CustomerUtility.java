package com.experion.utility;

import com.experion.entity.Customer;

public class CustomerUtility {

	public static void main(String[] args) {
		
		Customer customer = new Customer("C001","Robin");
		System.out.println(customer);
		//Inside object class there is method called tostring, 
		//there are no tosting in our class so it called object class toString
		//we can giver toString in Customer class

	}

}
