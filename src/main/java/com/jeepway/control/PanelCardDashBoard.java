package com.jeepway.control;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.jeepway.view.PanelCardDashBoardUI;
import com.jeepway.utils.DBRecordsService;
import com.jeepway.constant.RecordConstants;

public class PanelCardDashBoard extends PanelCardDashBoardUI implements ActionListener{
	/**
	 * Receive userid
	 */
	private int userID;

	private Calendar cal = new GregorianCalendar();

	public PanelCardDashBoard(int uid) {
		super();
		this.userID = uid;
		btnSearch.addActionListener(this);
		// set range of year to select
		for(int i=cal.get(Calendar.YEAR)-10; i<=cal.get(Calendar.YEAR)+10; i++){
			boxSelectYear.addItem(i);
        }
		// show current month and year
		boxSelectMonth.setSelectedIndex(cal.get(Calendar.MONTH));	
		boxSelectYear.setSelectedItem(cal.get(Calendar.YEAR));	
		this.setActionPerformed();	
		this.loadStatistic();
	}
	
	/**
	 * Override actionListener's method.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			this.loadStatistic();
        }
	}
	
	/**
	 * Method to set hyperlink action
	 */
	private void setActionPerformed() {
		lblHyperlink.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        try {
		            Desktop.getDesktop().browse(new URI("https://hackmd.io/@ORAzzQWQ10/BJXwQZWIh#DashBoard%E9%A0%81%E9%9D%A2%E6%8C%87%E5%BC%95"));
		        } catch (IOException | URISyntaxException e1) {
		            e1.printStackTrace();
		        }
		    }
		});
	}

	/**
	 * Method to load Statistic from the database and display 
	 */
	public void loadStatistic() {
		int month = boxSelectMonth.getSelectedIndex()+1;	
		int year = (int)boxSelectYear.getSelectedItem();
		Object sum = 0;
		    
		try {
			sum = DBRecordsService.searchStatictic(userID, month, year, RecordConstants.TYPEEXPENSE);
			lblAmountExpense.setText(sum.toString());
			int expense = Integer.parseInt(sum.toString());
			sum = DBRecordsService.searchStatictic(userID, month, year, RecordConstants.TYPEEXPENSE, "Food");
			lblAmountFood.setText(sum.toString());
			sum = DBRecordsService.searchStatictic(userID, month, year, RecordConstants.TYPEEXPENSE, "Transport");
			lblAmountTransport.setText(sum.toString());
			sum = DBRecordsService.searchStatictic(userID, month, year, RecordConstants.TYPEEXPENSE, "Clothing");
			lblAmountClothing.setText(sum.toString());
			sum = DBRecordsService.searchStatictic(userID, month, year, RecordConstants.TYPEEXPENSE, "Housing");
			lblAmountHousing.setText(sum.toString());
			sum = DBRecordsService.searchStatictic(userID, month, year, RecordConstants.TYPEEXPENSE, "Education");
			lblAmountEducation.setText(sum.toString());
			sum = DBRecordsService.searchStatictic(userID, month, year, RecordConstants.TYPEEXPENSE, "Recreation");
			lblAmountRecreation.setText(sum.toString());
			sum = DBRecordsService.searchStatictic(userID, month, year, RecordConstants.TYPEEXPENSE, "Healthcare");
			lblAmountHealthcare.setText(sum.toString());
			sum = DBRecordsService.searchStatictic(userID, month, year, RecordConstants.TYPEEXPENSE, "Others");
			lblAmountExpenseOthers.setText(sum.toString());
			
			sum = DBRecordsService.searchStatictic(userID, month, year, RecordConstants.TYPEINCOME);
			lblAmountIncome.setText(sum.toString());
			int income = Integer.parseInt(sum.toString());
			sum = DBRecordsService.searchStatictic(userID, month, year, RecordConstants.TYPEINCOME, "Salary");
			lblAmountSalary.setText(sum.toString());
			sum = DBRecordsService.searchStatictic(userID, month, year, RecordConstants.TYPEINCOME, "Bonus");
			lblAmountBonus.setText(sum.toString());
			sum = DBRecordsService.searchStatictic(userID, month, year, RecordConstants.TYPEINCOME, "Investment");
			lblAmountInvestment.setText(sum.toString());
			sum = DBRecordsService.searchStatictic(userID, month, year, RecordConstants.TYPEINCOME, "Part-Time");
			lblAmountPartTime.setText(sum.toString());
			sum = DBRecordsService.searchStatictic(userID, month, year, RecordConstants.TYPEINCOME, "Others");
			lblAmountIncomeOthers.setText(sum.toString());

			if (expense > income) {
				lblAmountBalance.setForeground(Color.RED);
				lblAmountBalance.setText("-" + Integer.toString(expense - income));
			} else {		// income > expense
				lblAmountBalance.setForeground(Color.BLUE);
				lblAmountBalance.setText("+" + Integer.toString(income - expense));
			}
		} catch(Exception e) {
		    e.printStackTrace();
		}
	}
}
