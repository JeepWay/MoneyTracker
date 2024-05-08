package com.jeepway.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jeepway.constant.RecordConstants;
import com.jeepway.model.Record;

public class DBRecordsService {
    private static final String createRecordQuery = String.format("INSERT INTO %s(%s,%s,%s,%s,%s,%s) VALUES(?,?,?,?,?,?);", 
            RecordConstants.TABLE_NAME, RecordConstants.COLUMN_USERID, RecordConstants.COLUMN_CATEGORY, 
            RecordConstants.COLUMN_DATE, RecordConstants.COLUMN_AMOUNT, RecordConstants.COLUMN_TYPE, RecordConstants.COLUMN_DETAIL);

    private static final String searchRecordQuery1 = String.format("SELECT * FROM %s WHERE %s=?;", 
            RecordConstants.TABLE_NAME, RecordConstants.COLUMN_USERID);

    private static final String searchRecordQuery2 = String.format("SELECT * FROM %s WHERE %s=? AND MONTH(%s)=? AND YEAR(%s)=?;", 
            RecordConstants.TABLE_NAME, RecordConstants.COLUMN_USERID, RecordConstants.COLUMN_DATE, RecordConstants.COLUMN_DATE);

    private static final String searchRecordQuery3 = String.format("SELECT * FROM %s WHERE %s=? AND MONTH(%s)=? AND YEAR(%s)=? AND %s=?;", 
            RecordConstants.TABLE_NAME, RecordConstants.COLUMN_USERID, RecordConstants.COLUMN_DATE, RecordConstants.COLUMN_DATE, RecordConstants.COLUMN_TYPE);
            
    private static final String updateRecordQuery = String.format("UPDATE %s SET %s=?, %s=?, %s=?, %s=?, %s=? WHERE %s=? AND %s=?;",
            RecordConstants.TABLE_NAME, RecordConstants.COLUMN_CATEGORY, RecordConstants.COLUMN_DATE, RecordConstants.COLUMN_AMOUNT, 
            RecordConstants.COLUMN_TYPE, RecordConstants.COLUMN_DETAIL, RecordConstants.COLUMN_USERID, RecordConstants.COLUMN_RECORDID);

    private static final String deleteRecordQuery = String.format("DELETE FROM %s WHERE %s=? AND %s=?;", 
            RecordConstants.TABLE_NAME, RecordConstants.COLUMN_USERID, RecordConstants.COLUMN_RECORDID);

    private static final String sumRecordAmountQuery1 = String.format("SELECT SUM(%s) FROM %s WHERE %s=? AND MONTH(%s)=? AND YEAR(%s)=? AND %s=?;", 
            RecordConstants.COLUMN_AMOUNT, RecordConstants.TABLE_NAME, RecordConstants.COLUMN_USERID, 
            RecordConstants.COLUMN_DATE, RecordConstants.COLUMN_DATE, RecordConstants.COLUMN_TYPE);

    private static final String sumRecordAmountQuery2 = String.format("SELECT SUM(%s) FROM %s WHERE %s=? AND MONTH(%s)=? AND YEAR(%s)=? AND %s=? AND %s=?;", 
            RecordConstants.COLUMN_AMOUNT, RecordConstants.TABLE_NAME, RecordConstants.COLUMN_USERID, 
            RecordConstants.COLUMN_DATE, RecordConstants.COLUMN_DATE, RecordConstants.COLUMN_TYPE, RecordConstants.COLUMN_CATEGORY);

