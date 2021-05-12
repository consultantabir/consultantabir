package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Lambdas {

	public void output() {
		System.out.println("Inside lambdas");
	}
	public void operation() {
		
		Function<String, String> upperCaseName =
				name -> {
					if(name.isEmpty()) {
						throw new IllegalArgumentException("New Exc");
					}
					return name.toUpperCase();
				};
				
		BiFunction<String,Integer, String> upperCaseNamePrintName =
						(name,age) -> {
							if(name.isEmpty()) {
								throw new IllegalArgumentException("New Exc");
							}
							System.out.println(age + name.toUpperCase());
							return name.toUpperCase();
						};
		upperCaseNamePrintName.apply("Alexa", 23);
	}
	public void action() {
		//IMPERATIVE
		List<Integer> listNum=Arrays.asList(1,2,3,8,6,7);
		int doubleResult=0;
		for(int n : listNum) {
			if(n > 3 && n%2==0) {
				doubleResult= n*2;
				break;
			}
		}
				System.out.println(doubleResult);		
	}
	public void actionLambda() {
		//DECLARATIVE
		List<Integer> listNum=Arrays.asList(1,2,3,8,6,7);
		Optional<Integer> doubleResult=listNum.stream()
		.sorted()
		.filter(num -> num > 3)
		.filter(num -> num % 2 ==0)
		.map(num -> num * 2).findFirst();
		
		System.out.println(doubleResult.get());
	}
}
