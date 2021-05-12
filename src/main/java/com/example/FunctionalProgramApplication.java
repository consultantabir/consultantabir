package com.example;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.combinatorpattern.Customer;
import com.example.combinatorpattern.CustomerRegistrationValidator;
import com.example.combinatorpattern.CustomerRegistrationValidator.ValidationResult;
import com.example.combinatorpattern.CustomerValidatorService;
import com.example.functionalinterface._Consumer;
import com.example.functionalinterface._Function;
import com.example.functionalinterface._Predicate;
import com.example.functionalinterface._Supplier;
import com.example.imperative.Imperative;
import com.example.optional._Optional;
import com.example.streams._Streams;

@SpringBootApplication
public class FunctionalProgramApplication {

	public static void main(String[] args) {
		SpringApplication.run(FunctionalProgramApplication.class, args);
		
		Imperative imp=new Imperative();
		//imp.output();
		//imp.operation();
		
		_Function function=new _Function();
		//function.output();
		//function.operation();
		
		_Consumer consumer=new _Consumer();
		//consumer.output();
		//consumer.operation();
		
		_Predicate predicate=new _Predicate();
		//predicate.output();
		//predicate.operation();
		
		_Supplier supplier=new _Supplier();
		//supplier.output();
		//supplier.operation();
		
		_Streams streams=new _Streams();
		//streams.output();
		//streams.operation();
		
		_Optional optional=new _Optional();
		//optional.output();
		//optional.operation();
		
		Customer customer=new Customer("Alice",
				"alice@gmail.com",
				"+08976543456",
				LocalDate.of(2000, 1, 1)
				);
		//System.out.println(
		//		new CustomerValidatorService().isValid(customer));
		
		//USING COMBINATOR PATTERN
		CustomerRegistrationValidator
		.isEmailValid()
		.and(CustomerRegistrationValidator.isPhoneNumberValid())
		.and(CustomerRegistrationValidator.isAdult())
		.apply(customer);
		
		ValidationResult result=CustomerRegistrationValidator
				.isEmailValid()
				.and(CustomerRegistrationValidator.isPhoneNumberValid())
				.and(CustomerRegistrationValidator.isAdult())
				.apply(customer);
		
		System.out.println(result);
		
		Lambdas lambdas=new Lambdas();
		lambdas.output();
		//lambdas.operation();
		lambdas.action();
		lambdas.actionLambda();
	}

}
