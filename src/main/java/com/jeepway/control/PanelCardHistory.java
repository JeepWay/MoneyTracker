package com.jeepway.control;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.net.URI;
import java.io.IOException;
import java.net.URISyntaxException;

import com.jeepway.view.PanelCardHistoryUI;
import com.jeepway.utils.DBRecordsService;
import com.jeepway.model.Record;
import com.jeepway.constant.RecordConstants;

public class PanelCardHistory extends PanelCardHistoryUI implements ActionListener{
	/**
	 * Receive userid
	 */
	private int userID;
		
    private static Object[][] data = {};
    private Calendar cal = new GregorianCalendar();

    
    /*
     * Override JTable, make it uneditable
     */
    private class NoEditJTable extends JTable{
    	public NoEditJTable(DefaultTableModel tableModel){
			super(tableModel);
		}
		
		@Override
		public boolean isCellEditable(int row, int column) {
	        return false;
	    }
	}
    
    
	/**
	 * InnerClass : SwingCalendar(extends JFrame) 
	 */
	private class innerCalendar extends SwingCalendar{
		public innerCalendar(){
			super();
			this.setLocation(600, 360);
			
		}
		
		@Override
		public void getSelectDate() {
		    super.getSelectDate();
		    txtModifyDate.setText(SELECTDATE);
		    this.dispose();  // dispose after choose date
		}
	}
	
	
	/**
	 * Create the panel.
	 */
	public PanelCardHistory(int uid) {
		super();
		this.userID = uid;
		// init JTable tblHistory
		tblHistory = new NoEditJTable(new DefaultTableModel(data, RecordConstants.TABLECOLUMNNAMES));
		tblHistory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setSelectRecord();
			}
		});
		// make tblHistory scrollable
		scrollPaneHistory = new JScrollPane(tblHistory);
		scrollPaneHistory.setBounds(20, 181, 1072, 220);
		scrollPaneHistory.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelHistory.add(scrollPaneHistory);

		// add actionListener
		btnCalendar.addActionListener(this);
		btnModify.addActionListener(this);
		btnDelete.addActionListener(this);
		btnRefresh.addActionListener(this);
		btnSearch.addActionListener(this);

		// set range of year to select
		for(int i=cal.get(Calendar.YEAR)-10; i<=cal.get(Calendar.YEAR)+10; i++){
			boxSelectYear.addItem(i);
		}
		// show current month and year
		boxSelectMonth.setSelectedIndex(cal.get(Calendar.MONTH));	
		boxSelectYear.setSelectedItem(cal.get(Calendar.YEAR));		
		this.setActionPerformed();	
	}
	
	
	/**
	 * Override actionListener's method.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			this.loadRecords();
        }
		else if(e.getSource() == btnCalendar) {
			innerCalendar calendar = new innerCalendar();
			calendar.setVisible(true);
		}
		else if(e.getSource() == btnModify) {
			if( checkModifyRecord()) {
				this.modifyRecord();
				this.refreshRecord();
			}
		}
		else if(e.getSource() == btnDelete) {
			if( checkDeleteRecord()) {
				this.deleteRecord();
				this.refreshRecord();
			}
			
		}
		else if(e.getSource() == btnRefresh) {
			this.loadRecords();
			this.refreshRecord();
		}
	}
	
	/**
	 * Method to set mouse click action
	 */
	private void setActionPerformed() {
		// When select type, update catrgory JComboBox list
		boxModifyType.addItemListener(new ItemListener() {	
			@Override
			public void itemStateChanged(ItemEvent e){
		        if(e.getStateChange() == ItemEvent.SELECTED){
		        	changeCatrgoryList();
		        }
		    }
		});

		lblHyperlink.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        try {
		            Desktop.getDesktop().browse(new URI("https://hackmd.io/@ORAzzQWQ10/BJXwQZWIh#History%E9%A0%81%E9%9D%A2%E6%8C%87%E5%BC%95"));
		        } catch (IOException | URISyntaxException e1) {
		            e1.printStackTrace();
		        }
		    }
		});
	}



	private void setSelectRecord() {
		int selectRow = tblHistory.getSelectedRow();
		boxModifyType.setModel(new DefaultComboBoxModel<String>(RecordConstants.LISTTYPE));
		
	    //int record = (int) tblHistory.getModel().getValueAt(selectRow, 0);
		Object type = tblHistory.getModel().getValueAt(selectRow, 1);
	    Object category = tblHistory.getModel().getValueAt(selectRow, 2);
	    Object date = tblHistory.getModel().getValueAt(selectRow, 3);
	    int amount = (int) tblHistory.getModel().getValueAt(selectRow, 4);
	    Object detail = tblHistory.getModel().getValueAt(selectRow, 5);
	    
		// When click on a record, update record information in modify section
	    txtModifyDate.setText(date.toString());
	    txtModifyAmount.setText(String.valueOf(amount));
	    boxModifyType.setSelectedItem(type);
	    txtModifyDetail.setText(detail.toString());
	    
		// When click on a record, update catrgory choice in modify section
	    if(type.equals(RecordConstants.TYPEEXPENSE)) {
	    	boxModifyCategory.setModel(new DefaultComboBoxModel<String>(RecordConstants.LISTEXPENSE));
	    	boxModifyCategory.setSelectedItem(category);
	    }
	    else if (type.equals(RecordConstants.TYPEINCOME)){
	    	boxModifyCategory.setModel(new DefaultComboBoxModel<String>(RecordConstants.LISTINCOME));
	    	boxModifyCategory.setSelectedItem(category);
	    }
	}
	
	
	private void changeCatrgoryList() {	
		if(boxModifyType.getSelectedItem().equals(RecordConstants.TYPEEXPENSE)) {
	    	boxModifyCategory.setModel(new DefaultComboBoxModel<String>(RecordConstants.LISTEXPENSE));
	    }
	    else if (boxModifyType.getSelectedItem().equals(RecordConstants.TYPEINCOME)){
	    	boxModifyCategory.setModel(new DefaultComboBoxModel<String>(RecordConstants.LISTINCOME));
	    }
	}
	
	
	// Method to load expenses data from the database and display it in the table
	public void loadRecords() {
		int month = boxSelectMonth.getSelectedIndex()+1;	
		int year = (int)boxSelectYear.getSelectedItem();
		String type = (String)boxSelectType.getSelectedItem();
		
		try {
			if(type.equals("Both")) {
				ResultSet rs = DBRecordsService.searchRecords(userID, month, year);
			    tblHistory.setModel(buildTableModel(rs));
			}
			else if(type.equals(RecordConstants.TYPEEXPENSE) || type.equals(RecordConstants.TYPEINCOME)) {
				ResultSet rs = DBRecordsService.searchRecords(userID, month, year, type);
			    tblHistory.setModel(buildTableModel(rs));
			}
		}catch (Exception e) {
		    e.printStackTrace();
		}
		tblHistory.removeColumn(tblHistory.getColumnModel().getColumn(0));	// hide record_id column
	}
	
	// Method to edit an existing expense in the database
	private void modifyRecord() {
		int row = tblHistory.getSelectedRow();

		if (row >= 0) {
			int recordID = (int) tblHistory.getModel().getValueAt(row, 0);
			String category = (String)boxModifyCategory.getSelectedItem();
		    String date = txtModifyDate.getText();
		    int amount = Integer.parseInt(txtModifyAmount.getText());
		    String type = (String)boxModifyType.getSelectedItem();
		    String detail = txtModifyDetail.getText();
		    
		    int updatedRowCount = DBRecordsService.updateRecords(new Record(recordID, userID, category, date, amount, type, detail));
	        
	        if(updatedRowCount > 0) {
		    	JOptionPane.showMessageDialog(this, "Modify succesfully");
		    	this.loadRecords();
	        }
	        else if(updatedRowCount == -1) { 
	        	JOptionPane.showMessageDialog(this, "Modify failed");
	        }
		}
	}
	
	
	/**
	 * Method to check modify record
	 */ 
	private boolean checkModifyRecord(){
		int row = tblHistory.getSelectedRow();
		String amount = txtModifyAmount.getText();
        
        if(row < 0) {	// 有選取某一列， row 才會大於等於 0
        	JOptionPane.showMessageDialog(this, "Please select record to be modified in the above table.");
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
	
	
	private void deleteRecord() {
		int row = tblHistory.getSelectedRow();

		if (row >= 0) {
			int recordID = (int) tblHistory.getModel().getValueAt(row, 0);
		    
		    int updatedRowCount = DBRecordsService.deleteRecords(userID, recordID);
	        
	        if(updatedRowCount > 0) {
		    	JOptionPane.showMessageDialog(this, "Delete succesfully");
		    	this.loadRecords();
	        }
	        else if(updatedRowCount == -1) { 
	        	JOptionPane.showMessageDialog(this, "Delete failed");
	        }
		}
	}
	
	
	private boolean checkDeleteRecord(){
		int row = tblHistory.getSelectedRow();
        
		if(row < 0) {	// 有選取某一列， row 才會大於等於 0
        	JOptionPane.showMessageDialog(this, "Please select record to be modified in the above table.");
        	return false;
        }
        return true;
	}
	
	
	
	// Method to flush out the content of txtField and selectBox
	public void refreshRecord() {
		boxModifyCategory.setSelectedItem(null);
	    txtModifyDate.setText("");
	    txtModifyAmount.setText("");
	    boxModifyType.setSelectedItem(null);
	    txtModifyDetail.setText("");
	}
	
	
	// Method to build a JTable from a ResultSet object
	private static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException, Exception {
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("record_id");
		columnNames.add("type");
		columnNames.add("category");
		columnNames.add("date");
		columnNames.add("amount");
		columnNames.add("detail");
	
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> row = new Vector<Object>();
			row.add(rs.getInt(RecordConstants.COLUMN_RECORDID));
			row.add(rs.getString(RecordConstants.COLUMN_TYPE));
			row.add(rs.getString(RecordConstants.COLUMN_CATEGORY));
			row.add(rs.getString(RecordConstants.COLUMN_DATE));
			row.add(rs.getInt(RecordConstants.COLUMN_AMOUNT));
			row.add(rs.getString(RecordConstants.COLUMN_DETAIL));
			data.add(row);
		}
		return new DefaultTableModel(data, columnNames); // Update JTable
	}
}
