package chatapplication;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class LoginWindow extends JFrame {
	private int userCount;
	public LoginWindow() {
		this.userCount = 0;
		buildWindow();
	}
	
	public void buildWindow() {
		JFrame frame = new JFrame("ChatApplication_Login_Page");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.addWindowListener(new java.awt.event.WindowAdapter() {
	    @Override
	    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
	    	System.exit(0);
	     	}
	    });
		
	    Container pane = frame.getContentPane();
        pane.setPreferredSize(new Dimension(600, 600));
        JButton button;
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        Label programName = new Label("Login_Page");
        c.gridy = 1;  
        programName.setFont(new Font("Serif", Font.BOLD, 20));
        pane.add(programName, c);
  
        Label username = new Label("Username : "); 
        c.gridy = 2;
		pane.add(username, c);
        
        
        JTextField usernameField = new JTextField(5);
		c.gridy = 2; 
        pane.add(usernameField, c);

        
        Label password = new Label("Password : "); 
        c.gridy = 3 ;
		pane.add(password, c);
        
        JTextField passwordField = new JTextField(5);
        c.gridy = 3;
        pane.add(passwordField, c);

        button = new JButton("Login");
        button.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                login(usernameField.getText(), passwordField.getText()); //opens up registration page
            }
        });
        c.gridy = 4;
		pane.add(button, c);
        
        button = new JButton("Register");
        button.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                RegistrationWindow r = new RegistrationWindow(userCount);
            }
        });
        c.gridy = 4;
		pane.add(button, c);
        frame.pack();
        frame.setVisible(true);
	}
	
	public void login(String username, String password) {
		String DB_URL = "jdbc:mysql://localhost:3306/testDB?useSSL=false";
		String USER = "root";
		String PASS = "password"; 	
		ResultSet rs = null;
		int count = 0;
	    try (Connection con = DriverManager.getConnection(DB_URL,USER,PASS); Statement stmt = con.createStatement();) {	    	
			PreparedStatement ps = con.prepareStatement("Select UserID, UserPassword from logindatabase.LoginInfo Where logindatabase.LoginInfo.UserID = ? and logindatabase.LoginInfo.UserPassword = ?;");
			ps.setObject(1, username);
			ps.setObject(2, password);
            rs = ps.executeQuery();
            while(rs.next()){
			    count ++;
			}
	        if (count==1){
	           //open up login screen
	        	System.out.println("login info verified, redirecting to home screen");
	        	ChatWindow c = new ChatWindow(username);
	        }
	        else {
	        	//display error message
	        	System.out.println("invalid login info");
	        }
	    }
	    catch (SQLException e) {
	    	e.printStackTrace();
	    }
	}
}
