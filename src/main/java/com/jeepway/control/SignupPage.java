package com.jeepway.control;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;

import com.jeepway.model.User;
import com.jeepway.utils.DBUserService;
import com.jeepway.view.SignupPageUI;

public class SignupPage extends SignupPageUI implements ActionListener{
	/**
	 * Main method
	 */
	public static void main(String[] args) {
		SignupPage window = new SignupPage();
		window.setVisible(true);
	}
	
	/**
	 * Create the frame
	 */
	public SignupPage() {
		super();
		btnPasswordShow.addActionListener(this);
		btnSignUp.addActionListener(this);
		btnLogIn.addActionListener(this);
		lblHyperlink.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        try {
		            Desktop.getDesktop().browse(new URI("https://hackmd.io/@ORAzzQWQ10/BJXwQZWIh#Sign-up%E9%A0%81%E9%9D%A2%E6%8C%87%E5%BC%95"));
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
        	if(btnPasswordShow.isSelected()) 
        		txtPassword.setEchoChar((char)0);
        	else 
        		txtPassword.setEchoChar('*');
        }
		else if (e.getSource() == btnSignUp) {
	        if (this.checkSignup() == true) {
	        	this.insertSignup();
	        }
	        else
	        	return;
		}
		else if (e.getSource() == btnLogIn) {
			LoginPage login = new LoginPage();
			login.setVisible(true);
			this.dispose();
		}
    }

	/**
	 * Method to check signup data
	 */
	private boolean checkSignup(){
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
        if ( !(phone.matches("[0-9]+")) ){	// Check if there are only numbers.
        	JOptionPane.showMessageDialog(this, "Please enter only numbers at phone field.");
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
	 * Method to create a new user into database
	 */
	private void insertSignup() {
		String username = txtUsername.getText();
		String email = txtEmail.getText();
		String phone = txtPhone.getText();
	    String password = new String(txtPassword.getPassword());
	    
	    int updatedRowCount = DBUserService.createUser(new User(-1, username, email, phone, password));
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
