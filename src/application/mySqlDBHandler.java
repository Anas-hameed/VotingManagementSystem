package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class mySqlDBHandler extends PresistentHandler {
	static Connection con;
	
	private static boolean Esblishconnection() throws SQLException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/VMS","root","12345");
			return true;
		
		}catch(ClassNotFoundException err)  {
			System.out.println("Error Driver not found");	
		}
		return false;
	}
	
	@Override
	public boolean AddVoter(Voter voter) {
		try{	
			if(Esblishconnection())
			{
				String sql="insert into Voter(Name,CNIC, Password) values (?,?,?)";			
				PreparedStatement statement=con.prepareStatement(sql);
				statement.setString(1, voter.getName());
				statement.setString(2, voter.getCNIC());
				statement.setString(3, voter.getPassword());
				int rowsUpdated=statement.executeUpdate();
				con.close();
				if (rowsUpdated>0) {
					System.out.println("Sucessfull saving the Account Information");
					return true;
				}
				return false;
			}
		}
		catch(SQLException err) {
			System.out.println("mySQL::Invalid password or UserName"); 
			System.out.println(err);
			System.out.println("----------------------------------------------");
			err.printStackTrace();
		}
		return false; 	
	}

	@Override
	public boolean VerifyAccount(String CNIC,String password) {
		try {
			if(Esblishconnection())
			{
				String sql="select name from Voter where CNIC= '"+CNIC+ "' and password= '"+password+"';";
				
				System.out.println(sql);
				
				Statement statement=con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				while (rs.next())
			    {
					String name= rs.getNString("name");
					if (!name.isEmpty()) {
						System.out.println("Account Verified");
						return true;
					}
			    }
				con.close();
				System.out.println("Not account Found");
				return false;
			}
		}
		catch(SQLException err) {
			System.out.println("mySQL::Invalid password or UserName"); 
			System.out.println(err);
			System.out.println("----------------------------------------------");
			err.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean AddSymbol(String Name) {
		try {
			if(Esblishconnection())
			{
				String sql="insert into symbols(SymbolName) values(?);";
				PreparedStatement statement=con.prepareStatement(sql);
				statement.setString(1, Name);
				int rowsUpdated=statement.executeUpdate();
				con.close();
				if (rowsUpdated>0) {
					System.out.println("Sucessfull Added Symbol");
					return true;
				}
				return false;
			}
		}
		catch (SQLException e) {
			System.out.println("Failure to add Symbol");
			e.printStackTrace();
		}
		return false;			
	}

	@Override
	public boolean AddParty(String Name, int symbolID, String Agenda) {
		// TODO Auto-generated method stub
		try {
			if(Esblishconnection())
			{
				String sql="insert into Party(SymbolId, PartyName, Agenda) values(?,?,?);";
				PreparedStatement statement=con.prepareStatement(sql);
				statement.setInt(1, symbolID);
				statement.setString(2, Name);
				statement.setString(3, Agenda);
				int rowsUpdated=statement.executeUpdate();
				if (rowsUpdated>0) {
					System.out.println("Sucessfull Added Party");
					return true;
				}
				con.close();
			}
			
		}
		catch(SQLException err) {
			System.out.println("Invalid query entered"); 
			System.out.println(err);
			System.out.println("----------------------------------------------");
			err.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean AddCandidate(String Name, int SymbolID) {
		// TODO Auto-generated method stub
		try {
			if(Esblishconnection())
			{
				//				
				String sql="insert into candidate(Name, SymbolId) values (?, ?);";
				PreparedStatement statement=con.prepareStatement(sql);
				statement.setString(1, Name);
				statement.setInt(2, SymbolID);
				int rowsUpdated=statement.executeUpdate();
				if (rowsUpdated>0) {
					System.out.println("Sucessfull Added Candidiate");
					return true;
				}
				else {
					System.out.println("Error in the Query");
				}
				con.close();	
			}
		}
		catch(SQLException err) {
			System.out.println("Invalid query entered"); 
			System.out.println(err);
			System.out.println("----------------------------------------------");
			err.printStackTrace();
		}
		return false;
	}

	@Override
	public HashMap<Integer,String> fetchSymbol() {
		// TODO Auto-generated method stub
		try {
			if(Esblishconnection())
			{
				String sql="select * from symbols;";
				Statement statement=con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				HashMap<Integer,String> Symbols=new HashMap<Integer,String>();
				if(rs.next())
				{
					int SymbolId	= rs.getInt("SymbolId");
					String PartyName= rs.getString("symbolName");
					Symbols.put(SymbolId, PartyName);
					while (rs.next())
					{
						SymbolId	= rs.getInt("SymbolId");
						PartyName= rs.getString("symbolName");
						Symbols.put(SymbolId, PartyName);
					}
				}
				else {
					System.out.println("No data Found");
					return null;
				}
				con.close();
				return Symbols;
			}
		}
		catch(SQLException err) {
			System.out.println("Invalid query entered"); 
			System.out.println(err);
			System.out.println("----------------------------------------------");
			err.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean CastVote(int SymbolId) {
		// TODO Auto-generated method stub
		try {
			if(Esblishconnection())
			{
				String sql="update candidate set votecount=votecount+1 where symbolId="+Integer.toString(SymbolId)+";";
				System.out.println(sql);
				
				Statement statement=con.createStatement();
				int rowsUpdated=statement.executeUpdate(sql);
				if (rowsUpdated>0) {
					System.out.println("Sucessfull Added Candidiate");
					return true;
				}
				else {
					System.out.println("Error in the Query");
				}
				
			}
		}
		catch(SQLException err) {
				System.out.println("Invalid query entered"); 
				System.out.println(err);
				System.out.println("----------------------------------------------");
				err.printStackTrace();
			}		
		return false;
	}
	
	
	public static ObservableList<Results> getAllRecords() throws ClassNotFoundException, SQLException{
		try {
			if(Esblishconnection())
			{
				String sql="select Name, p.partyName, s.symbolName,c.voteCount from candidate c left outer join party p on c.SymbolId=p.SymbolId join symbols s where s.symbolID=c.symbolid;";
				Statement statement=con.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				return getEmployeesObject(rs);
			}
		}
		catch(SQLException err) {
			System.out.println("Invalid query entered"); 
			System.out.println(err);
			System.out.println("----------------------------------------------");
			err.printStackTrace();
		}
		return null;
	}
	private static ObservableList<Results> getEmployeesObject(ResultSet rsSet) throws SQLException, ClassNotFoundException{
		ObservableList<Results> emp= FXCollections.observableArrayList();
		try {			
			while(rsSet.next()) {
				Results res = new Results();
				res.setcandidateName(rsSet.getString("Name"));
				res.setBelongTo(rsSet.getString("partyName"));
				res.setAlocatedSymbol(rsSet.getString("symbolName"));
				res.setVoteCount(rsSet.getInt("voteCount"));
				emp.add(res);
			}
		}catch(Exception e) {
			System.out.println("Error in alterating the Array");
			throw e;
		}
		return emp;
	}

	
}
