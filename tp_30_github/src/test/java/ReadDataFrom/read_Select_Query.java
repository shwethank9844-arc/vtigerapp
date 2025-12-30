package ReadDataFrom;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class read_Select_Query {
public static void main(String[] args) throws SQLException {
	//create an object for a driver
	Driver driver=new Driver();
	//register the driver
	DriverManager.registerDriver(driver);
	//get the connection to db 
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/hotel","root","root");
	
	//create query
	 Statement state = conn.createStatement();
	String query="select*from hotel";
	//execute
	ResultSet res = state.executeQuery(query);
	while(res.next()) {
	System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getString(3));
	}
	//close the db
	conn.close();
}
}
