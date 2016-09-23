package Nashorn;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class First {

	public static void main(String[] args) throws ScriptException, FileNotFoundException, NoSuchMethodException {
		// TODO Auto-generated method stub
		
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval("print('Hello World');");
		
	}

}
