package ReadDataFrom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class nonSelect_query {

public static void main(String[] args) throws SQLException {
	//create object for driver
	Driver driver = new Driver();
	//register the driver
	DriverManager.registerDriver(driver);
	
	
	String query="INSERT INTO employee.new_table VALUES(?,?,?)";
//	String db="jdbc:mysql://localhost:3307/employee";
//	String username="root";
//	String password="root";
	//get connection from the database
	 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/employee","root","root");
	 
	 //create query
	 PreparedStatement state = conn.prepareStatement(query);
	 state.setString(1, "NTR");
	 //execute 
	 state.execute();
	 //close db
	 conn.close();
	 
	 
	 
}
}
