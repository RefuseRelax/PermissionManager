package com.yy.pm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class JDBCManager {

	private static String url;
	private static String username;
	private static String password;
	private static String driver;
	
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet result;
	
	//加载静态文件
	static{
		ResourceBundle r = ResourceBundle.getBundle("jdbc");
		url = r.getString("url");
		username = r.getString("username");
		password = r.getString("password");
		driver = r.getString("driver");
	}
	
	//获取连接
	private void getConnection(){
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
			connection.setAutoCommit(true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//获取操作句柄
	private void getStatement(){
		try {
			if(connection == null || connection.isClosed()){
				getConnection();
			}
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public PreparedStatement getGeneralPreparedStatement(String sql){
		try {
			if(connection == null || connection.isClosed()){
				getConnection();
			}
			preparedStatement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return preparedStatement;
	}
	
	public PreparedStatement getReturnPrimaryPreparedStatement(String sql){
		try {
			if(connection == null || connection.isClosed()){
				getConnection();
			}
			preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return preparedStatement;
	}
	
	
	//查询
	public ResultSet query(String sql){
	    result = null;
		try {
			if(statement == null || statement.isClosed()){
				getStatement();
			}
			result = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return result;
		}
	};
	
	//增加
	public int insert(String sql){
		int i = 0 ;
		try {
			if(statement == null || statement.isClosed()){
				getStatement();
			}
			i = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return i;
		}
	}
	
	
	//更新
	public int update(String sql){
		int i = 0 ;
		try {
			if(statement == null || statement.isClosed()){
				getStatement();
			}
			i = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return i;
		}
	}
	
	/**
	 * 删除
	 * @param sql
	 * @return
	 */
	public int delete(String sql){
		int i = 0 ;
		try {
			if(statement == null || statement.isClosed()){
				getStatement();
			}
			i = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return i;
		}
	}
	
	
	/**
	 * 表是否存在
	 * @param sql
	 * @return
	 */
	public boolean isTabAxist(String sql){
		boolean isAxist = false ;
		try {
			if(statement == null || statement.isClosed()){
				getStatement();
			}
			isAxist = statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return isAxist;
		}
	}
	
	/**
	 * 关闭
	 */
	public void close(){
		try {
			if( null != result && !result.isClosed() ){
				result.close();;
			}
			if( null != statement && !statement.isClosed()){
				statement.close();;
			}
			if( null != connection && !connection.isClosed()){
				connection.close();;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
