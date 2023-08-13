<?php
$id=$_GET["id"];
$token=$_SERVER["HTTP_TOKEN"];
$user_id="";
include "connect.php";

$query="SELECT * FROM tbl_user WHERE token=:token";
$res = $connect->prepare($query);
$res->bindParam(":token",$token);
$res->execute();
$row = $res->fetch();
if ($row) {
    $user_id=$row["id"];
    $sql="DELETE FROM tbl_favorit WHERE idproduct=:id and userId=:userId";
    $res = $connect->prepare($sql);
    $res->bindParam(":id",$id);
    $res->bindParam(":userId",$user_id);
    $res->execute();
    echo '{"status":"delete","message":"محصول با موفقیت از علاقه مندی ها حذف شد"}';

} else {
    echo '{"status":"error","message":"invalid token"}';
}
