<?php
$id=$_GET["id"];
include "connect.php";
$query="DELETE FROM app_basket WHERE basket_id=:id";
$res=$connect->prepare($query);
$res->bindParam(":id",$id);
$res->execute();
if($res){
    echo '{"status":"success","message":"test"}';
}else{
    echo '{"status":"error","message":"not found"}';
}

?>