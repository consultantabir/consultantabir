package com.example.imperative;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Imperative {
	public void output() {
		System.out.println("Well hello there");
	}
	public void operation() {
		List<Person> people=Arrays.asList(new Person("John",Gender.MALE),
				new Person("Maria",Gender.FEMALE),
				new Person("Aisha",Gender.FEMALE),
				new Person("Alex",Gender.MALE),
				new Person("Alice",Gender.FEMALE));
		
		//IMPERATIVE
		System.out.println("IMPERATIVE");
		for (Person p:people) {
			if(p.gender.equals(Gender.FEMALE))
				System.out.println(p);
		}
		
		//FUNCTIONAL
		System.out.println("FUNCTIONAL");
		Predicate<Person> predicate=person -> person.gender.equals(Gender.FEMALE);
		people.stream()
		.filter(predicate)
		.forEach(System.out::println);
	}
	public class Person{
		private final String name;
		private final Gender gender;
		
		public Person(String name, Gender gender) {
			super();
			this.name = name;
			this.gender = gender;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", gender=" + gender + "]";
		}
		
	}
	enum Gender{
		MALE, FEMALE
	}
}

