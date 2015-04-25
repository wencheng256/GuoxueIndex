<%@ page language="java" import="java.sql.*" import="java.util.*" import="com.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="data" class="bean.data"></jsp:useBean>
<%User user=(User)session.getAttribute("user");
if(user==null)
	response.sendRedirect("index.jsp");
else if(user.getCheck()==1)
	response.sendRedirect("result.jsp");
%>
<%
   Vector<Question> arr1=Question.selectQuestion();
   int num=arr1.size();
%>
<% 
	int i=1;
	Random rand=new Random();
	int[] answer=new int[51];
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
  <title>国学达人知识竞赛 </title>
  <link rel="stylesheet" href="style/dati.css" type="text/css"/>
  <script src="JS/jquery-1.11.2.min.js"></script>
  <script>
     $(document).ready(function(){
     	$("input:radio").click(function(){
     	    if(this.checked){
     	    	$("#val").text(this.value);
     	     }
     		
     	});
     $("#jiaojuan").click(function(){
    	 $("#tim").val($("#tt").text());
    	 alert("您的用时是"+$("#tt").text()+"秒");
        });
     });
  </script>
</head>


<body>
<!-- logo -->
<form method="post" action="result">
<div id="heitiao">
  <div id="juzhong">
    <div id="time" class="biaoti">答题时间&nbsp;&nbsp;&nbsp;<span id="tt">0</span>秒</div>
    <div class="kong"></div>
    <div id="jiaojuan" class="biaoti"><input type="submit" value="交卷" id="sub"/></div>
    <div class="kong"></div>
  </div>
</div>
<div id="head"><img src="img/datiback.png" height="300" width="1200" alt="图片无法显示" />
<hr /></div>

<div id="tiku">
<!-- 1道题实例 -->
<%while(i<51){ %>
<%Question que=arr1.get(rand.nextInt(num)); %>
    <p class="timu"><%=i %>、<%=que.getQuestion()%></p>
    <br />
          <table>
            <tr><td class="num"><input type="radio" name="radio<%=i%>" value="1" /> A</td><td class="table"><%=que.getSelect_a()%></td></tr>
            <tr><td class="num"><input type="radio" name="radio<%=i%>" value="2" /> B</td><td class="table"><%=que.getSelect_b()%></td></tr>
            <tr><td class="num"><input type="radio" name="radio<%=i%>" value="3" /> C</td><td class="table"><%=que.getSelect_c()%></td></tr>
            <tr><td class="num"><input type="radio" name="radio<%=i%>" value="4" /> D</td><td class="table"><%=que.getSelect_d()%></td></tr>
          </table>
     <br/>
<%
answer[i]=que.getCorrect();
i++;	} %>
<%session.setAttribute("answer",answer); %>
</div>

  <!--脚  -->
  <hr />
  <div id="foot">©2015 Shandong University,Weihai.All rights reserved.</div>
  <input type="hidden" value="" name="time" id="tim"/>
  </form>
  <script>
  
  	function run(){
  		var v=document.getElementById('tt');
  		v.innerHTML=v.innerHTML*1+1;
  		
  	}
  	window.setInterval("run();",1000);
  	
  	
  </script>
  </body>
  </html>