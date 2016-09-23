package Nashorn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.Date;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

class Person{
	String name;
	
	public Person(){
		this.name = "Abc";
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
	
}

public class ScriptLoad {

	public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {
		// TODO Auto-generated method stub
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval(new FileReader("res/script.js"));

		Invocable invocable = (Invocable) engine;

		Object result = invocable.invokeFunction("fun1", "Curanest");
		System.out.println(result);
		System.out.println(result.getClass());
		
		invocable.invokeFunction("fun2", new Date());
		// [object java.util.Date]

		invocable.invokeFunction("fun2", LocalDateTime.now());
		// [object java.time.LocalDateTime]

		invocable.invokeFunction("fun2", new Person());
	
	}

}
