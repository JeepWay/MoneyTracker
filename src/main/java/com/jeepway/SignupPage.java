package com.jeepway;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;

import com.jeepway.utils.DBUserService;

public class SignupPage extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Declare GUI components
	 */
	private JPanel panelWelocme, panelSignup; 
	private JLabel iconWelcome, lblSignup, lblUsername, lblEmail, lblPhone, lblPassword;
	private JLabel iconUsername, iconEmail, iconPhone, iconPassword;
	private JTextField txtUsername, txtEmail, txtPhone;
	private JPasswordField txtPassword;
	private JCheckBox btnPasswordShow;
	private JButton btnSignUp, btnLogIn;
	private JLabel hyperlink;
	
	/**
	 * Main method
	 */
	public static void main(String[] args) {
		SignupPage window = new SignupPage();
		window.setVisible(true);
	}
	
	/**
	 * Create the frame.
	 */
	public SignupPage() {
		setTitle("Signup Page");
		setBackground(new Color(255, 255, 255));
		setBounds(200, 100, 1100, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		panelWelocme = new JPanel();
		panelWelocme.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		panelWelocme.setBackground(new Color(255, 255, 255));
		panelWelocme.setBounds(0, 0, 700, 563);
		panelWelocme.setLayout(null);
		getContentPane().add(panelWelocme);
		
		iconWelcome = new JLabel("New label");
		iconWelcome.setBounds(93, 31, 512, 512);
		iconWelcome.setIcon(new ImageIcon(SignupPage.class.getResource("/icon/signup_background.png")));
		panelWelocme.add(iconWelcome);
		
		panelSignup = new JPanel();
		panelSignup.setBackground(new Color(102, 102, 255));
		panelSignup.setBounds(700, 0, 386, 563);
		panelSignup.setLayout(null);
		getContentPane().add(panelSignup);
		
		lblSignup = new JLabel("Signup");
		lblSignup.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignup.setForeground(new Color(255, 255, 255));
		lblSignup.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblSignup.setBounds(100, 20, 195, 40);
		panelSignup.add(lblSignup);
		
		lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblUsername.setBounds(90, 78, 195, 30);
		panelSignup.add(lblUsername);
		
		txtUsername = new JTextField(15);
		txtUsername.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtUsername.setBackground(new Color(102, 102, 255));
		txtUsername.setFont(new Font("Serif", Font.PLAIN, 20));
		txtUsername.setBounds(90, 108, 254, 30);
		panelSignup.add(txtUsername);
		
		iconUsername = new JLabel("Username");
		iconUsername.setIcon(new ImageIcon(SignupPage.class.getResource("/icon/user_50px.png")));
		iconUsername.setHorizontalAlignment(SwingConstants.LEFT);
		iconUsername.setForeground(Color.WHITE);
		iconUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		iconUsername.setBounds(20, 88, 50, 50);
		panelSignup.add(iconUsername);
		
		iconPassword = new JLabel("Username");
		iconPassword.setIcon(new ImageIcon(SignupPage.class.getResource("/icon/password_50px.png")));
		iconPassword.setHorizontalAlignment(SwingConstants.LEFT);
		iconPassword.setForeground(Color.WHITE);
		iconPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		iconPassword.setBounds(20, 328, 50, 50);
		panelSignup.add(iconPassword);
		
		lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPassword.setBounds(90, 318, 195, 30);
		panelSignup.add(lblPassword);
		
		txtEmail = new JTextField(15);
		txtEmail.setFont(new Font("Serif", Font.PLAIN, 20));
		txtEmail.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtEmail.setBackground(new Color(102, 102, 255));
		txtEmail.setBounds(90, 188, 254, 30);
		panelSignup.add(txtEmail);
		
		lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmail.setBounds(90, 158, 195, 30);
		panelSignup.add(lblEmail);
		
		iconEmail = new JLabel("Username");
		iconEmail.setIcon(new ImageIcon(SignupPage.class.getResource("/icon/email_50px.png")));
		iconEmail.setHorizontalAlignment(SwingConstants.LEFT);
		iconEmail.setForeground(Color.WHITE);
		iconEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		iconEmail.setBounds(20, 168, 50, 50);
		panelSignup.add(iconEmail);
		
		txtPhone = new JTextField(15);
		txtPhone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtPhone.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtPhone.setBackground(new Color(102, 102, 255));
		txtPhone.setBounds(90, 268, 254, 30);
		panelSignup.add(txtPhone);
		
		lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPhone.setBounds(90, 238, 195, 30);
		panelSignup.add(lblPhone);
		
		iconPhone = new JLabel("Username");
		iconPhone.setIcon(new ImageIcon(SignupPage.class.getResource("/icon/phone_50px.png")));
		iconPhone.setHorizontalAlignment(SwingConstants.LEFT);
		iconPhone.setForeground(Color.WHITE);
		iconPhone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		iconPhone.setBounds(20, 248, 50, 50);
		panelSignup.add(iconPhone);
		
		txtPassword = new JPasswordField(15);
		txtPassword.setBackground(new Color(102, 102, 255));
		txtPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtPassword.setBounds(90, 348, 254, 30);
		panelSignup.add(txtPassword);
		
		btnPasswordShow = new JCheckBox("Show Password");
		btnPasswordShow.setForeground(new Color(255, 255, 255));
		btnPasswordShow.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnPasswordShow.setBackground(new Color(102, 102, 255));
		btnPasswordShow.setBounds(90, 394, 254, 20);
		btnPasswordShow.addActionListener(this);
		panelSignup.add(btnPasswordShow);
		
		btnSignUp = new JButton("SIGN UP");
		btnSignUp.setForeground(new Color(255, 255, 255));
		btnSignUp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSignUp.setBackground(new Color(255, 51, 51));
		btnSignUp.setBounds(90, 442, 254, 40);
		btnSignUp.addActionListener(this);
		panelSignup.add(btnSignUp);
		
		btnLogIn = new JButton("LOG IN");
		btnLogIn.setForeground(new Color(255, 255, 255));
		btnLogIn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLogIn.setBackground(new Color(60, 60, 255));
		btnLogIn.setBounds(128, 500, 182, 40);
		btnLogIn.addActionListener(this);
		panelSignup.add(btnLogIn);
		
		hyperlink = new JLabel("");
		hyperlink.setIcon(new ImageIcon(SignupPage.class.getResource("/icon/question.png")));
		hyperlink.setBounds(344, 513, 32, 40);
		panelSignup.add(hyperlink);
		hyperlink.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        try {
		            Desktop.getDesktop().browse(new URI("https://hackmd.io/@ORAzzQWQ10/BJXwQZWIh#Sign-up頁面指引"));
		        } catch (IOException | URISyntaxException e1) {
		            e1.printStackTrace();
		        }
		    }
		});
	}
	
	/**
	 * Override actionListener's method.
	 */
	public void actionPerformed(ActionEvent e) 
    {
		if (e.getSource() == btnPasswordShow) 
        {
        	if(btnPasswordShow.isSelected()) 
        		txtPassword.setEchoChar((char)0);
        	else 
        		txtPassword.setEchoChar('*');
        }
		else if (e.getSource() == btnSignUp) 
		{
	        if (this.checkSignup() == true) {
	        	this.insertSignup();
	        }
	        else
	        	return;
		}
		else if (e.getSource() == btnLogIn) 
		{
			LoginPage login = new LoginPage();
			login.setVisible(true);
			this.dispose();
		}
    }
	

	/**
	 * Method to check signup data
	 */
	public boolean checkSignup(){
		String username = txtUsername.getText();
		String email = txtEmail.getText();
		String phone = txtPhone.getText();
        String password = new String(txtPassword.getPassword());
        
        if(username.equals("")) {
        	JOptionPane.showMessageDialog(this, "Please enter username.");
        	return false;
        }
        if(email.equals("") || !email.matches("^.+@.+\\..+$")) {
        	JOptionPane.showMessageDialog(this, "Please enter valid email.");
        	return false;
        }
        if(phone.equals("") ) {		
        	JOptionPane.showMessageDialog(this, "Please enter phone.");
        	return false;
        }
        if ( !(phone.matches("[0-9]+")) ){		// 檢查是否只有數字
        	JOptionPane.showMessageDialog(this, "Please enter only numbers at phone field.");
        	return false;
        }
        if(password.equals("")) {
        	JOptionPane.showMessageDialog(this, "Please enter password.");
        	return false;
        }
        if ( !(password.matches("[a-z0-9A-Z]+")) ){		// 檢查是否只有數字和英文
        	JOptionPane.showMessageDialog(this, "Please enter only numbers and letters at password field.");
        	return false;
        }
        
        return true;
	}
	

	/**
	 * Method to create a new user into database
	 */
	public void insertSignup() {
		String username = txtUsername.getText();
		String email = txtEmail.getText();
		String phone = txtPhone.getText();
	    String password = new String(txtPassword.getPassword());
	    
	    int updatedRowCount = DBUserService.createUser(username, email, phone, password);
	    if(updatedRowCount == 1) {
	    	JOptionPane.showMessageDialog(this, "Registration successful. \nYou will be redirected to the login page.");
	    	LoginPage login = new LoginPage();	// redirect to login page
			login.setVisible(true);
	    	this.dispose();
		}
		else if(updatedRowCount == -1) { 
			JOptionPane.showMessageDialog(this, "Registration failed. \nThe username, email, or phone number had been already registered.");
		}
		else if(updatedRowCount == -2) {
			JOptionPane.showMessageDialog(this, "Something wrong. \nRegistration failed. \n Please re-register.");
		}	    	
	}
}
