package application;

public class Party {
	int SymbolId;
	String PartyName; 
	String Agenda;
	
	static PresistentHandler p= new mySqlDBHandler();
	
	public Party(int symbolId, String partyName, String agenda) {
		super();
		SymbolId = symbolId;
		PartyName = partyName;
		Agenda = agenda;
	}
	
	
	
	public int getSymbolId() {
		return SymbolId;
	}
	public String getPartyName() {
		return PartyName;
	}
	public String getAgenda() {
		return Agenda;
	}
	public void setSymbolId(int symbolId) {
		SymbolId = symbolId;
	}
	public void setPartyName(String partyName) {
		PartyName = partyName;
	}
	public void setAgenda(String agenda) {
		Agenda = agenda;
	}
	
	public boolean SaveParty() {
		return p.AddParty(PartyName, SymbolId, Agenda);
	}
	
}
