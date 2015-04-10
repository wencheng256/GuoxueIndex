$(document).ready(function(){
  		var i=0;
  		$("input[name=xuehao]").focus(function(){
  			$("#studentID").text("");
  		});
//		
  		$("input[name=xuehao]").blur(function(){
  			if($(this).val().length ==12 && $(this).val()!=''&& /201/.test(this.value)){
  				$("#studentID").text("输入正确！");
  			}else{
  				$("#studentID").html("输入<span style='color:red;'>错误</span>！");
  				this.value="";
  			    i++;
  			}
  			
  			
  		});
  		$("input[name=password]").blur(function(){
  			if($(this).val().length >= 6 && $(this).val().length <=12 && $(this).val()!=''){
  				$("#password").text("密码格式输入正确！");
  			}else{
  				$("#password").html("密码格式输入<span style='color:red;'>错误</span>！");
  				this.value="";
  				i++;
  			}
  			
  			
  		});
  		
  		$("input[name=pw]").blur(function(){
  			if($(this).val().length >= 6 && $(this).val().length <=12 && $(this).val()!=''&& $(this).val() == $('input[name="password"]').val())
  			{
  				$("#pw").text("密码格式输入正确！");
  			}else{
  				$("#pw").html("密码格式输入<span style='color:red;'>错误</span>！重新输入");
  				this.value="";
  				i++;
  			}
  			
  			
  		});
  		$("#img").click(function(){
  			if(i>0){
  				i=0;
  				alert("拒绝提交,请重新输入！");
  				return false;
  			}
  			
  			
  			
  		});
  		
  	});