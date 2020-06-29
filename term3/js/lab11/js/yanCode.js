// JavaScript Document
//在全局 定义验证码 
var code;  
function createCode(n){
  code = "";  
  var checkCode = document.getElementById("checkCode");
  //所有候选组成验证码的字符，当然也可以用中文的  
  var sourceStr= new Array(0, 1, 2,3, 4, 5, 6,7, 8, 9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');
    for (var i=0; i<n; i++) {
    var charIndex=Math.floor(Math.random()*sourceStr.length);
    code+=sourceStr[charIndex];
  }
  if (checkCode){
	 //设置或返回元素的class属性
    checkCode.className="code";
    checkCode.value=code;
  }
}