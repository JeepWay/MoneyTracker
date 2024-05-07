package com.jeepway.view;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;

import com.jeepway.constant.RecordConstants;
import com.jeepway.constant.CommonConstants;


public class PanelCardDashBoardUI extends JPanel {
	/**
	 * Declare GUI components
	 */
	public JPanel panelSelectDate, panelAllExpense, panelAllIncome, panelBalance; 
	public JPanel panelExpense, panelFood, panelTransport, panelClothing, panelHousing, 
					panelEducation, panelRecreation, panelHealthcare, panelExpenseOthers;
	public JPanel panelIncome, panelSalary, panelBonus, panelPartTime, panelInvestment, 
					panelIncomeOthers;
	public JPanel panelSeperationLine1, panelSeperationLine2, 
					panelSeperationLine3, panelSeperationLine4;
	public JLabel lblTextStatistic, lblTextSelectMonth, lblTextSelectYear;
	public JComboBox<String> boxSelectMonth;
	public JComboBox<Integer> boxSelectYear;
	public JButton btnSearch;

	public JLabel lblIconExpense, lblAmountExpense, lblAmountFood, lblAmountTransport, 
					lblAmountClothing, lblAmountHousing, lblAmountEducation, lblAmountRecreation, 
					lblAmountHealthcare, lblAmountExpenseOthers; 
	public JLabel lblTextExpense, lblTextFood, lblTextTransport, lblTextClothing, 
					lblTextHousing, lblTextEducation, lblTextRecreation, 
					lblTextHealthcare, lblTextExpenseOthers;
	public JLabel lblIconIncome, lblAmountIncome, lblAmountSalary, lblAmountBonus, 
					lblAmountPartTime, lblAmountInvestment, lblAmountIncomeOthers;  
	public JLabel lblTextIncome, lblTextSalary, lblTextBonus, lblTextPartTime, 
					lblTextInvestment, lblTextIncomeOthers;
	public JLabel lblIconBalance, lblAmountBalance, lblTextBalance;
	public JLabel lblHyperlink;

