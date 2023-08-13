<?php
include "connect.php";
$token=$_SERVER["HTTP_TOKEN"];
$productId=$_GET["id"];
$user_id="";

$query="SELECT * FROM tbl_user WHERE token=:token";
$res = $connect->prepare($query);
$res->bindParam(":token",$token);
$res->execute();
$row = $res->fetch();
if ($row) {
    $user_id=$row["id"];
    $sql = "INSERT INTO tbl_favorit(idproduct,userId) values (:productId,:userId)";
    $res = $connect->prepare($sql);
    $res->bindParam(":productId",$productId);
    $res->bindParam(":userId",$user_id);
    $res->execute();
    echo '{"status":"add","message":"محصول با موفقیت به علاقه مندی ها اضافه شد"}';

} else {
    echo '{"status":"error","message":"invalid token"}';
}

