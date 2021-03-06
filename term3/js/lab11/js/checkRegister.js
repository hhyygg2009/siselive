// JavaScript Document
//页面加载就绪后，调用相关的函数
$(document).ready(function(){
	//运用简单过滤器，选中首行并聚焦
 $("input:first").focus();
 //根据标签选择器，选择所有的文本框
  var inputs=$("input");
   //根据标签选择器，选择所有的单元格
 var tds=$(input);
 //用for...in语句实现对象的遍历
for(var i in inputs){
	//依次循环遍历第i个文本框的值，判断是否为空（即长度为0）
	if(inputs.eq(i).text().length==0){
		//设置当前的文本框类样式为.userRed
		inputs.eq(i).addClass("userRed");
		//在其右侧对应的单元格内显示提示信息"不能为空，请重新输入！"
		if(i==6||i==7||i==9) continue;//除去下拉列表和多选列表的三行
		tds.eq(3*i+2).html("不能为空，请重新输入！");
		}
		//当第i个文本框聚焦的时候，执行后面的函数
	inputs.eq(i).focus(function(e) {
		//为其添加类样式为.userRed
	inputs.eq(i).addClass("userRed");
    });
}
});
//页面加载就绪后，调用相关的函数
$(document).ready(function(){ 
//调用产生验证码的函数
createCode(4);
//输入验证码后，其文本框失去焦点时，执行后面的函数
$("#input1").blur(function(e) {
	//验证输入的是否正确
   if($("#input1").val()!=code){
		 //在其右侧的单元格里显示提示信息"验证码不正确，请重新输入！"
	$("#yancode1").get(0).innerHTML="验证码不正确，请重新输入！";
	 //为验证码框添加类样式为.userRed
	 $("#input1").addClass("userRed");
	  //验证码框聚焦
	$("#input1").focus();
		return;
	}else{
	//如果格式正确，则在右侧的单元格里显示提示信息”ok!“
    $("#yancode1").get(0).innerHTML="ok!";
	 //为验证码框删除类样式为.userRed
	$("#input1").removeClass("userRed");  
 }		
});
//单击验证码文本框时，调用createCode(6)的函数，产生新的验证码
$("#checkCode").click(function(e){
	createCode(4);
});

//用户名文本框失去焦点的时候，执行后面的代码
$("input").eq(0).bind("blur",function(){
	//如果用户名不是3-6个字符
	 if($("#name").val().length<3||$("#name").val().length>6){
		 //在右侧的单元格里显示提示信息"用户名格式不正确，请重新输入！"
		 $("#name1").get(0).innerHTML="用户名格式不正确，请重新输入！";
		 //为用户名文本框添加类样式为.userRed
		 $("#name").addClass("userRed");
		 //文本框聚焦
		$("#name").focus();
return;
}else{
	//如果格式正确，则在右侧的单元格里显示提示信息”ok!“
	$("#name1").get(0).innerHTML="ok!";
	//为用户名文本框删除类样式为.userRed
	$("#name").removeClass("userRed");
	}	
 } );
 <!--仿照上面的例子，进行密码框格式验证-->
 //密码框失去焦点的时候，执行后面的代码
 $("input:password").bind("blur",function(){
//如果密码不是6-16个字符	 
 if($("input:password").val().length<6 ||"input:password").val().length>16  ){
	 //为密码框添加类样式为.userRed
		$("pass1").addClass("userRed");
	 //在右侧的单元格里显示提示信息"密码格式不正确，请重新输入！"	
	  $("pass1").get(0).innerHTML="密码格式不正确，请重新输入！";
	  //为密码框添加类样式为.userRed
	  $("pass").addClass("userRed");
	    //密码框聚焦
		$("pass").get[0].focus();	
		return;	
	}else{
		//否则，格式正确，则在右侧的单元格里显示提示信息”ok!“
		  $("password1").get(0).innerHTML="ok!";
		//为密码框删除类样式为.userRed
	   $("password1").removeClass("userRed");
	}
	//如果确认密码不是6-16个字符	 
	 if($("#password").val().length>16||$("#password").val().length<6){
		 //为确认密码框添加类样式为.userRed
		 $("#password").addClass("userRed");
		  //在右侧的单元格里显示提示信息"确认密码格式不正确，请重新输入！"	 
	  $("#password1").get[0].innerHTML="确认密码格式不正确，请重新输入！";
	   //确认密码框聚焦
		$("#password").focus();	
		return;	
		//如果密码和确认密码不一致
	}else if($("#password").!=$("#pass").val()){
		 //在右侧的单元格里显示提示信息"确认密码格式不正确，请重新输入！"	 
		$("#password1").get[0].innerHTML="确认密码与密码不一致，请重新输入！";
		//为确认密码框添加类样式为.userRed
		 $("#password").addClass("userRed");
		  //密码框聚焦
		$("#password").focus();	
		return;	
	}
	else{
		//否则，格式正确，则在右侧的单元格里显示提示信息”ok!“
		$("#password1").get[0].innerHTML="ok!";
		//为确认密码框删除类样式为.userRed
	   $("#password").removeClass("userRed");
	}
});
//运用属性选择器选择邮件文本框对象，失去聚焦点的时候，执行后面的函数
 $("input[id=email]").bind("blur",function(){
	 //验证是否满足正则表达式
if(!$("#email").val().match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/)){
	 //在右侧的单元格里显示提示信息"邮箱格式不正确，请重新输入！"	 
		 $("#email1").get(0).innerHTML="邮箱格式不正确，请重新输入！";
		 //为邮件文本框加类样式为.userRed
		 $("#email").addClass("userRed");
		 //邮件框聚焦
		$("#email").focus();
return;
}else{
	//如果格式正确，则在右侧的单元格里显示提示信息”ok!“
	$("#email1").get(0).innerHTML="ok!";
	//为邮件框移除类样式.userRed
	$("#email").removeClass("userRed");
	} 
 });
  <!--仿照上面的例子，进行电话号码格式验证-->
 //获取电话号码文本框对象，失去焦点时执行后面的程序
 $("input").eq(4).bind("blur",function(){
	 //判断电话号码是否符合正则表达式
 if($("input").eq(4).match(/^1[3,5,8]\d{9}$/)){
	 //如果不符合要求，则在右侧单元格里显示提示信息”ok!“
		 $("input1").get[0]="电话号码格式不正确，请重新输入！";
		  //为电话号码文本框加类样式为.userRed
		 $("input").addClass("userRed");
		   //电话号码框聚焦
		$("input").focus();
return;
}else{
	//如果格式正确，则在右侧的单元格里显示提示信息”ok!“
	 $("input1").get[0]="ok!";
	 //为电话号码文本框加类样式为.userRed
	$("input").removeClass("userRed");;
	}
 });
 <!--仿照上面的例子，进行电子邮件格式验证-->
 //先获取邮件文本本框，失去焦点的时候，执行后面的函数
  $("input").eq(5).bind("blur",function(){
	  //判断邮件格式是否正确
if($("input").eq(5).match(/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/)){
	//如果不正确，则在右侧的单元格里显示提示信息”身份证号格式不正确，请重新输入!“
		$("input1").get(5).innerHTML="身份证号格式不正确，请重新输入！";
		  //为邮件文本框加类样式为.userRed
		 $("input").eq(5).addClass("userRed");
		   //身份证文本框聚焦
		$("input").get(5).focus();
return;
}else{
	//如果格式正确，则在右侧的单元格里显示提示信息”ok!“
	<!--仿照上面的例子，进行电话号码格式-->="ok!";
	//为身份证文本框加类样式为.userRed
	<!--仿照上面的例子，进行电话号码格式-->;
	}
  });
  <!--仿照上面的例子，进行邮政编码格式-->
   $("input").eq(6).bind("blur",function(){
	  //判断邮政编码格式是否正确
if($("input").eq(6).match(/^[0-9]{6}$/)){
		 //为邮件文本框加类样式为.userRed
	    $("input").eq(6).addClass("userRed");
		 $("input1").get(6).innerHTML="邮政编码格式不正确，请重新输入";
		  //邮政编码框聚焦
		$("input").get(6).focus();
return;
}else{
	//如果格式正确，则在右侧的单元格里显示提示信息”ok!“
	$("input1").get(6).innerHTML="ok!";
	//为邮件文本框删除类样式为.userRed
	$("input").eq(6).removeClass("userRed");
	}
   });
   //点击注册按钮的时候，弹出注册成功信息，并跳转到华软首页
//根据属性选择器或表单属性选择器选择注册按钮
$("user_submit").bind("click",function(){
	alert("注册成功！");
	window.location.href="http://www.sise.com.cn";
	});
});

