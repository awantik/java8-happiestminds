package LambdaExpressions;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

class myIntf implements Consumer{

	@Override
	public void accept(Object t) {
		// TODO Auto-generated method stub
		System.out.println(t);
	}
	
}

class filter implements Predicate<Integer>{

	@Override
	public boolean test(Integer t) {
		// TODO Auto-generated method stub
		if (t % 2 == 0){
			return true;
		}
		
		return false;
	}

	
	
}

public class ArListPred {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> ar = new ArrayList<>();
		
		ar.add(5);
		ar.add(6);
		ar.add(7);
	
		ar.forEach(new myIntf());
		
		ar.forEach((o) -> {
			o += o;
			System.out.println(o);
			}
		);
	
		//ar.replaceAll(operator);
		
		ar.removeIf(new filter());
		
		ar.forEach((o)->{System.out.println(o);});

		ar.removeIf((o)->{
			if (o%2==0) {
				return true; 
			}else{
				return false;
			}
		}
	);
	}

}
