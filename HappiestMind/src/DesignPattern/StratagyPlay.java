package DesignPattern;

import java.util.Arrays;
import java.util.List;

public class StratagyPlay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<StratagyGame> strategies = 
		        Arrays.asList(
		          new StratagyCricket(), 
		          new StratagyFootball()
		        );
		                      
		    for(StratagyGame stg : strategies){
		      stg.playGame();
		    }
		    
		    

	}

}
