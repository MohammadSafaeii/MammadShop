<?php
include "connect.php";
$email = $_POST["email"];
$pass = $_POST["pass"];

$query = "SELECT * FROM tbl_user WHERE email=:email";
$res = $connect->prepare($query);
$res->bindParam(":email", $email);
$res->execute();
$row = $res->fetchColumn();
if ($row > 0) {
    echo '{"status":"success","message":"این ایمیل قبلا ثبت شده است"}';
} else {

}