package MoreStreamCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ParallelStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int max = 1000000;
		List<String> values = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
		    UUID uuid = UUID.randomUUID();
		    values.add(uuid.toString());
		}
		
		
		//Sequential
		long t0 = System.nanoTime();

		long count = values.stream().sorted().count();
		System.out.println(count);

		long t1 = System.nanoTime();

		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("sequential sort took: %d ms", millis));
		
		
       //Parallel
		long t2 = System.nanoTime();

		long countp = values.parallelStream().sorted().count();
		System.out.println(countp);

		long t3 = System.nanoTime();

		long millisp = TimeUnit.NANOSECONDS.toMillis(t3 - t2);
		System.out.println(String.format("parallel sort took: %d ms", millisp));

		
		Arrays.asList("a1", "a2", "b1", "c2", "c1")
	    .parallelStream()
	    .filter(s -> {
	        System.out.format("filter: %s [%s]\n",
	            s, Thread.currentThread().getName());
	        return true;
	    })
	    .map(s -> {
	        System.out.format("map: %s [%s]\n",
	            s, Thread.currentThread().getName());
	        return s.toUpperCase();
	    })
	    .forEach(s -> System.out.format("forEach: %s [%s]\n",
	        s, Thread.currentThread().getName()));

		
		//Sort in parallel
//		Arrays.asList("a1", "a2", "b1", "c2", "c1")
//	    .parallelStream()
//	    .filter(s -> {
//	        System.out.format("filter: %s [%s]\n",
//	            s, Thread.currentThread().getName());
//	        return true;
//	    })
//	    .map(s -> {
//	        System.out.format("map: %s [%s]\n",
//	            s, Thread.currentThread().getName());
//	        return s.toUpperCase();
//	    })
//	    .sorted((s1, s2) -> {
//	        System.out.format("sort: %s <> %s [%s]\n",
//	            s1, s2, Thread.currentThread().getName());
//	        return s1.compareTo(s2);
//	    })
//	    .forEach(s -> System.out.format("forEach: %s [%s]\n",
//	        s, Thread.currentThread().getName()));


	}
	
	//Sort in parallel
	

}
