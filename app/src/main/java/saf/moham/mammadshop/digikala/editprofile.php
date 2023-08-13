<?php
include "connect.php";
$email = $_GET["email"];
$name = $_GET["name"];
$family = $_GET["family"];
$code = $_GET["code"];
$home = $_GET["home"];
$mobile = $_GET["mobile"];
$birthday = $_GET["birthday"];
$jensiat = $_GET["jensiat"];
$khabarname = $_GET["khabarname"];
$level = $_GET["level"];

$query = "UPDATE tbl_user
SET email=:email, name=:name,family=:family,code_meli=:code,tel=:home,mobile=:mobile
,tavalod=:birthday,jensiat=:jensiat,khabarname=:khabarname,level=:level
WHERE email=:email ";
$res = $connect->prepare($query);
$res->bindParam(":email", $email);
$res->bindParam(":name", $name);
$res->bindParam(":family", $family);
$res->bindParam(":code", $code);
$res->bindParam(":home", $home);
$res->bindParam(":mobile", $mobile);
$res->bindParam(":birthday", $birthday);
$res->bindParam(":jensiat", $jensiat);
$res->bindParam(":khabarname", $khabarname);
$res->bindParam(":level", $level);
$res->execute();

if ($res) {
    echo '{"status":"success","message":"' . $email . '"}';
} else {
    echo '{"status":"error","message":"not found"}';
}


