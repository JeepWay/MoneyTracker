package com.jeepway.control;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.net.URI;
import java.io.IOException;
import java.net.URISyntaxException;

import com.jeepway.view.PanelCardAddIncomeUI;
import com.jeepway.constant.RecordConstants;
import com.jeepway.model.Record;
import com.jeepway.utils.DBRecordsService;


public class PanelCardAddIncome extends PanelCardAddIncomeUI implements ActionListener{
	/**
	 * Receive userid
	 */
	private int userID;

	/**
	 * InnerClass : SwingCalendar(extends JFrame) 
	 */
	private class innerCalendar extends SwingCalendar{
		public innerCalendar(){
			super();
		}
		
		@Override
		public void getSelectDate() {
		    super.getSelectDate();
		    txtDate.setText(SELECTDATE);
		    this.dispose();  // dispose after choose date
		}
	}
	
	/**
	 * Create the panel.
	 */
	public PanelCardAddIncome(int uid) {
		super();
		this.userID = uid;
		// add actionListener
		btnClear.addActionListener(this);
		btnAdd.addActionListener(this);
		btnCalendar.addActionListener(this);

		lblHyperlink.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        try {
		            Desktop.getDesktop().browse(new URI("https://hackmd.io/@ORAzzQWQ10/BJXwQZWIh#AddIncome%E9%A0%81%E9%9D%A2%E6%8C%87%E5%BC%95"));
		        } catch (IOException | URISyntaxException e1) {
		            e1.printStackTrace();
		        }
		    }
		});
	}
	
	/**
	 * Override actionListener's method.
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnClear){
			this.clearInput();
		}
		else if(e.getSource() == btnAdd) {
			if (this.checkAddIncome() == true)
				this.insertIncome();
	        else
	        	return;
		}
		
		else if(e.getSource() == btnCalendar) {
			innerCalendar calendar = new innerCalendar();
			calendar.setVisible(true);
		}
			
	}
	
	/**
	 * Clear user input of income
	 */
	public void clearInput() {
		this.boxCategory.setSelectedItem(null);
		this.txtDate.setText("");
		this.txtAmount.setText("");
		this.txtDetail.setText("");
	}
	
	/**
	 * Method to check expense data
	 */ 
	private boolean checkAddIncome(){
		String date = txtDate.getText();
		String amount = txtAmount.getText();
        
        if(boxCategory.getSelectedItem() == null) {
        	JOptionPane.showMessageDialog(this, "Please select category.");
        	return false;
        }
        if(date.equals("")) {
        	JOptionPane.showMessageDialog(this, "Please select date.");
        	return false;
        }
        if(amount.equals("") ) {
        	JOptionPane.showMessageDialog(this, "Please enter amount.");
        	return false;
        }
        if ( !(amount.matches("[-+]?\\d+")) ){
        	JOptionPane.showMessageDialog(this, "Please enter only integers.");
        	return false;
        }
        if(Integer.parseInt(amount) <= 0 ) {
        	JOptionPane.showMessageDialog(this, "Please enter positive amount.");
        	return false;
        }
        return true;
	}
	
	/**
	 * Method to insert an new income data into database
	 */
	private void insertIncome() {
		String category = (String)boxCategory.getSelectedItem();
		String date = txtDate.getText();
		int amount = Integer.parseInt(txtAmount.getText());
        String detail = txtDetail.getText();
        
        int updatedRowCount = DBRecordsService.createRecord(new Record(-1, this.userID, category, date, amount, RecordConstants.TYPEINCOME, detail));
        if(updatedRowCount == 1) {
	    	JOptionPane.showMessageDialog(this, "Record income information successfully.");
	    	this.clearInput();
        }
        else if(updatedRowCount == -1 || updatedRowCount == -2) { 
        	JOptionPane.showMessageDialog(this, "Something wrong. \nUnable to record income information.");
        }
	}
}
