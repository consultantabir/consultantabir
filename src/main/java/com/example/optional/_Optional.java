package com.example.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class _Optional {
	public void output() {
		System.out.println("Inside optional");
	}
	public void operation() {
		Object value1=Optional.ofNullable("null")
			.orElseGet(() -> "default value");
		
		Optional.of("john$gmail.com")
				.ifPresent(email -> {
					if(email.contains("$")) {
						String newEmail=email.replace("$", "@");
						System.out.println(newEmail);
					}
				}
				
);
		
		System.out.println(value1);
	}
}
