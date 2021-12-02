package application;

public class Candidiate {
	int SymbolID; 
	String Name; 
	int voteCount=0;
	
	static PresistentHandler p= new mySqlDBHandler();
	
	public Candidiate(int symbolID, String name) {
		super();
		SymbolID = symbolID;
		Name = name;
		this.voteCount = 0;
	}
	public int getSymbolID() {
		return SymbolID;
	}
	public String getName() {
		return Name;
	}
	public int getVoteCount() {
		return voteCount;
	}
	public void setSymbolID(int symbolID) {
		SymbolID = symbolID;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}
	
	
	// Add The candidate
	public boolean AddCondidate() {
		return p.AddCandidate(Name,SymbolID);
	}
	
	
	
	
}
