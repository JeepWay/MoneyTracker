package com.jeepway.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;

public class LoginPageUI extends JFrame {
	/**
	 * Declare GUI components
	 */
	public JPanel panelWelocme, panelSignup; 
	public JLabel lblTextWelcome1, lblTextWelcome2, lblIconWelcome;
	public JLabel lblTextLogin, lblTextUsername, lblTextPassword;
	public JLabel lblIconUsername, lblIconPassword;
	public JLabel lblHyperlink;
	public JTextField txtUsername;
	public JPasswordField txtPassword;
	public JCheckBox btnPasswordShow;
	public JButton btnLogIn, btnSignUp;
	
	/**
	 * Main method
	 */
	public static void main(String[] args) {
		LoginPageUI window = new LoginPageUI();
		window.setVisible(true);
	}
	
	/**
	 * Create the frame.
	 */
	public LoginPageUI() {
		setTitle("Login Page");
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
		
		lblIconWelcome = new JLabel("New label");
		lblIconWelcome.setBounds(138, 108, 441, 442);
		lblIconWelcome.setIcon(new ImageIcon(LoginPageUI.class.getResource("/icon/login.png")));
		panelWelocme.add(lblIconWelcome);
		
		lblTextWelcome1 = new JLabel("Welcome To");
		lblTextWelcome1.setBounds(31, 20, 195, 41);
		lblTextWelcome1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblTextWelcome1.setForeground(new Color(255, 0, 0));
		panelWelocme.add(lblTextWelcome1);
		
		lblTextWelcome2 = new JLabel("Money Tracker");
		lblTextWelcome2.setBounds(163, 57, 195, 41);
		lblTextWelcome2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblTextWelcome2.setForeground(new Color(102, 102, 255));
		panelWelocme.add(lblTextWelcome2);
		
		panelSignup = new JPanel();
		panelSignup.setBackground(new Color(102, 102, 255));
		panelSignup.setBounds(700, 0, 386, 563);
		panelSignup.setLayout(null);
		getContentPane().add(panelSignup);
		
		lblTextLogin = new JLabel("Login");
		lblTextLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextLogin.setForeground(new Color(255, 255, 255));
		lblTextLogin.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblTextLogin.setBounds(100, 20, 195, 40);
		panelSignup.add(lblTextLogin);
		
		lblTextUsername = new JLabel("Username");
		lblTextUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextUsername.setForeground(Color.WHITE);
		lblTextUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTextUsername.setBounds(90, 118, 195, 30);
		panelSignup.add(lblTextUsername);
		
		txtUsername = new JTextField(15);
		txtUsername.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtUsername.setBackground(new Color(102, 102, 255));
		txtUsername.setFont(new Font("Serif", Font.PLAIN, 20));
		txtUsername.setBounds(90, 148, 254, 30);
		panelSignup.add(txtUsername);
		
		lblIconUsername = new JLabel("Username");
		lblIconUsername.setIcon(new ImageIcon(LoginPageUI.class.getResource("/icon/user_50px.png")));
		lblIconUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblIconUsername.setForeground(Color.WHITE);
		lblIconUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblIconUsername.setBounds(20, 128, 50, 50);
		panelSignup.add(lblIconUsername);
		
		lblIconPassword = new JLabel("Username");
		lblIconPassword.setIcon(new ImageIcon(LoginPageUI.class.getResource("/icon/password_50px.png")));
		lblIconPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblIconPassword.setForeground(Color.WHITE);
		lblIconPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblIconPassword.setBounds(20, 236, 50, 50);
		panelSignup.add(lblIconPassword);
		
		lblTextPassword = new JLabel("Password");
		lblTextPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextPassword.setForeground(Color.WHITE);
		lblTextPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTextPassword.setBounds(90, 226, 195, 30);
		panelSignup.add(lblTextPassword);
		
		txtPassword = new JPasswordField(15);
		txtPassword.setBackground(new Color(102, 102, 255));
		txtPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtPassword.setBounds(90, 256, 254, 30);
		panelSignup.add(txtPassword);
		
		btnPasswordShow = new JCheckBox("Show Password");
		btnPasswordShow.setForeground(new Color(255, 255, 255));
		btnPasswordShow.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnPasswordShow.setBackground(new Color(102, 102, 255));
		btnPasswordShow.setBounds(90, 302, 254, 20);
		panelSignup.add(btnPasswordShow);
		
		btnLogIn = new JButton("LOG IN");
		btnLogIn.setForeground(new Color(255, 255, 255));
		btnLogIn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLogIn.setBackground(new Color(255, 51, 51));
		btnLogIn.setBounds(90, 368, 254, 40);
		panelSignup.add(btnLogIn);
		
		btnSignUp = new JButton("SIGN UP");
		btnSignUp.setForeground(new Color(255, 255, 255));
		btnSignUp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSignUp.setBackground(new Color(60, 60, 255));
		btnSignUp.setBounds(128, 426, 182, 40);
		panelSignup.add(btnSignUp);
		
		lblHyperlink = new JLabel("");
		lblHyperlink.setIcon(new ImageIcon(LoginPageUI.class.getResource("/icon/question.png")));
		lblHyperlink.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblHyperlink.setForeground(new Color(255, 255, 0));
		lblHyperlink.setBounds(344, 513, 32, 40);
		panelSignup.add(lblHyperlink);
	}
}
