package com.jeepway.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jeepway.constant.UserConstants;
import com.jeepway.model.User;

public class DBUserService {
    
    private static final String userLoginQuery = String.format("SELECT * FROM %s WHERE %s=? AND %s=?;", 
            UserConstants.TABLE_NAME, UserConstants.COLUMN_NAME, UserConstants.COLUMN_PASSWORD);

    private static final String userRegisterQuery = String.format("INSERT INTO %s(%s,%s,%s,%s) VALUES(?,?,?,?);", 
            UserConstants.TABLE_NAME, UserConstants.COLUMN_NAME, UserConstants.COLUMN_EMAIL, UserConstants.COLUMN_PHONE, UserConstants.COLUMN_PASSWORD);
    
    /**
     * Check existence of login data in database.
     * If found, return uid.
     * If not found, return -1.
     */
    public static User validateUserLogin(String commitUsername, String commitPassword) {
        User user = null;
        try{
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(userLoginQuery);
            ps.setString(1, commitUsername);
            ps.setString(2, commitPassword);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                user = new User(
                    rs.getInt(UserConstants.COLUMN_USERID),
                    rs.getString(UserConstants.COLUMN_NAME),
                    rs.getString(UserConstants.COLUMN_EMAIL),
                    rs.getString(UserConstants.COLUMN_PHONE),
                    rs.getString(UserConstants.COLUMN_PASSWORD)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    /**
     * Insert user data into database.
     * If insert succesfully, return updatedRowCount equal to 1.
     * If SQLException, return -1. 	 
     * If other exceptions, return -2.
     */
    public static int createUser(User user) {
    	try {
            Connection connection = DBConnection.getConnection();	
            PreparedStatement ps = connection.prepareStatement(userRegisterQuery);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getPassword());
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
}
