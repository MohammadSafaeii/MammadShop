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
    echo '{"status":"error","message":"این ایمیل قبلا ثبت شده است"}';
} else {
    date_default_timezone_set('Iran');
    $expire_time = Date('Y-m-d', strtotime('7 days'));
    $token = sha1($email . $pass) . md5($pass . $email) . sha1(microtime());
    $refresh_token = md5($token) . sha1(microtime());
    $query = "INSERT INTO tbl_user(email,password,token,refresh_token,expire)VALUES (:email,:pass,:token,:refresh_token,:expire)";
    $res = $connect->prepare($query);
    $res->bindParam(":email", $email);
    $res->bindParam(":pass", $pass);
    $res->bindParam(":token", $token);
    $res->bindParam(":refresh_token", $refresh_token);
    $res->bindParam(":expire", $expire_time);
    $res->execute();
    echo '{"status":"success","message":"' . $token . '","refresh_token":"' . $refresh_token . '"}';

}

