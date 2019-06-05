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
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatWindow extends JFrame {
	private Date date;
	private String username;
	public ChatWindow(String username) {
		this.date = new Date();
		this.username = username;
		buildWindow();
	}
	
	public void buildWindow() {
        JFrame frame3 = new JFrame("ChatApplication_HomeScreen");
        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container pane = frame3.getContentPane();
        pane.setPreferredSize(new Dimension(400, 400));
        frame3.pack();
        frame3.setVisible(true);

        
        JButton button;
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
   
        Label title = new Label("Chat_Interface");
        title.setFont(new Font("Serif", Font.BOLD, 20));
        c.gridy = 0;
        pane.add(title, c);
        
        JTextArea  enteredText = new JTextArea(15, 32);
        c.gridy = 1;
        pane.add(enteredText, c);
        enteredText.setEditable(false);
        
        JTextField userInputField = new JTextField(10);
		c.gridy = 5; 
        pane.add(userInputField, c);
           
        button = new JButton("Send");
        button.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	enteredText.append("[" + date.getHours() + ":" + date.getMinutes() + "] " + username + " : " + userInputField.getText());
            	enteredText.append("\n");            	
            	userInputField.setText("");
            }
        });
        c.gridy = 6;
        pane.add(button, c);  
	}
}
