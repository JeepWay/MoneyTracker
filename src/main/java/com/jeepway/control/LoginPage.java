package com.jeepway.control;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;

import com.jeepway.model.User;
import com.jeepway.utils.DBUserService;
import com.jeepway.view.LoginPageUI;

public class LoginPage extends LoginPageUI implements ActionListener{
	/**
	 * Main method
	 */
	public static void main(String[] args) {
		LoginPage window = new LoginPage();
		window.setVisible(true);
	}
	
	/**
	 * Create the frame
	 */
	public LoginPage() {
		super();
		btnPasswordShow.addActionListener(this);
		btnLogIn.addActionListener(this);
		btnSignUp.addActionListener(this);
		lblHyperlink.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        try {
		            Desktop.getDesktop().browse(new URI("https://hackmd.io/@ORAzzQWQ10/BJXwQZWIh#Login%E9%A0%81%E9%9D%A2%E6%8C%87%E5%BC%95"));
		        } catch (IOException | URISyntaxException e1) {
		            e1.printStackTrace();
		        }
		    }
		});
	}
	
	/**
	 * Override actionListener's method.
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
    {
		if (e.getSource() == btnPasswordShow) {
        	if (btnPasswordShow.isSelected()) 
        		txtPassword.setEchoChar((char)0);
        	else 
        		txtPassword.setEchoChar('*');
        }
		else if (e.getSource() == btnLogIn) {
	        if (this.checkLogin() == true) {
	        	this.validateUser();	
	        }
	        else
	        	return;
		}
		else if (e.getSource() == btnSignUp) {
		 	SignupPage signup = new SignupPage();
		 	signup.setVisible(true);
		 	this.dispose();
		}
    }
	
	/**
	 * Method to check login data
	 */
	private boolean checkLogin(){
		String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());
        
        if(username.equals("")) {
        	JOptionPane.showMessageDialog(this, "Please enter username.");
        	return false;
        }
        if(password.equals("")) {
        	JOptionPane.showMessageDialog(this, "Please enter password.");
        	return false;
        }
        if ( !(password.matches("[a-z0-9A-Z]+")) ){	// Check if there are only numbers and English characters.
        	JOptionPane.showMessageDialog(this, "Please enter only numbers and letters at password field.");
        	return false;
        }
        return true;
	}
	
	/**
	 * Method to validate login data in database
	 */
	private void validateUser() {
		String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());
        
        User user = DBUserService.validateUserLogin(username, password);
		if (user != null) {
			JOptionPane.showMessageDialog(this, "Login successfully.\n Hello " + username + "!");
			HomePage home = new HomePage(user);
			home.setVisible(true);
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "Incorrect username or password.");
			return;
		}
	}
}
