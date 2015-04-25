package com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import bean.data;

public class Question {
	
	private String question;
	private String selecr_a;
	private String select_b;
	private String select_c;
	private String select_d;
	static private Vector<Question> arr;
	private static data data;
	
	private int correct;
	
	
	public Question()
	{
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getSelect_a() {
		return selecr_a;
	}

	public void setSelect_a(String selecr_a) {
		this.selecr_a = selecr_a;
	}

	public String getSelect_b() {
		return select_b;
	}

	public void setSelect_b(String select_b) {
		this.select_b = select_b;
	}

	public String getSelect_d() {
		return select_d;
	}

	public void setSelect_d(String select_d) {
		this.select_d = select_d;
	}

	public String getSelect_c() {
		return select_c;
	}

	public void setSelect_c(String select_c) {
		this.select_c = select_c;
	}

	public int getCorrect() {
		return correct;
	}

	public void setCorrect(int correct) {
		this.correct = correct;
	}
	
	static public Vector<Question> selectQuestion() throws SQLException
	{
		data=new data();
		if(arr==null)
		{
			arr=new Vector<Question>();
			ResultSet rs=data.getExercise();
			while(rs.next())
			{
				Question ques=new Question();
				ques.setQuestion(rs.getString(1));
				ques.setSelect_a(rs.getString(2));
				ques.setSelect_b(rs.getString(3));
				ques.setSelect_c(rs.getString(4));
				ques.setSelect_d(rs.getString(5));
				ques.setCorrect(rs.getInt(6));
				arr.add(ques);
			}
			System.out.println("初始化赋值成功");
		} 
		return arr;
	}
}
