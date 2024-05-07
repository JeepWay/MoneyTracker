package com.jeepway.view;

import java.awt.*;
import javax.swing.*;

import com.jeepway.constant.CommonConstants;


public class PanelCardHistoryUI extends JPanel{
	/**
	 * Declare GUI components
	 */
    public JPanel panelHistory, panelModify;
	public JPanel panelSeperationLine1, panelSeperationLine2;
	public JScrollPane scrollPaneHistory, scrollPaneDetail;
	public JLabel lblTextHistory, lblTextSelectMonth, lblTextSelectYear, lblTextSelectType;
	public JLabel lblTextModify, lblTextModifyCategory, lblTextModifyDate, lblTextModifyAmount, lblTextModifyType, lblTextModifyDetail; 
	public JLabel lblHyperlink;
	public JTable tblHistory; 
    public JTextField txtModifyDate, txtModifyAmount;
    public JTextArea txtModifyDetail;
	public JComboBox<Integer> boxSelectYear;
	public JComboBox<String> boxSelectMonth, boxSelectType, boxModifyCategory, boxModifyType;
	public JButton btnSearch, btnCalendar, btnModify, btnDelete, btnRefresh;
      
	/**
	 * Create the panel.
	 */
	public PanelCardHistoryUI() {
		super();
		setBackground(new Color(230, 230, 230));
		setBounds(182, 60, 1102, 653);
		setLayout(null);
		
		lblHyperlink = new JLabel("");
		lblHyperlink.setIcon(new ImageIcon(PanelCardHistoryUI.class.getResource("/icon/question.png")));
		lblHyperlink.setBounds(1060, 611, 32, 32);
		add(lblHyperlink);

		panelModify = new JPanel();
		panelModify.setBackground(new Color(230, 230, 230));
		panelModify.setBounds(0, 410, 1102, 243);
		panelModify.setLayout(null);
		add(panelModify);
		
		panelSeperationLine1 = new JPanel();
		panelSeperationLine1.setBounds(10, 55, 1082, 4);
		panelSeperationLine1.setBackground(Color.LIGHT_GRAY);
		panelModify.add(panelSeperationLine1);
		
		lblTextModify = new JLabel("Modify");
		lblTextModify.setBounds(20, 0, 123, 55);
		lblTextModify.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panelModify.add(lblTextModify);
		
		lblTextModifyCategory = new JLabel("category");
		lblTextModifyCategory.setBounds(30, 145, 78, 30);
		lblTextModifyCategory.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelModify.add(lblTextModifyCategory);
		
		boxModifyCategory = new JComboBox<>();
		boxModifyCategory.setBounds(110, 145, 130, 30);
		boxModifyCategory.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		boxModifyCategory.setBackground(Color.WHITE);
		panelModify.add(boxModifyCategory);
		
		lblTextModifyDate = new JLabel("date");
		lblTextModifyDate.setBounds(296, 85, 45, 30);
		lblTextModifyDate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelModify.add(lblTextModifyDate);
		
		lblTextModifyType = new JLabel("type");
		lblTextModifyType.setBounds(51, 85, 45, 30);
		lblTextModifyType.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelModify.add(lblTextModifyType);
		
		txtModifyDate = new JTextField();
		txtModifyDate.setBounds(343, 85, 130, 30);
		txtModifyDate.setEditable(false);
		txtModifyDate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtModifyDate.setColumns(10);
		txtModifyDate.setBackground(Color.WHITE);
		panelModify.add(txtModifyDate);
		
		boxModifyType = new JComboBox<>();
		boxModifyType.setBounds(110, 85, 130, 30);
		boxModifyType.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		boxModifyType.setBackground(Color.WHITE);
		panelModify.add(boxModifyType);
		
		btnCalendar = new JButton("");
		btnCalendar.setBounds(474, 85, 30, 30);
		btnCalendar.setIcon(new ImageIcon(PanelCardHistoryUI.class.getResource("/icon/calendar_24px.png")));
		panelModify.add(btnCalendar);
		
		
		lblTextModifyAmount = new JLabel("amount");
		lblTextModifyAmount.setBounds(271, 145, 70, 30);
		lblTextModifyAmount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelModify.add(lblTextModifyAmount);
		
		lblTextModifyDetail = new JLabel("detail");
		lblTextModifyDetail.setBounds(544, 85, 59, 30);
		lblTextModifyDetail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelModify.add(lblTextModifyDetail);
		
		txtModifyAmount = new JTextField();
		txtModifyAmount.setBounds(342, 145, 130, 30);
		txtModifyAmount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtModifyAmount.setColumns(10);
		txtModifyAmount.setBackground(Color.WHITE);
		panelModify.add(txtModifyAmount);
		
		txtModifyDetail = new JTextArea();
		txtModifyDetail.setFont(new Font("Serif", Font.PLAIN, 15));
		txtModifyDetail.setBounds(630, 570, 130, 71);

		scrollPaneDetail = new JScrollPane(txtModifyDetail);
		scrollPaneDetail.setBounds(603, 88, 270, 112);
		scrollPaneDetail.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneDetail.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelModify.add(scrollPaneDetail);
		
		btnModify = new JButton("Modify");
		btnModify.setBounds(919, 73, 120, 30);
		btnModify.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelModify.add(btnModify);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(919, 120, 120, 30);
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelModify.add(btnDelete);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(919, 170, 120, 30);
		btnRefresh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelModify.add(btnRefresh);
		
		panelHistory = new JPanel();
		panelHistory.setBackground(new Color(230, 230, 230));
		panelHistory.setBounds(0, 1, 1102, 410);
		panelHistory.setLayout(null);
		add(panelHistory);
		
		panelSeperationLine2 = new JPanel();
		panelSeperationLine2.setBounds(10, 65, 1082, 4);
		panelSeperationLine2.setBackground(Color.LIGHT_GRAY);
		panelHistory.add(panelSeperationLine2);
		
		lblTextHistory = new JLabel("History");
		lblTextHistory.setBounds(20, 10, 123, 55);
		lblTextHistory.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panelHistory.add(lblTextHistory);
		
		lblTextSelectMonth = new JLabel("Select Month");
		lblTextSelectMonth.setBounds(21, 90, 123, 30);
		lblTextSelectMonth.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelHistory.add(lblTextSelectMonth);
		
		boxSelectMonth = new JComboBox<>(CommonConstants.MONTHS);
		boxSelectMonth.setBounds(20, 130, 120, 30);
		boxSelectMonth.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		boxSelectMonth.setBackground(Color.WHITE);
		panelHistory.add(boxSelectMonth);
		
		
		lblTextSelectYear = new JLabel("Select Year");
		lblTextSelectYear.setBounds(171, 90, 100, 30);
		lblTextSelectYear.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelHistory.add(lblTextSelectYear);
		
		boxSelectYear = new JComboBox<>();
		boxSelectYear.setBounds(171, 130, 120, 30);
		boxSelectYear.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		boxSelectYear.setBackground(Color.WHITE);
		panelHistory.add(boxSelectYear);
		
		
		lblTextSelectType = new JLabel("Select Type");
		lblTextSelectType.setBounds(317, 90, 123, 30);
		lblTextSelectType.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelHistory.add(lblTextSelectType);
		
		boxSelectType = new JComboBox<>(new String[] {"Both", "Expense", "Income"});
		boxSelectType.setBounds(317, 130, 120, 30);
		boxSelectType.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		boxSelectType.setBackground(Color.WHITE);
		panelHistory.add(boxSelectType);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(464, 130, 120, 30);
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelHistory.add(btnSearch);
	}
}
