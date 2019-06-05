package chatapplication;


import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;


public class ChatApp {
	
	public static void main(String[] args ) {
		ChatApp c = new ChatApp();
		c.runProgram();
	}
	
	public void runProgram() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginWindow loginWindow = new LoginWindow();
            }
        });	
        
		String DB_URL = "jdbc:mysql://localhost:3306/testDB?useSSL=false";
		String USER = "root";
		String PASS = "password"; 
		
		//throws error if db doesn't exist.
		try (Connection con = DriverManager.getConnection(DB_URL,USER,PASS); Statement stmt = con.createStatement();) {
		    	String SQL = "SELECT * FROM logindatabase.LoginInfo";
		    	ResultSet rs = stmt.executeQuery(SQL);
		    }
		    
		    // Handle any errors that may have occurred.
		    catch (SQLException e) {
		        e.printStackTrace();
		    }
	} 
}
