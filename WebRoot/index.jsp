<%@ page language="java" import="com.*" pageEncoding="UTF-8"%>
<%MyLogger.start(); %>
<%
	User user=(User)session.getAttribute("user");
	if(user!=null)
	{
		if(user.getCheck()!=0)
			response.sendRedirect("result.jsp");
		else
			response.sendRedirect("start.html");
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
  <title>国学达人知识竞赛</title>
  <link rel="stylesheet" href="style/login.css" type="text/css"/>
  <script src="JS/jquery-1.11.2.min.js"></script>
  <script src="JS/login.js"></script>

</head>

<body>
<!-- logo -->
  <div id="head">
    <div id="logof"></div>
    <div id="logo">
      <img src="img/logo.jpg" height="100" width="350" alt="图片无法显示" /></div>
    </div>
    <hr />
<!-- 中间部分 -->
  <div id="center">
    <div id="left"></div>
<form action="login" method="post">
    <div id="centerlogin">
      <div id="center-login"><!-- 白框-->
      <p id="six">参赛账号登陆</p><hr />
  <!-- 可填写部分 -->
      <div id="lotop">

      <table>
      <tr>
         <td class="loginword">用户名</td>
         <td><input type="text" class="kuang" name="name" placeholder="请填写学号"/></td>
         <td class="te" id="studentID"></td>
        </tr>
      <tr>
          <td class="loginword">密码</td>
          <td><input type="password" class="kuang" name="pass"/></td>
           <td class="te" id="password"></td>
      </tr>
      </table>
      <p id="forget"><a href="wangjimima.html">忘记密码？</a></p>
      </div>
  <!-- 登陆按钮 -->
      <div id="lobot">
      <div id="denglu"><input type="submit" value="" id="deng"/></div>
      <a href="zhuce.jsp"><img id="button2" src="img/register.png" height="38" width="103" alt="注册" /></a>
      </div>
      </div>
    </div>
  </form>
    <div id="right"></div>
  </div>
  <hr />
<!-- 页脚 -->
  <div id="foot">©2015 Shandong University,Weihai.All rights reserved.</div>
</body>
</html>