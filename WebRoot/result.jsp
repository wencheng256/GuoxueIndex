<%@ page language="java" import="com.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<jsp:useBean id="data" class="bean.data"></jsp:useBean>
<%
	User user=(User)session.getAttribute("user");
	if(user==null)
	{
		response.sendRedirect("error.html");
		return;
	}else if(user.getCheck()==0)
	{
		response.sendRedirect("question.jsp");
		return;
	}
	int score=user.getGrade();
	int time=user.getTime();
	int rank=data.getRank(score);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
  <title>国学达人知识竞赛</title>
  <link rel="stylesheet" href="style/end.css" type="text/css"/>
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
    <div id="shang"></div>
    <div id="zhong">
      <div id="zhong1"></div>
      <!-- 结果模拟 -->
      <div id="zhong2"><%=rank %></div>
      <div id="zhong3"><%=score %></div>
      <div id="zhong4"></div>
    </div>
    <div id="xia"><%=time %>秒</div>
  </div>
  <hr />


<!-- 页脚 -->
  <div id="foot">©2015 Shandong University,Weihai.All rights reserved.</div>


<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"16"},"slide":{"type":"slide","bdImg":"5","bdPos":"right","bdTop":"158"}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
</body>
</html>