package chatapplication;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RegistrationWindow extends JFrame{
	public RegistrationWindow(int userCount) {
		buildWindow();
	}
	
	public void buildWindow() {
	       JFrame frame2 = new JFrame("ChatApplication_Registration_Page");
	        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        Container pane = frame2.getContentPane();
	        pane.setPreferredSize(new Dimension(600, 600));
	        frame2.pack();
	        frame2.setVisible(true);
	            
	        JButton button;
	        pane.setLayout(new GridBagLayout());
	        GridBagConstraints c = new GridBagConstraints();

	        c.fill = GridBagConstraints.HORIZONTAL;

	        
	        Label title = new Label("Registration_Page"); 
	        title.setFont(new Font("Serif", Font.BOLD, 20));
	        c.gridy = 0;
			pane.add(title, c);
	 
	        Label username = new Label("Username : "); 
	        c.gridy = 1;
			pane.add(username, c);
			JTextField usernameField = new JTextField(5);
			c.gridy = 1; 
	        pane.add(usernameField, c);
	        
	        Label password = new Label("Password : "); 
	        c.gridy = 2;
			pane.add(password, c);
	        JTextField passwordField = new JTextField(5);
			c.gridy = 2; 
	        pane.add(passwordField, c);
	            
	        Label passwordConfirm = new Label("Confirm password: "); 
	        c.gridy = 3;
			pane.add(passwordConfirm, c);
	        JTextField passwordConfirmField = new JTextField(5);
			c.gridy = 3; 
	        pane.add(passwordConfirmField, c);
	        
	        Label emailAddress = new Label("Email Address : "); 
	        c.gridy = 4;
			pane.add(emailAddress, c);
	        JTextField emailAddressField = new JTextField(5);
			c.gridy = 4; 
	        pane.add(emailAddressField, c);
	                
	        button = new JButton("Register");
	        button.addActionListener( new ActionListener() {
	            public void actionPerformed(ActionEvent e)
	            {
	            	//todo: test for valid input, below not working
	            	//if ((usernameField.getText && (passwordField.getText() == passwordConfirmField.getText()) ) {//email & username not registered yet, etc  	
	            	newUser(usernameField.getText(), passwordField.getText(), emailAddressField.getText());
	            	frame2.dispatchEvent(new WindowEvent(frame2, WindowEvent.WINDOW_CLOSING));    		
	            	//}
	            }
	        });
	        c.gridy = 5;
	        pane.add(button, c);
	}
	
	
	public void newUser(String username, String password, String email) {
	    RegisterUser(username, password, email);
	}
	
	public void RegisterUser(String username, String password, String email ) {
		String SQL = "INSERT INTO logindatabase.LoginInfo (U_Id, UserID, UserPassword, Email)  VALUES (NULL, \"" + username +" \", \"" + password + "  \", \"" + email + "\");";	
		String DB_URL = "jdbc:mysql://localhost:3306/testDB?useSSL=false";	
		String USER = "root";
		String PASS = "password"; 	
		
	    try (Connection con = DriverManager.getConnection(DB_URL,USER,PASS); Statement stmt = con.createStatement();) {	    	
            Statement st = con.createStatement();
            st.executeUpdate(SQL);

	    }
	    // Handle any errors that may have occurred.
	    catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
