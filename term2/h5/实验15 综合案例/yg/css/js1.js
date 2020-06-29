// JavaScript Document
<script src="js/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function(){
    var len=$("#num>li").length;
    var MyTime=null;
    var index=0;
    //console.log(len);
    $("#num li").mouseover(function(){
        index = $("#num li").index(this);
		showimg(index);
    });
    
   function autoplay(){      
        MyTime=setInterval(function(){
                showimg(index);
                index++;
                if(index==len){index=0;}
        },1000); 
   }
   autoplay();
    
    $(".slide").hover(function(){
			if(MyTime){
			clearInterval(MyTime);
			}
		},function(){
			MyTime=setInterval(function(){
				showimg(index);
				index++;
				if(index==len){index=0;}
			},1000);				
	}); 	
	
    
    function showimg(i){
        //stop(stopAll,goToEnd),第一个参数是否停止被选元素的所有加入队列的动画，第二个参数是否允许完成当前的动画
        $("#slide").stop().animate({top: -400*i},800);
        $("#num li").eq(i).addClass("on").siblings().removeClass("on");//eq(index)获取第N个元素
       /*stopAll 为false时，不停止被选元素所有加入队列的动画,仅停止当前的动画。stopAll为true时，停止所有加入队列的动画（如goToend为true，直接跳到当前动画的最终效果）。
       goToend为false时，不允许直接跳到当前动画的最终效果(应该就是所谓的完成当前的动画吧)，goToend为true时，允许直接跳到完成当前动画的最终末尾效果
       */
		}
});
</script>