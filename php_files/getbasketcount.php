<?php
$email=$_GET["email"];
include "connect.php";
$query="SELECT * FROM app_basket WHERE user_email=:email AND pay=0";
$res=$connect->prepare($query);
$res->bindParam(":email",$email);
$res->execute();
echo '{"status":"success","message":"'.$res->rowCount().'"}'
?>