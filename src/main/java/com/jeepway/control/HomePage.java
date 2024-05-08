package com.jeepway.control;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.jeepway.model.User;
import com.jeepway.view.HomePageUI;

public class HomePage extends HomePageUI {
	/**
	 * receive user object from login page
	 */
	private User user;
	
	/**
	 * Declare GUI components
	 */
	private JPanel cardDashBoard, cardHistory, cardAddExpense, cardAddIncome;

	public HomePage(User user) {
		super();
		this.user = user;
		// set user name into welcome label
		lblTextWelcome.setText(" Welcome   " + this.user.getName());
		// set first panel into active background
		panelMenu.getComponent(0).setBackground(Color.RED);
		// set card layout
		cardDashBoard = new PanelCardDashBoard(this.user.getUserID());
		cardHistory = new PanelCardHistory(this.user.getUserID());
		cardAddExpense = new PanelCardAddExpense(this.user.getUserID());
		cardAddIncome = new PanelCardAddIncome(this.user.getUserID());
		panelCard.add(cardDashBoard, "cardDashBoard");
		panelCard.add(cardHistory, "cardHistory");
		panelCard.add(cardAddExpense, "cardAddExpense");
		panelCard.add(cardAddIncome, "cardAddIncome");
		// set mouse click event
		this.setActionPerformed();
	}
	
	/**
	 * action to mouse click menu label
	 */
	private void setActionPerformed() {
		panelMenuDashBoard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeMenuColor(panelMenuDashBoard);
				((PanelCardDashBoard) cardDashBoard).loadStatistic();
				CardLayout cl = (CardLayout)(panelCard.getLayout());
	            cl.show(panelCard, "cardDashBoard");
			}
		});
		panelMenuHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeMenuColor(panelMenuHistory);
				((PanelCardHistory) cardHistory).loadRecords();
				((PanelCardHistory) cardHistory).refreshRecord();
				CardLayout cl = (CardLayout)(panelCard.getLayout());
	            cl.show(panelCard, "cardHistory");
			}
		});
		panelMenuAddExpense.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeMenuColor(panelMenuAddExpense);
				((PanelCardAddExpense) cardAddExpense).clearInput();
				CardLayout cl = (CardLayout)(panelCard.getLayout());
	            cl.show(panelCard, "cardAddExpense");
			}
		});
		panelMenuAddIncome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeMenuColor(panelMenuAddIncome);
				((PanelCardAddIncome) cardAddIncome).clearInput();
				CardLayout cl = (CardLayout)(panelCard.getLayout());
	            cl.show(panelCard, "cardAddIncome");
			}
		});
		panelMenuLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginPage login = new LoginPage();
				login.setVisible(true);	// redirect to login page
				dispose();	
			}
		});
	}

	/*
	 * ChangeMenuColor when click the left menu
	 */
	private void changeMenuColor(JPanel panelSelect) {
		for (int i = 0; i < panelMenu.getComponentCount(); i++) {
			panelMenu.getComponent(i).setBackground(Color.BLACK);
		}
		panelSelect.setBackground(Color.RED);
	}
}

