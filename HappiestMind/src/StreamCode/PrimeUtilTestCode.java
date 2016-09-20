package StreamCode;

import java.util.stream.Stream;

public class PrimeUtilTestCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stream.iterate(2L, PrimeUtil::next)
		.limit(5)
		.forEach(System.out::println);
		
		Stream.iterate(2L, PrimeUtil::next)
		.skip(100)
		.limit(5)
		.forEach(System.out::println);
		
		// Print the first 5 prime numbers
		Stream.iterate(2L, n -> n + 1)
		.filter(PrimeUtil::isPrime)
		.limit(5)
		.forEach(System.out::println);

	}

}
