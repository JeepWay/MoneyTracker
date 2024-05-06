package com.jeepway.constant;

public class RecordConstants {
    public static final String TABLE_NAME = "records";
    
    public static final String COLUMN_RECORDID = "record_id";
    public static final String COLUMN_USERID = "user_id";
	public static final String COLUMN_CATEGORY = "category";
	public static final String COLUMN_DATE = "date";
	public static final String COLUMN_AMOUNT = "amount";
	public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_DETAIL = "detail";

    public static final String TYPEEXPENSE = "Expense";
    public static final String TYPEINCOME = "Income";
    
    public static final String[] TABLECOLUMNNAMES = {"record_id", "type", "category", "date", "amount", "detail"};
    public static final String[] LISTEXPENSE = {"Food", "Clothing", "Housing", "Transport", "Education", "Recreation", "Healthcare", "Others"};
    public static final String[] LISTINCOME = {"Salary", "Part-Time", "Investment", "Bonus", "Others"};
    public static final String[] LISTTYPE = {"Expense", "Income"};
}
