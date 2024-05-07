package com.jeepway.view;

import java.awt.*;
import javax.swing.*;

public class HomePageUI extends JFrame{
	/**
	 * Declare GUI components
	 */
	public JPanel panelTop;
	public JLabel lblTextAppName, lblTextWelcome;
	public JPanel panelMenu, panelMenuDashBoard, panelMenuHistory, panelMenuAddExpense, panelMenuAddIncome, panelMenuLogOut;
	public JLabel lblTextMenuDashBoard, lblTextMenuHistory, lblTextMenuAddExpense, lblTextMenuAddIncome, lblTextMenuLogOut;
	public JPanel panelCard;
	// public JPanel cardDashBoard, cardHistory, cardAddExpense, cardAddIncome;

	/**
	 * Create the frame.
	 */
	public HomePageUI() {
		super();		
		setBounds(100, 25, 1300, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		/**
		 * add the panelTop and it's Label
		 */
		panelTop = new JPanel();
		panelTop.setBackground(new Color(102, 102, 255));
		panelTop.setBounds(0, 0, 1386, 60);
		panelTop.setLayout(null);
		getContentPane().add(panelTop);
		
		lblTextWelcome = new JLabel(" Welcome   USER");
		lblTextWelcome.setForeground(new Color(255, 255, 255));
		lblTextWelcome.setIcon(new ImageIcon(HomePageUI.class.getResource("/icon/home_user_50px.png")));
		lblTextWelcome.setFont(new Font("Serif", Font.PLAIN, 25));
		lblTextWelcome.setBounds(1025, 0, 258, 60);
		panelTop.add(lblTextWelcome);
		
		lblTextAppName = new JLabel("Money Tracker");
		lblTextAppName.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextAppName.setForeground(Color.WHITE);
		lblTextAppName.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblTextAppName.setBounds(0, 0, 181, 60);
		panelTop.add(lblTextAppName);

		/**
		 * add the panelMenu and it's Label
		 */
		panelMenu = new JPanel();
		panelMenu.setBackground(new Color(0, 0, 0));
		panelMenu.setBounds(0, 60, 182, 653);
		panelMenu.setLayout(null);
		getContentPane().add(panelMenu);
		
		panelMenuDashBoard = new JPanel();
		panelMenuDashBoard.setForeground(Color.BLACK);
		panelMenuDashBoard.setBackground(Color.BLACK);
		panelMenuDashBoard.setBounds(0, 0, 182, 60);
		panelMenuDashBoard.setLayout(null);
		panelMenu.add(panelMenuDashBoard);
		
		lblTextMenuDashBoard = new JLabel("Dash Board");
		lblTextMenuDashBoard.setBounds(20, 0, 138, 60);
		lblTextMenuDashBoard.setBackground(Color.WHITE);
		lblTextMenuDashBoard.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextMenuDashBoard.setForeground(Color.WHITE);
		lblTextMenuDashBoard.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelMenuDashBoard.add(lblTextMenuDashBoard);
		
		panelMenuHistory = new JPanel();
		panelMenuHistory.setForeground(Color.BLACK);
		panelMenuHistory.setBackground(Color.BLACK);
		panelMenuHistory.setBounds(0, 60, 182, 60);
		panelMenu.add(panelMenuHistory);
		panelMenuHistory.setLayout(null);
		
		lblTextMenuHistory = new JLabel("History");
		lblTextMenuHistory.setBounds(20, 0, 138, 60);
		panelMenuHistory.add(lblTextMenuHistory);
		lblTextMenuHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextMenuHistory.setForeground(Color.WHITE);
		lblTextMenuHistory.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTextMenuHistory.setBackground(Color.WHITE);
		
		panelMenuAddExpense = new JPanel();
		panelMenuAddExpense.setForeground(Color.BLACK);
		panelMenuAddExpense.setLayout(null);
		panelMenuAddExpense.setBackground(Color.BLACK);
		panelMenuAddExpense.setBounds(0, 119, 182, 60);
		panelMenu.add(panelMenuAddExpense);
		
		lblTextMenuAddExpense = new JLabel("Add Expense");
		lblTextMenuAddExpense.setBounds(20, 0, 138, 60);
		panelMenuAddExpense.add(lblTextMenuAddExpense);
		lblTextMenuAddExpense.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextMenuAddExpense.setForeground(Color.WHITE);
		lblTextMenuAddExpense.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTextMenuAddExpense.setBackground(Color.WHITE);
		
		panelMenuAddIncome = new JPanel();
		panelMenuAddIncome.setForeground(Color.BLACK);
		panelMenuAddIncome.setLayout(null);
		panelMenuAddIncome.setBackground(Color.BLACK);
		panelMenuAddIncome.setBounds(0, 178, 182, 60);
		panelMenu.add(panelMenuAddIncome);
		
		lblTextMenuAddIncome = new JLabel("Add Income");
		lblTextMenuAddIncome.setBounds(20, 0, 138, 60);
		panelMenuAddIncome.add(lblTextMenuAddIncome);
		lblTextMenuAddIncome.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextMenuAddIncome.setForeground(Color.WHITE);
		lblTextMenuAddIncome.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTextMenuAddIncome.setBackground(Color.WHITE);
		
		panelMenuLogOut = new JPanel();
		panelMenuLogOut.setForeground(Color.BLACK);
		panelMenuLogOut.setLayout(null);
		panelMenuLogOut.setBackground(Color.BLACK);
		panelMenuLogOut.setBounds(0, 238, 182, 60);
		panelMenu.add(panelMenuLogOut);
		
		lblTextMenuLogOut = new JLabel("Log out");
		lblTextMenuLogOut.setBounds(20, 0, 138, 60);
		panelMenuLogOut.add(lblTextMenuLogOut);
		lblTextMenuLogOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextMenuLogOut.setForeground(Color.WHITE);
		lblTextMenuLogOut.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTextMenuLogOut.setBackground(Color.WHITE);
		
		/**
		 * panelCardLayout to show which panel
		 */
		panelCard = new JPanel();
		panelCard.setBounds(182, 60, 1102, 653);
		panelCard.setLayout(new CardLayout(0, 0));
		getContentPane().add(panelCard);
		
		// JPanel cardDashBoard = new PanelDashBoardUI();
		// panelCard.add(cardDashBoard, "cardDashBoard");
		
		// JPanel cardHistory = new PanelHistoryUI();
		// panelCard.add(cardHistory, "cardHistory");
				
		// JPanel cardAddExpense = new PanelAddExpenseUI();
		// panelCard.add(cardAddExpense, "cardAddExpense");
		
		// JPanel cardAddIncome = new PanelAddIncomeUI();
		// panelCard.add(cardAddIncome, "cardAddIncome");
	}
}

