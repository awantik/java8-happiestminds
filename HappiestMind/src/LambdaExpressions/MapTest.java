package LambdaExpressions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

class ImplBi implements Function<Integer,String>{

	@Override
	public String apply(Integer t) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

class myBiFunc implements BiFunction<Integer,String,String>{

	@Override
	public String apply(Integer t, String u) {
		// TODO Auto-generated method stub
		return null;
	}


	
}

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Integer,String> info = new HashMap<>();
		//info.replaceAll(function);
		//info.replace(key, value)
		info.put(100, "abc");
		info.put(200," value");
//	   info.compute( 200, (x,y) -> {
//		   System.out.println(y);
//		   if (y.equals("abc")){
//		   y = "hello";
//		   }
//		   return y;
//	   });
//	   info.
		
		info.replace(200,"greatr");
		info.replaceAll( (x,y) -> {
			//logic
			return y+y;
		}
				
	   );
		
	   System.out.println(info);

	}

}
