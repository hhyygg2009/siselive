<style>
    h1 {
        text-align: center ;
    }
    table {
        border: 2px solid #aaa;
        width: 60%;
        margin: auto;
        border-collapse: collapse;/*将表格的边线变为单边线*/
    }

    table tr td {
        border: 2px solid #aaa;padding: 10px;
    }



</style>



<?php
session_start();

echo "<table>";
if(isset($_SESSION["car"]))//判断session内容
    $tmp =  $_SESSION["car"];
else
    $tmp=array();

if(isset($_GET["phone_name"]))//插入内容
{
    if (isset($tmp[$_GET["phone_name"]])) {
        $tmp[$_GET["phone_name"]]["num"] += 1;
    } else {
        $cart["phone_price"] = $_GET["phone_price"];
        $cart["num"] = 1;
        $tmp[$_GET["phone_name"]] = $cart;
    }
}

if(isset($_GET["op"]) && isset($_GET["line"])) {//加减删处理
    if ($_GET["op"] == "del" && $_GET["line"] == "all") {
        unset($tmp);
    }
    elseif ($_GET["op"] == "del") {
        $tmp[$_GET["line"]]["num"] = 0;
    } else {
        $tmp[$_GET["line"]]["num"] += $_GET["op"];
    }
    if ($tmp[$_GET["line"]]["num"] < 1) {
        unset($tmp[$_GET["line"]]);
}


}
$_SESSION["car"]=$tmp;

echo "<h1>购物车</h1>";
echo "<tr><td>商品名称</td><td>商品价格</td><td>数量</td><td>金额</td><td>增加</td><td>减少</td><td>删除</td></tr>";
foreach($tmp as $key => $value){
    echo "<tr><td>{$key}</td><td>{$value["phone_price"]}</td><td>{$value["num"]}</td><td>".$value["num"]*$value["phone_price"]."</td><td><a href='shoppingcar.php?op=1&line=$key'> +</a> </td><td><a href='shoppingcar.php?op=-1&line=$key'> -</a> </td><td><a href='shoppingcar.php?op=del&line=$key'> 删除</a> </td></tr>";
}

echo "</table>";
echo "<a href='shoppingcar.php?op=del&line=all'>清空</a>";
echo "<pre>";
var_dump($_GET);
var_dump($tmp);
echo "</pre>";