package DesignPattern;

import java.util.Arrays;
import java.util.List;

public class LambdaStratagy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<StratagyGame> strategies = 
			      Arrays.asList(
			        () -> {System.out.println("Play cricket!");},
			        () -> {System.out.println("Play football!");}
			      );
			    
			    strategies.forEach((elem) -> elem.playGame());

	}

}
