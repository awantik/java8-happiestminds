package MoreStreamCode;

import java.util.Arrays;
import java.util.List;

class NewPerson {
    String name;
    int age;

    NewPerson(String name, int age) {
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
		List<NewPerson> persons =
			    Arrays.asList(
			        new NewPerson("Max", 18),
			        new NewPerson("Peter", 23),
			        new NewPerson("Pamela", 23),
			        new NewPerson("David", 12));
		
		persons
	    .stream()
	    .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
	    .ifPresent(System.out::println);

		//Dump all
		NewPerson result =
			    persons
			        .stream()
			        .reduce(new NewPerson("", 0), (p1, p2) -> {
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
					            System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
					            return sum += p.age;
					        },
					        (sum1, sum2) -> {
					            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
					            return sum1 + sum2;
					        });
		
				//Parallel
				Integer parallelageSum = persons
					    .parallelStream()
					    .reduce(0,
					        (sum, p) -> {
					            System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
					            return sum += p.age;
					        },
					        (sum1, sum2) -> {
					            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
					            return sum1 + sum2;
					        });
	}

}
