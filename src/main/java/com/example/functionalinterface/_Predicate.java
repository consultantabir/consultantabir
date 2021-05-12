package com.example.functionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import com.example.functionalinterface._Consumer.Customer;

public class _Predicate {

	public void output() {
		System.out.println("Inside predicate");
	}
	public void operation() {
		//IMPERATIVE
		System.out.println(isPhoneNumberValid("07897654678"));
		//DECLARATIVE Predicate takes 1 Argument and returns 1 boolean
		System.out.println(isPhoneNumberValidPredicate
				.test("07654325617"));
		System.out.println(isPhoneNumberValidPredicate
				.and(doesPhoneNumberContain3Predicate).test("07654325617"));
		System.out.println(isPhoneNumberValidPredicate
				.or(doesPhoneNumberContain3Predicate).test("07654325617"));
		//DECLARATIVE BiPredicate takes 2 input Argument and returns 1 boolean result
		System.out.println(isPhoneNumberValidMariaPredicate.test("079989", "Maria"));
		
	}
	Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> 
									phoneNumber.startsWith("07")&&phoneNumber.length() ==11;
	Predicate<String> doesPhoneNumberContain3Predicate = phoneNumber -> 
									phoneNumber.contains("3");
	BiPredicate<String, String> isPhoneNumberValidMariaPredicate = (phoneNumber, name) ->
	phoneNumber.startsWith("07") && name.equals("Maria");
	private boolean isPhoneNumberValid(String phoneNumber) {
		return phoneNumber.startsWith("07")&&
				phoneNumber.length() ==11;
	}
}
