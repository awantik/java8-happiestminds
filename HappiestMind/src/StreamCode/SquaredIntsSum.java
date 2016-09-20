package StreamCode;

import java.util.Arrays;
import java.util.List;

public class SquaredIntsSum {
	public static void main(String[] args) {
		// Get a list of integers from 1 to 5
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

		// Get the stream from the list
		//Stream<Integer> numbersStream = numbersList.stream();
		
		// Get a stream of odd integers
		//Stream<Integer> oddNumbersStream= numbersStream.filter(n -> n % 2 == 1);
		
		// Get a stream of the squares of odd integers
		//Stream<Integer> squaredNumbersStream = oddNumbersStream.map(n -> n * n);
		
		// Sum all integers in the stream
		//int sum = squaredNumbersStream.reduce(0, Integer::sum);
		
		// Compute the sum of the squares of all odd integers in the list
		int sum = numbers.stream()
		                 .filter(n -> n % 2 == 1)
		                 .map(n -> n * n)
		                 .reduce(0, Integer::sum);
		
		System.out.println("Sum = " + sum);
	}
}
