<?php
include "connect.php";
$email=$_GET["email"];
$product=$_GET["id"];
$parent=$_GET["parent"];
$title=$_GET["title"];
$user_id="";

$query = "SELECT * FROM tbl_user WHERE email=:email";
$res = $connect->prepare($query);
$res->bindParam(":email", $email);
$res->execute();
while($row=$res->fetch(PDO::FETCH_ASSOC)){
    $user_id=$row["id"];
}


$query = "INSERT INTO tbl_favorit(idproduct,userId,parent,title)
VALUES (:idproduct,:user_id,:parent,:title)";
$res=$connect->prepare($query);
$res->bindParam(":idproduct",$product);
$res->bindParam(":user_id",$user_id);
$res->bindParam(":parent",$parent);
$res->bindParam(":title",$title);
$res->execute();

if($res){
    //echo '{"status":"success","message":"'.$user.'"}';
    echo '{"status":"success","message":"test"}';
}else{
    echo '{"status":"error","message":"not found"}';
}