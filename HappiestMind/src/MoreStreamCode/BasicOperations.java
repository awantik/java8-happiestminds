package MoreStreamCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BasicOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");
		
		// Filter
		stringCollection
	    .stream()
	    .filter((s) -> s.startsWith("a"))
	    .forEach(System.out::println);
		
		
		//Sorted
		stringCollection
	    .stream()
	    .sorted()
	    .filter((s) -> s.startsWith("a"))
	    .forEach(System.out::println);

		
		//Map
		stringCollection
	    .stream()
	    .map(String::toUpperCase)
	    .sorted((a, b) -> b.compareTo(a))
	    .forEach(System.out::println);
		
		
		//Match
		boolean anyStartsWithA =
			    stringCollection
			        .stream()
			        .anyMatch((s) -> s.startsWith("a"));

			System.out.println(anyStartsWithA);      // true

			boolean allStartsWithA =
			    stringCollection
			        .stream()
			        .allMatch((s) -> s.startsWith("a"));

			System.out.println(allStartsWithA);      // false

			boolean noneStartsWithZ =
			    stringCollection
			        .stream()
			        .noneMatch((s) -> s.startsWith("z"));

			System.out.println(noneStartsWithZ);      // true

			//Count
			long startsWithB =
				    stringCollection
				        .stream()
				        .filter((s) -> s.startsWith("b"))
				        .count();

				System.out.println(startsWithB);
				
				
			//Reduce
				Optional<String> reduced =
					    stringCollection
					        .stream()
					        .sorted()
					        .reduce((s1, s2) -> s1 + "#" + s2);

					reduced.ifPresent(System.out::println);	


	}

}
