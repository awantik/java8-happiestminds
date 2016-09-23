package Nashorn;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ObjectNashrom {

	public static void main(String[] args) throws NoSuchMethodException, ScriptException, FileNotFoundException {
		// TODO Auto-generated method stub
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval("load('res/nashrom5.js')");
		//engine.eval(new FileReader("res/nashrm5.js"));
		 
        Invocable invocable = (Invocable) engine;

        Product product = new Product();
        product.setName("Rubber");
        product.setPrice(1.99);
        product.setStock(1037);

        Object result = invocable.invokeFunction("getValueOfGoods", product);
        System.out.println(result);

	}

}
