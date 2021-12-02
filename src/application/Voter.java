package application;
public class Voter {
	String Name; 
	String CNIC; 
	String password;
	PresistentHandler db; 
	boolean status;
	
	Voter(String Name, String CNIC, String Passwd){
		this.Name= Name;
		this.CNIC= CNIC;
		this.password=Passwd;
		db= new mySqlDBHandler(); 
		this.status=false;
		
	}
	public boolean Addvoter() {
		return db.AddVoter(this);
	}
	

	public String getName() {
		return Name;
	}

	public String getCNIC() {
		return CNIC;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setCNIC(String cNIC) {
		CNIC = cNIC;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
