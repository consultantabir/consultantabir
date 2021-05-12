package com.example.functionalinterface;

import java.util.function.Supplier;

public class _Supplier {
	public void output() {
		System.out.println("Inside supplier");
	}
	public void operation() {
		//IMPERATIVE
		System.out.println(getDBConnectionURL());
		//DECLARATIVE Supplier returns a result
		System.out.println(getDBConnectionURLSupplier.get());
	}
	Supplier<String> getDBConnectionURLSupplier = () ->"jdbc://localhost:5432/users";
	
	private String getDBConnectionURL() {
		return "jdbc://localhost:5432/users";
	}
}
