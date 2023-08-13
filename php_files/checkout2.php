<?php
$token = $_SERVER["HTTP_TOKEN"];
$orderId = $_GET["order_id"];
include "connect.php";
$query="SELECT * FROM tbl_user WHERE token=:token";
$res = $connect->prepare($query);
$res->bindParam(":token",$token);
$res->execute();
$row = $res->fetch();
if ($row) {
    $user_id = $row["id"];

    $query = "UPDATE app_basket
SET pay=1, order_id=:order_id
WHERE user_id=:user_id ";
    $res = $connect->prepare($query);
    $res->bindParam(":user_id", $user_id);
    $res->bindParam(":order_id", $orderId);
    $res->execute();
    echo '{"status":"success","message":"'.$orderId.'"}';
}else{
    echo '{"status":"error","message":"invalid token"}';
}
