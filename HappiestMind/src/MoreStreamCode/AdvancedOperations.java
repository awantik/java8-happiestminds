package MoreStreamCode;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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


public class AdvancedOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<NewPerson> persons =
			    Arrays.asList(
			        new NewPerson("Max", 18),
			        new NewPerson("Peter", 23),
			        new NewPerson("Pamela", 23),
			        new NewPerson("David", 12));
		
		//Collect
		List<NewPerson> filtered =
			    persons
			        .stream()
			        .filter(p -> p.name.startsWith("P"))
			        .collect(Collectors.toList());

			System.out.println(filtered); 
			
			Map<Integer, List<NewPerson>> personsByAge = persons
				    .stream()
				    .collect(Collectors.groupingBy(p -> p.age));

				personsByAge
				    .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
				
				
				
			Double averageAge = persons
					    .stream()
					    .collect(Collectors.averagingInt(p -> p.age));

					System.out.println(averageAge);	
					
		   //More stats
					IntSummaryStatistics ageSummary =
						    persons
						        .stream()
						        .collect(Collectors.summarizingInt(p -> p.age));

						System.out.println(ageSummary);
						
		  //Joins
						String phrase = persons
							    .stream()
							    .filter(p -> p.age >= 18)
							    .map(p -> p.name)
							    .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));

							System.out.println(phrase);
							
		 //Map
							Map<Integer, String> map = persons
								    .stream()
								    .collect(Collectors.toMap(
								        p -> p.age,
								        p -> p.name,
								        (name1, name2) -> name1 + ";" + name2));

								System.out.println(map);
								
		 //Supplier, accumulator,combiner
								Collector<NewPerson, StringJoiner, String> personNameCollector =
									    Collector.of(
									        () -> new StringJoiner(" | "),          // supplier
									        (j, p) -> j.add(p.name.toUpperCase()),  // accumulator
									        (j1, j2) -> j1.merge(j2),               // combiner
									        StringJoiner::toString);                // finisher

									String names = persons
									    .stream()
									    .collect(personNameCollector);

									System.out.println(names); 

	}

}
