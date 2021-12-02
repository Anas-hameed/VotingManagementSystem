package application;

import java.util.HashMap;

public abstract class PresistentHandler {
	
	abstract public boolean AddVoter(Voter p);
	abstract public boolean VerifyAccount(String name, String password);
	abstract public boolean  AddSymbol(String Name);
	abstract public boolean AddParty(String Nane, int symbolID, String Agenda);
	abstract public boolean AddCandidate(String Name, int SymbolID);
	abstract public HashMap<Integer,String> fetchSymbol();
	
	
}
