package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mysql {
	
	private static Mysql mysql;
	private Connection connection;
	private Statement statement;
	private PreparedStatement sele;
	private Statement question;
	private ResultSet result=null;
	
	private Mysql()
	{
		try {
			Scanner in=new Scanner(getClass().getResourceAsStream("mysql.txt"));
			String host=in.nextLine();
			String duan=in.nextLine();
			String db=in.nextLine();
			String username=in.nextLine();
			String pass=in.nextLine();
			
			String url="jdbc:mysql://"+host+":"+duan+"/"+db+"?useUnicode=true&characterEncoding=utf-8";
			Class.forName("com.mysql.jdbc.Driver");
			connection= DriverManager.getConnection(url,username,pass);
			sele=connection.prepareStatement("SELECT * FROM ?");
			statement=connection.createStatement();
			question=connection.createStatement();
		} catch (SQLException e) {
			Logger.getLogger("log").log(Level.WARNING,e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			Logger.getLogger("log").log(Level.WARNING,e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static Mysql getInstance()
	{
		if(mysql!=null)
			return mysql;
		else{
			mysql=new Mysql();
			return mysql;
		}
	}
	
	public ResultSet query(String sql) throws SQLException
	{
		return statement.executeQuery(sql);
	}
	
	public boolean insert(String table,String name,String value) throws SQLException
	{
		String sql="INSERT INTO "+table+"("+name+") VALUES("+value+")";
		//System.out.println(sql);
		return statement.execute(sql);
	}
	
	public boolean delete(String table,int id) throws SQLException
	{
		String sql="DELETE * FROM "+table+" WHERE id="+id;
		return statement.execute(sql);
	}
	
	public ResultSet select(String table) throws SQLException
	{
		sele.setString(1, table);
		return sele.executeQuery();
	}
	public int getCheck(String name,String pass)
	{
		Mysql mysql=Mysql.getInstance();
		String sql="SELECT `check` FROM user WHERE num='"+name+"' AND password='"+pass+"'";
		try {
			ResultSet rs=query(sql);
			if(rs.next())
			{
				return rs.getInt(1);
			}else
			{
				return 2;
			}
		} catch (SQLException e) {
			Logger.getLogger("log").log(Level.WARNING,e.getMessage());
			e.printStackTrace();
			return 2;
		}
	}
	
	public ResultSet getExercise() throws SQLException
	{
		if(result!=null)
			return result;
		else{
			String sql="SELECT content,select_a,select_b,select_c,select_d,select_correct from exercise";
			result=question.executeQuery(sql);
			return result;
		}
	}
	public int saveScore(String id,int score,int time)
	{
		String sql="UPDATE user SET `check`=1 WHERE num='"+id+"'";
		String sql1="INSERT INTO grade(score,user,time) VALUES("+score+",'"+id+"',"+time+")";
		//System.out.println(sql);
		//System.out.println(sql1);
		try {
			statement.executeUpdate(sql);
			return statement.executeUpdate(sql1);
		} catch (SQLException e) {
			Logger.getLogger("log").log(Level.WARNING,e.getMessage());
			e.printStackTrace();
			return -1;
		}
	}
	public int update(String sql) throws SQLException
	{
		return statement.executeUpdate(sql);
	}
	
	public String getEmail(String num)
	{
		String sql="SELECT email FROM user WHERE num="+num;
		try {
			ResultSet rs=query(sql);
			if(rs.next()){
				return rs.getString(1);
			}else
			{
				return "error";
			}		
		} catch (SQLException e) {
			Logger.getLogger("log").log(Level.WARNING,e.getMessage());
			return "error";
		}
		
	}
}
