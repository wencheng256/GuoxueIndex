
  	$(document).ready(function(){
  		$("input[name=xuehao]").focus(function(){
  			$("#studentID").text("");
  		});
//		
  		$("input[name=xuehao]").blur(function(){
  			if($(this).val().length ==12 && $(this).val()!=''&& /201/.test(this.value)){
  				$("#studentID").text("");
  			}else{
  				$("#studentID").html("<span style='color:red;'>错误！</span>");
  				this.value="";
  			   
  			}
  			
  			
  		});
  		$("input[name=password]").blur(function(){
  			if($(this).val().length >= 6 && $(this).val().length <=12 && $(this).val()!=''){
  				$("#password").text("");
  			}else{
  				$("#password").html("<span style='color:red;'>错误！</span>");
  				this.value="";
  				i++;
  			}
  			
  			
  		});
  		
  		
  	});