	/**
	 * Create the panel.
	 */
	public PanelCardDashBoardUI() {
		super();	
		setBackground(new Color(230, 230, 230));
		setBounds(182, 60, 1102, 653);
		setLayout(null);

		lblHyperlink = new JLabel("");
		lblHyperlink.setIcon(new ImageIcon(PanelCardDashBoardUI.class.getResource("/icon/question.png")));
		lblHyperlink.setBounds(1060, 611, 32, 32);
		add(lblHyperlink);
		
		lblTextStatistic = new JLabel("Statistics");
		lblTextStatistic.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblTextStatistic.setBounds(20, 10, 311, 55);
		add(lblTextStatistic);
		
		panelSeperationLine1 = new JPanel();
		panelSeperationLine1.setBackground(Color.LIGHT_GRAY);
		panelSeperationLine1.setBounds(10, 64, 1082, 4);
		add(panelSeperationLine1);
		

		// start panelSelectDate section
		panelSelectDate = new JPanel();
		panelSelectDate.setBackground(new Color(230, 230, 230));
		panelSelectDate.setBounds(10, 75, 1072, 93);
		add(panelSelectDate);
		panelSelectDate.setLayout(null);
		
		lblTextSelectMonth = new JLabel("Select Month");
		lblTextSelectMonth.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTextSelectMonth.setBounds(11, 10, 123, 30);
		panelSelectDate.add(lblTextSelectMonth);
		
		boxSelectMonth = new JComboBox<>(CommonConstants.MONTHS);
		boxSelectMonth.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		boxSelectMonth.setBackground(Color.WHITE);
		boxSelectMonth.setBounds(10, 50, 120, 30);
		panelSelectDate.add(boxSelectMonth);
		
		lblTextSelectYear = new JLabel("Select Year");
		lblTextSelectYear.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTextSelectYear.setBounds(161, 10, 100, 30);
		panelSelectDate.add(lblTextSelectYear);
		
		boxSelectYear = new JComboBox<>();
		boxSelectYear.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		boxSelectYear.setBackground(Color.WHITE);
		boxSelectYear.setBounds(161, 50, 120, 30);
		panelSelectDate.add(boxSelectYear);
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSearch.setBounds(301, 50, 120, 30);
		panelSelectDate.add(btnSearch);
		// end panelSelectDate section


		panelSeperationLine2 = new JPanel();
		panelSeperationLine2.setBackground(Color.LIGHT_GRAY);
		panelSeperationLine2.setBounds(10, 178, 1082, 4);
		add(panelSeperationLine2);
		

		// start panelAllExpense section
		panelAllExpense = new JPanel();
		panelAllExpense.setBackground(new Color(230, 230, 230));
		panelAllExpense.setBounds(10, 182, 1082, 165);
		add(panelAllExpense);
		panelAllExpense.setLayout(null);

		panelExpense = new JPanel();
		panelExpense.setBounds(0, 42, 188, 85);
		panelExpense.setLayout(null);
		panelAllExpense.add(panelExpense);

		lblIconExpense = new JLabel("");
		lblIconExpense.setIcon(new ImageIcon(PanelCardDashBoardUI.class.getResource("/icon/costs.png")));
		lblIconExpense.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconExpense.setBackground(Color.RED);
		lblIconExpense.setBounds(10, 10, 65, 65);
		panelExpense.add(lblIconExpense);

		lblTextExpense = new JLabel(RecordConstants.TYPEEXPENSE);
		lblTextExpense.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTextExpense.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblTextExpense.setBounds(87, 10, 91, 40);
		panelExpense.add(lblTextExpense);

		lblAmountExpense = new JLabel("1000");
		lblAmountExpense.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmountExpense.setForeground(Color.RED);
		lblAmountExpense.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblAmountExpense.setBounds(93, 50, 85, 30);
		panelExpense.add(lblAmountExpense);
		
		panelFood = new JPanel();
		panelFood.setBounds(212, 20, 200, 60);
		panelFood.setLayout(null);
		panelFood.setBorder(new MatteBorder(0, 7, 0, 0, (Color) Color.RED));
		panelAllExpense.add(panelFood);
		
		lblTextFood = new JLabel("Food");
		lblTextFood.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextFood.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblTextFood.setBounds(10, 10, 73, 40);
		panelFood.add(lblTextFood);
		
		lblAmountFood = new JLabel("1000");
		lblAmountFood.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmountFood.setForeground(Color.RED);
		lblAmountFood.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblAmountFood.setBounds(122, 10, 73, 40);
		panelFood.add(lblAmountFood);
		
		panelTransport = new JPanel();
		panelTransport.setBounds(212, 90, 200, 60);
		panelTransport.setLayout(null);
		panelTransport.setBorder(new MatteBorder(0, 7, 0, 0, (Color) Color.RED));
		panelAllExpense.add(panelTransport);
		
		lblTextTransport = new JLabel("Transport");
		lblTextTransport.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextTransport.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblTextTransport.setBounds(10, 10, 102, 40);
		panelTransport.add(lblTextTransport);
		
		lblAmountTransport = new JLabel("1000");
		lblAmountTransport.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmountTransport.setForeground(Color.RED);
		lblAmountTransport.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblAmountTransport.setBounds(122, 10, 73, 40);
		panelTransport.add(lblAmountTransport);

		panelClothing = new JPanel();
		panelClothing.setBounds(432, 20, 200, 60);
		panelClothing.setLayout(null);
		panelClothing.setBorder(new MatteBorder(0, 7, 0, 0, (Color) Color.RED));
		panelAllExpense.add(panelClothing);
		
		lblTextClothing = new JLabel("Clothing");
		lblTextClothing.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextClothing.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblTextClothing.setBounds(10, 10, 115, 40);
		panelClothing.add(lblTextClothing);
		
		lblAmountClothing = new JLabel("1000");
		lblAmountClothing.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmountClothing.setForeground(Color.RED);
		lblAmountClothing.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblAmountClothing.setBounds(122, 10, 73, 40);
		panelClothing.add(lblAmountClothing);
		
		panelHousing = new JPanel();
		panelHousing.setBounds(432, 90, 200, 60);
		panelHousing.setLayout(null);
		panelHousing.setBorder(new MatteBorder(0, 7, 0, 0, (Color) Color.RED));
		panelAllExpense.add(panelHousing);
		
		lblTextHousing = new JLabel("Housing");
		lblTextHousing.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextHousing.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblTextHousing.setBounds(10, 10, 115, 40);
		panelHousing.add(lblTextHousing);
		
		lblAmountHousing = new JLabel("1000");
		lblAmountHousing.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmountHousing.setForeground(Color.RED);
		lblAmountHousing.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblAmountHousing.setBounds(122, 10, 73, 40);
		panelHousing.add(lblAmountHousing);
		
		panelEducation = new JPanel();
		panelEducation.setBounds(652, 20, 200, 60);
		panelEducation.setLayout(null);
		panelEducation.setBorder(new MatteBorder(0, 7, 0, 0, (Color) Color.RED));
		panelAllExpense.add(panelEducation);
		
		lblTextEducation = new JLabel("Education");
		lblTextEducation.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextEducation.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblTextEducation.setBounds(10, 10, 115, 40);
		panelEducation.add(lblTextEducation);
		
		lblAmountEducation = new JLabel("1000");
		lblAmountEducation.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmountEducation.setForeground(Color.RED);
		lblAmountEducation.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblAmountEducation.setBounds(122, 10, 73, 40);
		panelEducation.add(lblAmountEducation);
		
		panelRecreation = new JPanel();
		panelRecreation.setBounds(652, 90, 200, 60);
		panelRecreation.setLayout(null);
		panelRecreation.setBorder(new MatteBorder(0, 7, 0, 0, (Color) Color.RED));
		panelAllExpense.add(panelRecreation);
		
		lblTextRecreation = new JLabel("Recreation");
		lblTextRecreation.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextRecreation.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblTextRecreation.setBounds(10, 10, 115, 40);
		panelRecreation.add(lblTextRecreation);
		
		lblAmountRecreation = new JLabel("1000");
		lblAmountRecreation.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmountRecreation.setForeground(Color.RED);
		lblAmountRecreation.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblAmountRecreation.setBounds(122, 10, 73, 40);
		panelRecreation.add(lblAmountRecreation);
		
		panelHealthcare = new JPanel();
		panelHealthcare.setBounds(872, 20, 200, 60);
		panelHealthcare.setLayout(null);
		panelHealthcare.setBorder(new MatteBorder(0, 7, 0, 0, (Color) Color.RED));
		panelAllExpense.add(panelHealthcare);
		
		lblTextHealthcare = new JLabel("Healthcare");
		lblTextHealthcare.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextHealthcare.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblTextHealthcare.setBounds(10, 10, 115, 40);
		panelHealthcare.add(lblTextHealthcare);
		
		lblAmountHealthcare = new JLabel("1000");
		lblAmountHealthcare.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmountHealthcare.setForeground(Color.RED);
		lblAmountHealthcare.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblAmountHealthcare.setBounds(122, 10, 73, 40);
		panelHealthcare.add(lblAmountHealthcare);
		
		panelExpenseOthers = new JPanel();
		panelExpenseOthers.setBounds(872, 90, 200, 60);
		panelExpenseOthers.setLayout(null);
		panelExpenseOthers.setBorder(new MatteBorder(0, 7, 0, 0, (Color) Color.RED));
		panelAllExpense.add(panelExpenseOthers);

		lblTextExpenseOthers = new JLabel("Others");
		lblTextExpenseOthers.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextExpenseOthers.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblTextExpenseOthers.setBounds(10, 10, 73, 40);
		panelExpenseOthers.add(lblTextExpenseOthers);
		
		lblAmountExpenseOthers = new JLabel("1000");
		lblAmountExpenseOthers.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmountExpenseOthers.setForeground(Color.RED);
		lblAmountExpenseOthers.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblAmountExpenseOthers.setBounds(122, 10, 73, 40);
		panelExpenseOthers.add(lblAmountExpenseOthers);
		// end panelAllExpense section


		panelSeperationLine3 = new JPanel();
		panelSeperationLine3.setBackground(Color.LIGHT_GRAY);
		panelSeperationLine3.setBounds(10, 350, 1082, 4);
		add(panelSeperationLine3);
		

		// start panelAllIncome section
		panelAllIncome = new JPanel();
		panelAllIncome.setBackground(new Color(230, 230, 230));
		panelAllIncome.setBounds(10, 355, 1082, 165);
		panelAllIncome.setLayout(null);
		add(panelAllIncome);
		
		panelIncome = new JPanel();
		panelIncome.setBounds(0, 42, 188, 85);
		panelIncome.setLayout(null);
		panelAllIncome.add(panelIncome);
		
		lblIconIncome = new JLabel("");
		lblIconIncome.setIcon(new ImageIcon(PanelCardDashBoardUI.class.getResource("/icon/income.png")));
		lblIconIncome.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconIncome.setBackground(Color.RED);
		lblIconIncome.setBounds(10, 10, 65, 65);
		panelIncome.add(lblIconIncome);

		lblTextIncome = new JLabel(RecordConstants.TYPEINCOME);
		lblTextIncome.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTextIncome.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblTextIncome.setBounds(87, 10, 91, 40);
		panelIncome.add(lblTextIncome);

		lblAmountIncome = new JLabel("1000");
		lblAmountIncome.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmountIncome.setForeground(Color.BLUE);
		lblAmountIncome.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblAmountIncome.setBounds(93, 50, 85, 30);
		panelIncome.add(lblAmountIncome);
		
		panelBonus = new JPanel();
		panelBonus.setBounds(212, 90, 200, 60);
		panelBonus.setForeground(Color.BLACK);
		panelBonus.setLayout(null);
		panelBonus.setBorder(new MatteBorder(0, 7, 0, 0, (Color) Color.BLUE));
		panelAllIncome.add(panelBonus);
		
		lblTextBonus = new JLabel("Bonus");
		lblTextBonus.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextBonus.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblTextBonus.setBounds(10, 10, 80, 40);
		panelBonus.add(lblTextBonus);
		
		lblAmountBonus = new JLabel("1000");
		lblAmountBonus.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmountBonus.setForeground(Color.BLUE);
		lblAmountBonus.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblAmountBonus.setBounds(122, 10, 73, 40);
		panelBonus.add(lblAmountBonus);
		
		panelSalary = new JPanel();
		panelSalary.setBounds(212, 20, 200, 60);
		panelSalary.setLayout(null);
		panelSalary.setBorder(new MatteBorder(0, 7, 0, 0, (Color) Color.BLUE));
		panelAllIncome.add(panelSalary);
		
		lblTextSalary = new JLabel("Salary");
		lblTextSalary.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextSalary.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblTextSalary.setBounds(10, 10, 80, 40);
		panelSalary.add(lblTextSalary);
		
		lblAmountSalary = new JLabel("1000");
		lblAmountSalary.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmountSalary.setForeground(Color.BLUE);
		lblAmountSalary.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblAmountSalary.setBounds(122, 10, 73, 40);
		panelSalary.add(lblAmountSalary);
		
		panelPartTime = new JPanel();
		panelPartTime.setBounds(432, 20, 200, 60);
		panelPartTime.setLayout(null);
		panelPartTime.setBorder(new MatteBorder(0, 7, 0, 0, (Color) Color.BLUE));
		panelAllIncome.add(panelPartTime);
		
		lblTextPartTime = new JLabel("Part-Time");
		lblTextPartTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextPartTime.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblTextPartTime.setBounds(10, 10, 102, 40);
		panelPartTime.add(lblTextPartTime);
		
		lblAmountPartTime = new JLabel("1000");
		lblAmountPartTime.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmountPartTime.setForeground(Color.BLUE);
		lblAmountPartTime.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblAmountPartTime.setBounds(108, 10, 87, 40);
		panelPartTime.add(lblAmountPartTime);
		
		panelInvestment = new JPanel();
		panelInvestment.setBounds(432, 90, 200, 60);
		panelInvestment.setLayout(null);
		panelInvestment.setBorder(new MatteBorder(0, 7, 0, 0, (Color) Color.BLUE));
		panelAllIncome.add(panelInvestment);
		
		lblTextInvestment = new JLabel("Investment");
		lblTextInvestment.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextInvestment.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblTextInvestment.setBounds(10, 10, 112, 40);
		panelInvestment.add(lblTextInvestment);
		
		lblAmountInvestment = new JLabel("1000");
		lblAmountInvestment.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmountInvestment.setForeground(Color.BLUE);
		lblAmountInvestment.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblAmountInvestment.setBounds(110, 10, 85, 40);
		panelInvestment.add(lblAmountInvestment);
		
		panelIncomeOthers = new JPanel();
		panelIncomeOthers.setBounds(652, 20, 200, 60);
		panelIncomeOthers.setLayout(null);
		panelIncomeOthers.setBorder(new MatteBorder(0, 7, 0, 0, (Color) Color.BLUE));
		panelAllIncome.add(panelIncomeOthers);
		
		lblTextIncomeOthers = new JLabel("Others");
		lblTextIncomeOthers.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextIncomeOthers.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblTextIncomeOthers.setBounds(10, 10, 80, 40);
		panelIncomeOthers.add(lblTextIncomeOthers);
		
		lblAmountIncomeOthers = new JLabel("1000");
		lblAmountIncomeOthers.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmountIncomeOthers.setForeground(Color.BLUE);
		lblAmountIncomeOthers.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblAmountIncomeOthers.setBounds(122, 10, 73, 40);
		panelIncomeOthers.add(lblAmountIncomeOthers);
		// end panelAllIncome section


		panelSeperationLine4 = new JPanel();
		panelSeperationLine4.setBackground(Color.LIGHT_GRAY);
		panelSeperationLine4.setBounds(10, 522, 1082, 4);
		add(panelSeperationLine4);

		
		// start panelBalance section
		panelBalance = new JPanel();
		panelBalance.setLayout(null);
		panelBalance.setBounds(10, 545, 188, 85);
		add(panelBalance);
		
		lblAmountBalance = new JLabel("1000");
		lblAmountBalance.setBounds(93, 50, 85, 30);
		lblAmountBalance.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAmountBalance.setForeground(Color.BLUE);
		lblAmountBalance.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panelBalance.add(lblAmountBalance);
		
		lblTextBalance = new JLabel("Balance");
		lblTextBalance.setBounds(87, 10, 91, 40);
		panelBalance.add(lblTextBalance);
		lblTextBalance.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTextBalance.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		lblIconBalance = new JLabel("");
		lblIconBalance.setBounds(10, 10, 65, 65);
		panelBalance.add(lblIconBalance);
		lblIconBalance.setIcon(new ImageIcon(PanelCardDashBoardUI.class.getResource("/icon/balance-sheet.png")));
		lblIconBalance.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconBalance.setBackground(Color.RED);
		// end panelBalance section
	}
}
