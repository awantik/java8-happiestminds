package ObserverDesignPattern;

public class MacroMain {
	public static void main(String[] args) {
		Macro macro = new Macro();
		//macro.record(new Open(editor));
		macro.record(new Save(editor));
		//macro.record(new Close(editor));
		macro.run();
	}

}
