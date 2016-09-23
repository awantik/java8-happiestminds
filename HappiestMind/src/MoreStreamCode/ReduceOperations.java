package MoreStreamCode;

import java.util.Arrays;
import java.util.List;

class MorePerson {
    String name;
    int age;

    MorePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }
}


public class ReduceOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<MorePerson> persons =
			    Arrays.asList(
			        new MorePerson("Max", 18),
			        new MorePerson("Peter", 23),
			        new MorePerson("Pamela", 23),
			        new MorePerson("David", 12));
		
		persons
	    .stream()
	    .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
	    .ifPresent(System.out::println);

		//Dump all
		MorePerson result =
			    persons
			        .stream()
			        .reduce(new MorePerson("", 0), (p1, p2) -> {
			            p1.age += p2.age;
			            p1.name += p2.name;
			            return p1;
			        });

			System.out.format("name=%s; age=%s", result.name, result.age);
			
			//Complete Syntex
			Integer ageSum = persons
				    .stream()
				    .reduce(0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2);

				System.out.println(ageSum); 
				
				Integer moreAgeSum = persons
					    .stream()
					    .reduce(0,
					        (sum, p) -> {
					            System.out.format("seq accumulator: sum=%s; person=%s\n", sum, p);
					            return sum += p.age;
					        },
					        (sum1, sum2) -> {
					            System.out.format("seq combiner: sum1=%s; sum2=%s\n", sum1, sum2);
					            return sum1 + sum2;
					        });
				
				System.out.println(moreAgeSum);
		
				//Parallel
				Integer parallelageSum = persons
					    .parallelStream()
					   
					    .reduce(0,
					        (sum, p) -> {
					            System.out.format("par  accumulator: sum=%s; person=%s\n", sum, p);
					            System.out.println("acu " + Thread.currentThread().getName());
					            return sum += p.age;
					        },
					        (sum1, sum2) -> {
					            System.out.format("parcombiner: sum1=%s; sum2=%s\n", sum1, sum2);
					            System.out.println("com " + Thread.currentThread().getName());
					            return sum1 + sum2;
					        });
				System.out.println( parallelageSum);
	}

}
