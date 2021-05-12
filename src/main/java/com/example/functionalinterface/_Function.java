package com.example.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

	public void output() {
		System.out.println("Inside function");
	}
	public void operation() {
		//FUNCTION takes 1 argument and produces 1 result
		System.out.println("IMPERATIVE: "+increment(1));
		System.out.println("DECLARATIVE: "+incrementFunction.apply(1));
		System.out.println("DECLARATIVE: "+multiplyByFunction.apply(incrementFunction.apply(1)));
		System.out.println("DECLARATIVE: "+incrementFunction.andThen(multiplyByFunction).apply(2));
		//BI FUNCTION takes 2 arguments and produces 1 result
		System.out.println("DECLARATIVE: "+incrementAndMultiplyFunction.apply(2,3));
	}
	Function<Integer, Integer> incrementFunction = num -> ++num;
	Function<Integer, Integer> multiplyByFunction = num -> num * 10;
	
	BiFunction<Integer, Integer, Integer> incrementAndMultiplyFunction=
			(num,multiply) -> (++num)*multiply;
	private int increment(int num) {
		return ++num;
	}
	private int incrementAndMultiply(int num, int multiply) {
		return (++num) * multiply;
	}
}
