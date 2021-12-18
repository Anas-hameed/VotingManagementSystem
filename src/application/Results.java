package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Results {
	private IntegerProperty VoteCount;
	private StringProperty AlocatedSymbol;
	private StringProperty BelongTo;
	private StringProperty candidateName;
	
	Results(){
		this.VoteCount= new SimpleIntegerProperty();
		this.AlocatedSymbol= new SimpleStringProperty();
		this.BelongTo= new SimpleStringProperty();
		this.candidateName= new SimpleStringProperty();
	}
	public int getVoteCount() {
		return VoteCount.get();
	}
	public String getAlocatedSymbol() {
		return AlocatedSymbol.get();
	}
	public String getBelongTo() {
		return BelongTo.get();
	}
	public String getcandidateName() {
		return candidateName.get();
	}
	public void setVoteCount(int voteCount) {
		this.VoteCount.set(voteCount); 
	}
	public void setAlocatedSymbol(String alocatedSymbol) {
		this.AlocatedSymbol.set(alocatedSymbol);
	}
	public void setBelongTo(String belongTo) {
		if(belongTo==null)
		{
			BelongTo.set("Independent");
			return;
		}
		BelongTo.set(belongTo);
	}
	public void setcandidateName(String name) {
		candidateName.set(name);
	}
}
