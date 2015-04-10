package bean;

import java.sql.ResultSet;
import java.sql.SQLException;


import com.Mysql;

public class data {

	private Mysql mysql;
	private ResultSet result;
	
	public data()
	{
		mysql=Mysql.getInstance();
	}
	
	public ResultSet query(String sql) throws SQLException
	{
		return mysql.query(sql);
	}
	
	public int getCount() throws SQLException
	{
		String sql="SELECT count(*) from exercise";
		ResultSet rs=mysql.query(sql);
		rs.next();
		return rs.getInt(1);
	}
	public ResultSet getExercise() throws SQLException
	{
		return mysql.getExercise();
	}
	public int getRank(int score)
	{
		String sql="SELECT count(*) from grade WHERE score>"+score;
		try {
			ResultSet rs=query(sql);
			if(rs.next())
			{
				return rs.getInt(1)+1;
			}else
			{
				return 1;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return 0;
		}
	}
		
}
