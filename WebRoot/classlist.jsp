<%@ page language="java" import="java.sql.*"  contentType="text/html; charset=utf-8"%>
<%
int id=4;
if(request.getParameter("school")!=null){
	id=Integer.parseInt(request.getParameter("school"));	
}

%>
<jsp:useBean id="data" class="bean.data" scope="page"></jsp:useBean>
<%
	String sql="SELECT id,name from class where school="+id;
	ResultSet rs=data.query(sql);
%>
<%while(rs.next()){ %>
<option value="<%= rs.getInt(1)%>"><%=rs.getString(2)%></option>
<%}%>