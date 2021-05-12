package com.example.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class _Streams {

	public void output() {
		System.out.println("Inside Streams");
	}
	public void operation() {
		List<Person> people=Arrays.asList(new Person("John",Gender.MALE),
				new Person("Maria",Gender.FEMALE),
				new Person("Aisha",Gender.FEMALE),
				new Person("Alex",Gender.MALE),
				new Person("Bob",Gender.OTHERS),
				new Person("Alice",Gender.FEMALE));
		
		/*
		 * Set<Gender> genders=people.stream() .map(person -> person.gender)
		 * .collect(Collectors.toSet()); System.out.println(genders);
		 */
		people.stream()
		.map(person -> person.gender)
		.collect(Collectors.toSet());
		
		people.stream()
		.map(person -> person.name)
		.collect(Collectors.toSet());
		//.forEach(System.out::println);
		
		people.stream()
		.map(person -> person.name)
		.mapToInt(name -> name.length());
		//.forEach(System.out::println);
		
		people.stream()
		.allMatch(person -> person.gender.equals(Gender.FEMALE));
		
		//DECLARATIVE Supplier returns a result
		//System.out.println(getDBConnectionURLSupplier.get());
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
		MALE, FEMALE, OTHERS
	}
}
