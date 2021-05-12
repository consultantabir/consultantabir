package com.example.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
	public void output() {
		System.out.println("Inside consumer");
	}
	public void operation() {
		//IMPERATIVE
		greetCustomer(new Customer("Maria","99999"));
		//DECLARATIVE Consumer takes 1 Argument and returns no result
		greetCustomerConsumer.accept(new Customer("Maria","999999"));
		//DECLARATIVE BiConsumer takes 2 input Argument and returns no result
		greetCustomerBiConsumer.accept(new Customer("Maria","999999"), true);
	}
	Consumer<Customer> greetCustomerConsumer= 
			customer ->
			System.out.println("Hello: "+customer.name+". Thanks for phone number: "+customer.phoneNumber);
	
	BiConsumer<Customer,Boolean> greetCustomerBiConsumer= 
			(customer,showPhoneNumber) ->
			System.out.println("Hello: "+customer.name+". Thanks for phone number: "+(showPhoneNumber ? customer.phoneNumber : "****") );
			
	private void greetCustomer(Customer customer) {
		System.out.println("Hello: "+customer.name+". Thanks for phone number: "+customer.phoneNumber);
	}
	class Customer{
		private final String name;
		private final String phoneNumber;
		public Customer(String name, String phoneNumber) {
			super();
			this.name = name;
			this.phoneNumber = phoneNumber;
		}
	}
}
