<?php
include "connect.php";
$user=$_GET["user"];
$title=$_GET["title"];
$positive=$_GET["positive"];
$negative=$_GET["negative"];
$matn=$_GET["passage"];




$query = "INSERT INTO tbl_comment(title,matn,posotive,negative,user)
VALUES (:title,:matn,:posotive,:negative,:user)";
$res=$connect->prepare($query);
$res->bindParam(":title",$title);
$res->bindParam(":matn",$matn);
$res->bindParam(":posotive",$positive);
$res->bindParam(":negative",$negative);
$res->bindParam(":user",$user);
$res->execute();

if($res){
    //echo '{"status":"success","message":"'.$user.'"}';
    echo '{"status":"success","message":"test"}';
}else{
    echo '{"status":"error","message":"not found"}';
}