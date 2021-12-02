package application;

import java.util.HashMap;

public class Symbols {
	private String Symbolname;
	static PresistentHandler p= new mySqlDBHandler();
	public Symbols(String symbolname) {
		super();
		Symbolname = symbolname;
	}

	public String getSymbolname() {
		return Symbolname;
	}

	public void setSymbolname(String symbolname) {
		Symbolname = symbolname;
	}
	
	public boolean saveSymbol() {	
		return p.AddSymbol(Symbolname);
	}
	
	public static HashMap<Integer,String> fetchSymbol() {		
		return p.fetchSymbol();
	}
	
	
	
}
