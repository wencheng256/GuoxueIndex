<%@ page language="java" import="java.sql.*" pageEncoding="UTF-8"%>
<jsp:useBean id="data" class="bean.data"></jsp:useBean>
<%
	String sql="SELECT id,name FROM school";
	ResultSet rs=data.query(sql);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
  <title>注册账号</title>
  <link rel="stylesheet" href="style/zhuce.css" type="text/css"/>
  <script src="JS/jquery-1.11.2.min.js"></script>
  <script src="JS/zhuce.js"></script>
</head>

<body>
<!-- 头 -->
<form method="post" action="zhuce">
  <div id="head">
    <div id="logof"></div>
    <div  id="logo" >
      <img src="img/logo.jpg" height="100" width="350" alt="图片无法显示" /></div>
    </div>
    <hr />
<!--中间  -->
    <div id="center">
    <div id="left"></div>
    <div id="centerlogin">
      <div id="center-login"><!-- 白框-->
      <p id="four">注册信息</p><hr />
<!-- 填写信息 -->
       <div id="lotop">
      <table>
      <tr>
          <td class="loginword">姓名</td><td class="space"></td>
          <td><input type="text" class="kuang" name="name" placeholder="请填写真实姓名"/></td>
          <td class="text"></td>
      </tr>
      <tr>
          <td class="loginword">学院</td><td class="space"></td>
          <td><select name="school" id="xueyuan" class="fuxuan">
                <option value="" selected="selected">请选择</option>
                <%while(rs.next()){ %>
                <option value="<%=rs.getString(1) %>"><%=rs.getString(2) %></option>
                <%} %>
              </select>
          </td>
          <td class="text"></td>
      </tr>
      <tr>
          <td class="loginword">班级</td><td class="space"></td>
          <td><select name="class" id="xueyuan" class="fuxuan">
                <option value="3" selected="selected">请选择</option>
                <option value="3">12数字媒体技术</option>
              </select>
          </td>
          <td class="text"></td>
      </tr>
      <tr>
          <td class="loginword">邮箱</td><td class="space"></td>
          <td><input type="text" class="kuang" name="email"/></td>
          <td class="text" id="email"></td>
      </tr>
      <tr>
         <td class="loginword">用户名</td><td class="space"></td>
         <td><input type="text" class="kuang" name="num" placeholder="请填写学号"/></td>
         <td class="text" id="studentID"></td>
        </tr>
      <tr>
          <td class="loginword">密码</td><td class="space"></td>
          <td><input type="password" class="kuang" name="pass"/></td>
          <td class="text" id="password">6-12位数字或字母<br />（区分大小写）</td>
      </tr>
      <tr>
          <td class="loginword">确认密码</td><td class="space"></td>
          <td><input type="password" class="kuang" name="pw"/></td>
          <td class="text" id="pw"></td>
      </tr>
      </table>
      </div>
  <!-- 提交  -->
      <div id="lobot">
      <div id="sub">
        <input type="submit" id="submit" value=""/>
      </div>
      </div>
      </div>
    </div>
    <div id="right"></div>
  </div>
  <hr />
<!--脚  -->
</form>
  <div id="foot">©2015 Shandong University,Weihai.All rights reserved.</div>
</body>
</html>