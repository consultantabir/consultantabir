package collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _Collectors {
public static void main(String args[]) {
	_Collectors collect=new _Collectors();
	//reduce takes the collection and reduces to a single value. Reduce converts a stream to something concrete
	//collect.createPerson().stream().map(Person::getAge).reduce(0,(total,age) -> total+age);
	
	System.out.println(collect.createPerson().stream().filter(p -> p.getAge() > 30)
	.map(personName -> personName.getName()).map(up -> up.toUpperCase()).collect(Collectors.toList()));

	Map myMap=new HashMap(collect.createPerson().stream()
	.collect(Collectors.toMap(Person::getName, Person::getAge)));	
	System.out.println(myMap);
	
	System.out.println(collect.createPerson().stream()
	.map(Person::getAge).collect(Collectors.toList()));
	
	//return comma separated Names in Uppercase whose age > 50 (in JDK 10)
	//System.out.println(collect.createPerson().stream()
	//		.filter(p -> p.getAge() > 50).map(Person::getName).map(up -> up.toUpperCase()).collect(joining(", ")));
	
	//even and odd age person using partitioning
	Map evenOdd=new HashMap(collect.createPerson().stream()
			.collect(Collectors.partitioningBy(p -> p.getAge() % 2 ==0)));
	System.out.println(evenOdd);
	
	//Group the people based on their name
	Map groupByName=new HashMap(collect.createPerson().stream()
			.collect(Collectors.groupingBy(p -> p.getName())));
	System.out.println(groupByName);
	
	Map groupByNameReturnAgeList=new HashMap(collect.createPerson().stream()
			.collect(Collectors.groupingBy(p -> p.getName(),Collectors.mapping(Person::getAge, Collectors.toList()))));
	System.out.println(groupByNameReturnAgeList);

	Map<String,Long> countByNameReturnLong=new HashMap(collect.createPerson().stream()
			.collect(Collectors.groupingBy(p -> p.getName(),Collectors.counting())));
	System.out.println(countByNameReturnLong);
	
	//Map<String,Integer> countByNameReturnInteger=new HashMap(collect.createPerson().stream()
	//		.collect(Collectors.groupingBy(p -> p.getName(),collectingAndThen(Collectors.counting(),Long::intValue))));
	//System.out.println(countByNameReturnInteger);
	
	//Sum/Max
	System.out.println("Max age: "+collect.createPerson().stream().mapToInt(Person::getAge).max());
	System.out.println(collect.createPerson().stream()
			.collect(Collectors.maxBy(Comparator.comparing(Person::getAge))));
	//List<Integer> num=Arrays.asList(2,1,3,4,3,1);
	//num.stream().distinct().forEach(System.out::print);
}
public List<Person> createPerson(){
	return Arrays.asList(
	new Person("Sara",20),
	//new Person("Sara",22),
	new Person("Sarah",22),
	new Person("Bob",20),
	new Person("Paula",32),
	new Person("Paul",32),
	new Person("Jack",3),
	//new Person("Jack",72),
	new Person("Jacky",72),
	new Person("Jill",11)
	);
}
public class Person{
	private final String name;
	private final int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
}
