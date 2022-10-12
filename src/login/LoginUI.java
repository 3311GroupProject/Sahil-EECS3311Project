package login;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;





public class LoginUI extends JFrame implements ActionListener{
	
	private static JLabel usernameLabel , passwordLabel;
	private static JTextField usernameText;
	private static JPasswordField passwordText;
	private static JButton loginButton;
	private static JPanel loginPanel;
	private static String username , password ;
	private static JFrame frame;
	
	// Calling the constructor
	 
	public static String getUsername() {
		return username;
	}



	public static String getPassword() {
		return password;
	}



	public LoginUI(){
		
		//usernameLabel= new JLabel();
		//usernameLabel = new JLabel("Username");
		//usernameText= new JTextField(26);  // Setting length of user to be 26 character
		
		//passwordLabel=new JLabel();
		//passwordLabel=new JLabel("Password");
		//passwordText= new JPasswordField();
		
		
		//loginButton= new JButton("Login");
		
		
		//Creating Panel
		
		//
		//loginPanel =new JPanel(new GridLayout(3, 1));
		
		//loginPanel.add(usernameLabel);
		//loginPanel.add(usernameText);
		
		//loginPanel.add(passwordLabel);
		//loginPanel.add(passwordText);	
		
		//loginPanel.add(loginButton);
		
		
		//add(loginPanel, BorderLayout.CENTER);
		
		JFrame frame = new JFrame();
		JPanel loginPanel = new JPanel();
		frame.setSize(350, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(loginPanel);
		
		loginPanel.setLayout(null);
		
		usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(10, 20, 80, 25);
		loginPanel.add(usernameLabel);
		
		usernameText = new JTextField(26);
		usernameText.setBounds(80, 20, 200, 25);
		loginPanel.add(usernameText);
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(10, 50, 80, 25);
		loginPanel.add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(80, 50, 200, 25);
		loginPanel.add(passwordText);
		
		//Action when click login  button 
		loginButton = new JButton("Submit!");
		loginButton.setBounds(125, 80, 80, 25);
		loginButton.addActionListener(this);
		
		loginPanel.add(loginButton);
	
		frame.setVisible(true);
		
		//page title
		setTitle("Login Page") ;
	}
	

	
	public void actionPerformed(ActionEvent e) {

		username= usernameText.getText().toUpperCase();
		password= passwordText.getText(); 
		
		System.out.println(username);
		System.out.println(password);
		
		ProxyLogin proxy =new ProxyLogin(username,password);
		proxy.doValidate(username, password, password);
		
		
		
		
		 
		
		
		
		
		
		
	}
	
	
	
	
	
	




	public static void  main(String[] args) {
		
		
		try {
			
			LoginUI login1 = new LoginUI();
			//login1.setSize(450, 130);;
			//login1.setVisible(true);
	
		}
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
				
		
		
	}










	
}


