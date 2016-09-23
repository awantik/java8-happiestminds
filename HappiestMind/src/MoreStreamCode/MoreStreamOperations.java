package MoreStreamCode;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Std{
	String name;
	public Std(String n){
		this.name = n;
	}
}

class Emp{
	String name;
	public Emp(String n){
		this.name = n;
	}
}

public class MoreStreamOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Arrays.asList("a1", "a2", "a3")
	    .stream()
	    .findFirst()
	    .ifPresent(System.out::println);
		
		Stream.of("a1", "a2", "a3")
	    .findFirst()
	    .ifPresent(System.out::println); 
		
		IntStream.range(1, 4)
	    .forEach(System.out::println);
		
		Arrays.stream(new int[] {1, 2, 3})
	    .map(n -> 2 * n + 1)
	    .average()
	    .ifPresent(System.out::println);

		Stream.of("a1", "a2", "a3")
	    .map(s -> s.substring(1))
	    .mapToInt(Integer::parseInt) 
	    .max()
	    .ifPresent(System.out::println);
		
		Stream.of(new Std("ab"),new Std("bc"),new Std("cd"))
		.map(s -> {
			return new Emp(s.name);
		})
		.forEach(System.out::println);
		
		IntStream.range(1, 4)
	    .mapToObj(i -> "a" + i)
	    .forEach(System.out::println);
		
		Stream.of(1.0, 2.0, 3.0)
	    .mapToInt(Double::intValue)
	    .mapToObj(i -> "a" + i)
	    .forEach(System.out::println);
		
		
		//Won't print
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return true;
	    });

		
		//Print here
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return true;
	    })
	    .forEach(s -> System.out.println("forEach: " + s));

		Stream.of("d2", "a2", "b1", "b3", "c")
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .anyMatch(s -> {
	        System.out.println("anyMatch: " + s);
	        return s.startsWith("A");
	    });
		
		
		
		
	}

}
