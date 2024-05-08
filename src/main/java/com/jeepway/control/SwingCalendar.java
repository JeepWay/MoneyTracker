package com.jeepway.control;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

import com.jeepway.constant.CommonConstants;

public class SwingCalendar extends JFrame {
 
	public static String SELECTDATE;
	private Calendar cal = new GregorianCalendar();
	private JScrollPane panelDate;
	private JTable table;
	private DefaultTableModel model;
	private JPanel panelMonthYear;
	private JComboBox<String> boxMonth;
	private JComboBox<Integer> boxYear;

	public SwingCalendar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Calandar");
		setBounds(900, 260, 421, 226);
		getContentPane().setLayout(null);
 
		panelMonthYear = new JPanel();
		panelMonthYear.setBackground(new Color(240, 240, 240));
		panelMonthYear.setLayout(null);
		panelMonthYear.setBounds(10, 10, 386, 30);
			
		boxMonth = new JComboBox<>(CommonConstants.MONTHS);
		boxMonth.setBackground(new Color(255, 255, 255));
		boxMonth.setBounds(82, 0, 100, 30);
		boxMonth.setFont(new Font("Serif", Font.PLAIN, 14));
		panelMonthYear.add(boxMonth);
		
		boxYear = new JComboBox<>();
		boxYear.setBackground(new Color(255, 255, 255));
		boxYear.setBounds(207, 0, 100, 30);
		boxYear.setFont(new Font("Serif", Font.PLAIN, 14));
		for(int i=cal.get(Calendar.YEAR)-5; i<=cal.get(Calendar.YEAR)+15; i++){
			boxYear.addItem(i);
        }
		panelMonthYear.add(boxYear);
		
		model = new DefaultTableModel(null, CommonConstants.ABBRMONTHS);
		table = new JTable(model);
		panelDate = new JScrollPane(table);
		panelDate.setBounds(10, 48, 386, 127);
		
		getContentPane().add(panelMonthYear);
		getContentPane().add(panelDate);
		this.setClickActions();

		// Set the current month and year.
		boxMonth.setSelectedIndex(cal.get(Calendar.MONTH));	
		boxYear.setSelectedItem(cal.get(Calendar.YEAR));	
		this.updateMonth();
	}
 
	private void setClickActions() {
		// When selecting a month, update the calendar.
		this.boxMonth.addItemListener(new ItemListener() {	
			@Override
			public void itemStateChanged(ItemEvent e){
		        if(e.getStateChange() == ItemEvent.SELECTED){
		        	cal.set(Calendar.MONTH, boxMonth.getSelectedIndex());
					updateMonth();
		        }
		    }
		});
		// When selecting a year, update the calendar.
		this.boxYear.addItemListener(new ItemListener() {	
			@Override
			public void itemStateChanged(ItemEvent e){
		        if(e.getStateChange() == ItemEvent.SELECTED){
		        	cal.set(Calendar.YEAR, (int)boxYear.getSelectedItem());
					updateMonth();
		        }
		    }
		});
		// When selecting a date, get the selected date.
		this.table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getSelectDate();
			}
		});
	}

	private void updateMonth() {
		// Initialize current date to the 1st of the month.
		cal.set(Calendar.DAY_OF_MONTH, 1);  
    
		int startDay = cal.get(Calendar.DAY_OF_WEEK);
		int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // The umber of days in the current month
		int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);		// The number of weeks in the current month
 
		model.setRowCount(0);
		model.setRowCount(weeks);
 
		// Set the number of days for the current month
		int i = startDay-1;
		for(int day=1;day<=numberOfDays;day++){
			model.setValueAt(day, i/7 , i%7 );    
			i = i + 1;
		}
	}
 
	public void getSelectDate() {
	    int selectRow = table.getSelectedRow();
	    int selectColumn = table.getSelectedColumn();
	    int day = (int) table.getModel().getValueAt(selectRow, selectColumn);
	    int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH)+1;
	    SELECTDATE = new String(year+"-"+month+"-"+day);
	    System.out.println("SELECTDATE: " + SELECTDATE);
	}
  
	// test
	public static void main(String[] arguments) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		SwingCalendar sc = new SwingCalendar();
		sc.setVisible(true);
	}
}