    /**
     * Insert user record into database.
     * If insert succesfully, return updatedRowCount larger than or equal to 1.
     * If SQLException, return -1. 	 
     * If other exceptions, return -2.
     */
    public static int createRecord(Record record) {
    	try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(createRecordQuery);
            ps.setInt(1, record.getUserID());
            ps.setString(2, record.getCategory());
            ps.setString(3, record.getDate());
            ps.setInt(4, record.getAmount());
            ps.setString(5, record.getType());
            ps.setString(6, record.getDetail());
            int updatedRowCount = ps.executeUpdate();
            return updatedRowCount; 
        } catch(SQLException se) {
            se.printStackTrace();
            return -1;
        } catch(Exception e) {
            e.printStackTrace();
            return -2;
        }
    }


    /**
     * Search all records form database according to userID
     * Return ResultSet
     */
    public static ResultSet searchRecords(int userID) {	
    	try {
            Connection connection = DBConnection.getConnection();
	        PreparedStatement ps = connection.prepareStatement(searchRecordQuery1);
            ps.setInt(1, userID);
		    ResultSet rs = ps.executeQuery();
		    return rs;
		} catch(Exception e) {
		    e.printStackTrace();
		}
    	return null;
    }

    /**
     * Search all records form database according to userID, selectMonth, selectYear
     * Return ResultSet
     */
    public static ResultSet searchRecords(int userID, int selectMonth, int selectYear) {
    	try {
            Connection connection = DBConnection.getConnection();
	        PreparedStatement ps = connection.prepareStatement(searchRecordQuery2);
            ps.setInt(1, userID);
            ps.setInt(2, selectMonth);
            ps.setInt(3, selectYear);
            ResultSet rs = ps.executeQuery();
	        return rs;
        } catch(Exception e) {
            e.printStackTrace();
        }
    	return null;
    }

    /**
     * Search all records form database according to userID, selectMonth, selectYear, selectType
     * Return ResultSet
     */
    public static ResultSet searchRecords(int userID, int selectMonth, int selectYear, String selectType) {
    	try {
            Connection connection = DBConnection.getConnection();
	        PreparedStatement ps = connection.prepareStatement(searchRecordQuery3);
            ps.setInt(1, userID);
            ps.setInt(2, selectMonth);
            ps.setInt(3, selectYear);
            ps.setString(4, selectType);
            ResultSet rs = ps.executeQuery();
		    return rs;
		} catch(Exception e) {
		    e.printStackTrace();
		}
    	return null;
    }

    /**
     * update record data in database.
     * If update succesfully, return updatedRowCount equal to 1.
     * If SQLException, return -1. 	 
     * If other exceptions, return -2.
     */
    public static int updateRecords(Record record) {
    	try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(updateRecordQuery);
            ps.setString(1, record.getCategory());
            ps.setString(2, record.getDate());
            ps.setInt(3, record.getAmount());
            ps.setString(4, record.getType());
            ps.setString(5, record.getDetail());
            ps.setInt(6, record.getUserID());
            ps.setInt(7, record.getRecordID());
	        int updatedRowCount = ps.executeUpdate();
	        return updatedRowCount;       
		} catch(SQLException se) {
	        se.printStackTrace();
	        return -1;
	    } catch(Exception e) {
		    e.printStackTrace();
		    return -2;
		}  	
    }

    /**
     * delete record data in database.
     * If delete succesfully, return updatedRowCount equal to 1.
     * If SQLException, return -1. 	 
     * If other exceptions, return -2.
     */
    public static int deleteRecords(int userID, int recordID) {
    	try {	
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(deleteRecordQuery);
	        ps.setInt(1, userID);
	        ps.setInt(2, recordID);	
	        int updatedRowCount = ps.executeUpdate();
	        return updatedRowCount;     
		}catch(SQLException se){
	        se.printStackTrace();
	        return -1;
	    }catch (Exception e) {
		    e.printStackTrace();
		    return -2;
		}  	
    }



    /**
     * Search all statictic data form database according to userID, month, year, type
     * Return sum of amount (Type: Object)
     */
    public static Object searchStatictic(int userID, int selectMonth, int selectYear, String selectType) {
    	try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sumRecordAmountQuery1);
            ps.setInt(1, userID);
            ps.setInt(2, selectMonth);
            ps.setInt(3, selectYear);
            ps.setString(4, selectType);
            ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Object sum = rs.getObject(1);
		    	if(sum != null) {
		    		return sum;
		    	} else {
		    		return 0;
		    	}	
			}
		} catch(Exception e) {
		    e.printStackTrace();
		}
    	return 0;
    }


    /**
     * Search all statictic data form database according to userID, month, year, type, category
     * Return sum of amount (Type: Object)
     */
    public static Object searchStatictic(int userID, int selectMonth, int selectYear, String selectType, String selectCategory) {
    	try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sumRecordAmountQuery2);
            ps.setInt(1, userID);
            ps.setInt(2, selectMonth);
            ps.setInt(3, selectYear);
            ps.setString(4, selectType);
            ps.setString(5, selectCategory);
            ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Object sum = rs.getObject(1);
		    	if(sum != null) {
		    		return sum;
		    	} else {
		    		return 0;
		    	}	
			}
		} catch(Exception e) {
		    e.printStackTrace();
		}
    	return 0;
    }

}
