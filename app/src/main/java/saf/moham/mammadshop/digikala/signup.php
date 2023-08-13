<?php
include "connect.php";
$email = $_POST["email"];
$pass = $_POST["pass"];
$query = "INSERT INTO tbl_user(email,password)VALUES (:email,:pass)";
$res=$connect->prepare($query);
$res->bindParam(":email",$email);
$res->bindParam(":pass",$pass);
$res->execute();

if($res){
    echo '{"status":"success","message":"'.$email.'"}';
}else{
    echo '{"status":"error","message":"not found"}';
}