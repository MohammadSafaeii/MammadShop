<?php
include "connect.php";
$email = $_POST["email"];
$pass = $_POST["pass"];

$query = "SELECT * FROM tbl_user WHERE email=:email AND password=:pass";
$res = $connect->prepare($query);
$res->bindParam(":email", $email);
$res->bindParam(":pass", $pass);
$row = $res->execute();
$result = $res->fetchColumn();
if ($result > 0) {
    if ($row["expire"] < date('Y-m-d')) {
        $token = sha1($row["refresh_token"]) . sha1(microtime());
        $refresh_token = md5($token) . sha1(microtime());

        date_default_timezone_set('Iran');
        $expire_time = Date('Y-m-d', strtotime('7 days'));

        $query = "UPDATE tbl_user  SET token = :token,
                    refresh_token = :refresh_token,
                    expire=:expire 
                    WHERE email = :email";
        $res = $connect->prepare($query);
        $res->bindParam(":token", $token);
        $res->bindParam(":refresh_token", $refresh_token);
        $res->bindParam(":expire", $expire_time);
        $res->bindParam(":email", $email);
        $res->execute();
        echo '{"status":"success","message":"' . $token . '","refresh_token":"' . $refresh_token . '"}';
    } else {
        echo '{"status":"success","message":"' . $row["token"] . '","refresh_token":"' . $row["refresh_token"] . '"}';
    }
} else {
    echo '{"status":"error","message":"ایمیل یا رمز عبور اشتباه است"}';
}