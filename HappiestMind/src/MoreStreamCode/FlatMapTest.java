package MoreStreamCode;

import java.util.stream.Stream;

public class FlatMapTest {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stream.of(1, 2, 3)
		.map(n -> Stream.of(n, n * n))
		.forEach(System.out::println);
		//.forEach(e -> e.forEach(System.out::println));

		Stream.of(1, 2, 3)
		.flatMap(n -> Stream.of(n, n * n))
		.forEach(System.out::println);
		
		long count = Stream.of("Ken", "Jeff", "Ellen")
				.map(name -> name.chars())
				.flatMap(intStream -> intStream.mapToObj(n -> (char)n))
				.filter(ch -> ch == 'e' || ch == 'E')
				.count();
				 
				System.out.println("Es count: " + count);
		
			
		        		
	}

}
