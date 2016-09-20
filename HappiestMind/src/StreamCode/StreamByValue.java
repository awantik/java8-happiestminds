package StreamCode;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamByValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum = Stream.of(1, 2, 3, 4, 5)
				.filter(n -> n % 2 == 1)
				.map(n -> n * n)
				.reduce(0, Integer::sum);
				 
				System.out.println("Sum = " + sum);
				
				Stream<String> stream = Stream.<String>builder()
						.add("Ken")
						.add("Jeff")
						.add("Chris")
						.add("Ellen")
						.build();
				
				// Create an IntStream containing 1, 2, 3, 4, and 5
				IntStream oneToFive1 = IntStream.range(1, 6);
				 
				// Create an IntStream containing 1, 2, 3, 4, and 5
				IntStream oneToFive2 = IntStream.rangeClosed(1, 5);
				
				

	}

}
