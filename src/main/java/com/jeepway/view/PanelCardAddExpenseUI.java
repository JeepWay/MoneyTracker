package com.jeepway.view;

import java.awt.*;
import javax.swing.*;
import com.jeepway.constant.RecordConstants;

public class PanelCardAddExpenseUI extends JPanel {
	/**
	 * Declare GUI components
	 */
	public JPanel panelSeperationLine, panelInput;
	public JLabel lblTextAddExpense1, lblTextAddExpense2;
	public JLabel lblIconAddExpense;
	public JLabel lblTextCategory, lblTextDate, lblTextAmount, lblTextDetail;
	public JLabel lblHyperlink;
	public JComboBox<String> boxCategory;
	public JTextField txtDate, txtAmount;
	public JTextArea txtDetail;
	public JButton btnClear, btnAdd, btnCalendar;
	
	
	/**
	 * Create the panel.
	 */
	public PanelCardAddExpenseUI() {
		super();
		setBackground(new Color(230, 230, 230));
		setBounds(182, 60, 1102, 653);
		setLayout(null);
		
		lblHyperlink = new JLabel("");
		lblHyperlink.setIcon(new ImageIcon(PanelCardAddExpenseUI.class.getResource("/icon/question.png")));
		lblHyperlink.setBounds(1060, 611, 32, 32);
		add(lblHyperlink);
		
		/**
		 * Heading
		 */
		lblTextAddExpense1 = new JLabel("Add Expense");
		lblTextAddExpense1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblTextAddExpense1.setBounds(20, 10, 172, 55);
		add(lblTextAddExpense1);
		
		lblTextAddExpense2 = new JLabel("create new expense information");
		lblTextAddExpense2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTextAddExpense2.setForeground(Color.GRAY);
		lblTextAddExpense2.setBounds(200, 30, 210, 24);
		add(lblTextAddExpense2);
		
		panelSeperationLine = new JPanel();
		panelSeperationLine.setBackground(Color.LIGHT_GRAY);
		panelSeperationLine.setBounds(10, 65, 1082, 4);
		add(panelSeperationLine);
		
		panelInput = new JPanel();
		panelInput.setBackground(new Color(230, 230, 230));
		panelInput.setBounds(78, 90, 500, 535);
		panelInput.setLayout(null);
		add(panelInput);
		
		lblIconAddExpense = new JLabel("");
		lblIconAddExpense.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconAddExpense.setIcon(new ImageIcon(PanelCardAddExpenseUI.class.getResource("/icon/accounting.png")));
		lblIconAddExpense.setBounds(581, 115, 450, 450);
		add(lblIconAddExpense);
		
		/**
		 * Input label and textarea
		 */
		lblTextCategory = new JLabel("Category");
		lblTextCategory.setBounds(20, 20, 150, 50);
		lblTextCategory.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextCategory.setForeground(Color.BLACK);
		lblTextCategory.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panelInput.add(lblTextCategory);
		
		boxCategory = new JComboBox<>();
		boxCategory.setModel(new DefaultComboBoxModel<String>(RecordConstants.LISTEXPENSE));
		boxCategory.setBackground(new Color(255, 255, 255));
		boxCategory.setBounds(170, 20, 269, 50);
		boxCategory.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panelInput.add(boxCategory);
		
		lblTextDate = new JLabel("Date");
		lblTextDate.setBounds(20, 110, 150, 50);
		lblTextDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextDate.setForeground(Color.BLACK);
		lblTextDate.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panelInput.add(lblTextDate);
		
		txtDate = new JTextField();
		txtDate.setBackground(new Color(255, 255, 255));
		txtDate.setEditable(false);
		txtDate.setBounds(170, 110, 250, 50);
		txtDate.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txtDate.setColumns(10);
		panelInput.add(txtDate);
		
		lblTextAmount = new JLabel("Amount");
		lblTextAmount.setBounds(20, 200, 150, 50);
		lblTextAmount.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextAmount.setForeground(Color.BLACK);
		lblTextAmount.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panelInput.add(lblTextAmount);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(170, 200, 250, 50);
		txtAmount.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txtAmount.setColumns(10);
		panelInput.add(txtAmount);
		
		lblTextDetail = new JLabel("Detail");
		lblTextDetail.setBounds(20, 290, 144, 50);
		lblTextDetail.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextDetail.setForeground(Color.BLACK);
		lblTextDetail.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panelInput.add(lblTextDetail);
		
		txtDetail = new JTextArea();
		txtDetail.setBounds(170, 290, 250, 100);
		txtDetail.setFont(new Font("Serif", Font.PLAIN, 25));
		JScrollPane scrollPaneDetail = new JScrollPane(txtDetail);
		scrollPaneDetail.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneDetail.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneDetail.setBounds(170, 290, 269, 115);
		panelInput.add(scrollPaneDetail);

		/**
		 * Input button
		 */
		btnClear = new JButton("Clear");
		btnClear.setBounds(65, 431, 140, 68);
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panelInput.add(btnClear);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(266, 431, 140, 68);
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panelInput.add(btnAdd);
		
		btnCalendar = new JButton("");
		btnCalendar.setBounds(423, 110, 50, 50);
		btnCalendar.setIcon(new ImageIcon(PanelCardAddExpenseUI.class.getResource("/icon/calendar.png")));
		panelInput.add(btnCalendar);
	}
}
