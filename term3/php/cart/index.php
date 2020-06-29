<?php
header("content-type:text/html;charset=utf-8;");
$phone = array(
    array("iPhone 6 Plus","6088","i6p.jpg"),
    array("Galaxy S5","3299","galaxys5.jpg"),
    array("Moto X","2999","motox.jpg"),
    array("MX 4 Pro","2199","mx4pro.jpg"),
    array("Mate 7","3299","mate7.jpg"),
);
echo "<ul>";
foreach($phone as $v){
    echo "<li style='list-style: none;float: left;'><div><img src='./images/$v[2]'></div>";
    echo "<div style='text-align: center;color: red;'>$v[1]</div>";
    echo "<div style='text-align: center;'>$v[0]</div>";
    echo "<div style='text-align: center;'><a href='shoppingcar.php?phone_name=$v[0]&phone_price=$v[1]'>添加</a></div></li> ";
}
echo "</ul>";
