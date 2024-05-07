package com.jeepway.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;

public class SignupPageUI extends JFrame {
	/**
	 * Declare GUI components
	 */
	public JPanel panelWelocme, panelSignup; 
	public JLabel lblTextSignup, lblTextUsername, lblTextEmail, lblTextPhone, lblTextPassword;
	public JLabel lblIconWelcome, lblIconUsername, lblIconEmail, lblIconPhone, lblIconPassword;
	public JLabel lblHyperlink;
	public JTextField txtUsername, txtEmail, txtPhone;
	public JPasswordField txtPassword;
	public JCheckBox btnPasswordShow;
	public JButton btnSignUp, btnLogIn;
	
	/**
	 * Main method
	 */
	public static void main(String[] args) {
		SignupPageUI window = new SignupPageUI();
		window.setVisible(true);
	}
	
	/**
	 * Create the frame.
	 */
	public SignupPageUI() {
		setTitle("Signup Page");
		setBackground(Color.WHITE);
		setBounds(200, 100, 1100, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		panelWelocme = new JPanel();
		panelWelocme.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
		panelWelocme.setBackground(Color.WHITE);
		panelWelocme.setBounds(0, 0, 700, 563);
		panelWelocme.setLayout(null);
		getContentPane().add(panelWelocme);
		
		lblIconWelcome = new JLabel("New label");
		lblIconWelcome.setBounds(93, 31, 512, 512);
		lblIconWelcome.setIcon(new ImageIcon(SignupPageUI.class.getResource("/icon/signup_background.png")));
		panelWelocme.add(lblIconWelcome);
		
		panelSignup = new JPanel();
		panelSignup.setBackground(new Color(102, 102, 255));
		panelSignup.setBounds(700, 0, 386, 563);
		panelSignup.setLayout(null);
		getContentPane().add(panelSignup);
		
		lblTextSignup = new JLabel("Signup");
		lblTextSignup.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextSignup.setForeground(Color.WHITE);
		lblTextSignup.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblTextSignup.setBounds(100, 20, 195, 40);
		panelSignup.add(lblTextSignup);
		
		lblTextUsername = new JLabel("Username");
		lblTextUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextUsername.setForeground(Color.WHITE);
		lblTextUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTextUsername.setBounds(90, 78, 195, 30);
		panelSignup.add(lblTextUsername);
		
		txtUsername = new JTextField(15);
		txtUsername.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
		txtUsername.setBackground(new Color(102, 102, 255));
		txtUsername.setFont(new Font("Serif", Font.PLAIN, 20));
		txtUsername.setBounds(90, 108, 254, 30);
		panelSignup.add(txtUsername);
		
		lblIconUsername = new JLabel("Username");
		lblIconUsername.setIcon(new ImageIcon(SignupPageUI.class.getResource("/icon/user_50px.png")));
		lblIconUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblIconUsername.setForeground(Color.WHITE);
		lblIconUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblIconUsername.setBounds(20, 88, 50, 50);
		panelSignup.add(lblIconUsername);
		
		lblIconPassword = new JLabel("Username");
		lblIconPassword.setIcon(new ImageIcon(SignupPageUI.class.getResource("/icon/password_50px.png")));
		lblIconPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblIconPassword.setForeground(Color.WHITE);
		lblIconPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblIconPassword.setBounds(20, 328, 50, 50);
		panelSignup.add(lblIconPassword);
		
		lblTextPassword = new JLabel("Password");
		lblTextPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextPassword.setForeground(Color.WHITE);
		lblTextPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTextPassword.setBounds(90, 318, 195, 30);
		panelSignup.add(lblTextPassword);
		
		txtEmail = new JTextField(15);
		txtEmail.setFont(new Font("Serif", Font.PLAIN, 20));
		txtEmail.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
		txtEmail.setBackground(new Color(102, 102, 255));
		txtEmail.setBounds(90, 188, 254, 30);
		panelSignup.add(txtEmail);
		
		lblTextEmail = new JLabel("Email");
		lblTextEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextEmail.setForeground(Color.WHITE);
		lblTextEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTextEmail.setBounds(90, 158, 195, 30);
		panelSignup.add(lblTextEmail);
		
		lblIconEmail = new JLabel("Username");
		lblIconEmail.setIcon(new ImageIcon(SignupPageUI.class.getResource("/icon/email_50px.png")));
		lblIconEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblIconEmail.setForeground(Color.WHITE);
		lblIconEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblIconEmail.setBounds(20, 168, 50, 50);
		panelSignup.add(lblIconEmail);
		
		txtPhone = new JTextField(15);
		txtPhone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtPhone.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
		txtPhone.setBackground(new Color(102, 102, 255));
		txtPhone.setBounds(90, 268, 254, 30);
		panelSignup.add(txtPhone);
		
		lblTextPhone = new JLabel("Phone");
		lblTextPhone.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextPhone.setForeground(Color.WHITE);
		lblTextPhone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTextPhone.setBounds(90, 238, 195, 30);
		panelSignup.add(lblTextPhone);
		
		lblIconPhone = new JLabel("Username");
		lblIconPhone.setIcon(new ImageIcon(SignupPageUI.class.getResource("/icon/phone_50px.png")));
		lblIconPhone.setHorizontalAlignment(SwingConstants.LEFT);
		lblIconPhone.setForeground(Color.WHITE);
		lblIconPhone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblIconPhone.setBounds(20, 248, 50, 50);
		panelSignup.add(lblIconPhone);
		
		txtPassword = new JPasswordField(15);
		txtPassword.setBackground(new Color(102, 102, 255));
		txtPassword.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
		txtPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtPassword.setBounds(90, 348, 254, 30);
		panelSignup.add(txtPassword);
		
		btnPasswordShow = new JCheckBox("Show Password");
		btnPasswordShow.setForeground(Color.WHITE);
		btnPasswordShow.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnPasswordShow.setBackground(new Color(102, 102, 255));
		btnPasswordShow.setBounds(90, 394, 254, 20);
		panelSignup.add(btnPasswordShow);
		
		btnSignUp = new JButton("SIGN UP");
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSignUp.setBackground(new Color(255, 51, 51));
		btnSignUp.setBounds(90, 442, 254, 40);
		panelSignup.add(btnSignUp);
		
		btnLogIn = new JButton("LOG IN");
		btnLogIn.setForeground(Color.WHITE);
		btnLogIn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLogIn.setBackground(new Color(60, 60, 255));
		btnLogIn.setBounds(128, 500, 182, 40);
		panelSignup.add(btnLogIn);
		
		lblHyperlink = new JLabel("");
		lblHyperlink.setIcon(new ImageIcon(SignupPageUI.class.getResource("/icon/question.png")));
		lblHyperlink.setBounds(344, 513, 32, 40);
		panelSignup.add(lblHyperlink);
	}
}
