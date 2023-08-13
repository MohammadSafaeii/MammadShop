<?php
include "connect.php";
$email = $_POST["email"];
$pass = $_POST["pass"];
$query = "SELECT * FROM tbl_user WHERE email=:email AND password=:pass";
$res = $connect->prepare($query);
$res->bindParam(":email", $email);
$res->bindParam(":pass", $pass);
$res->execute();
$row = $res->fetch(PDO::FETCH_ASSOC);
if (!$row) {
    echo '{"status":"error","message":"not found"}';
} else {
    echo '{"status":"success","message":"'.$row["email"].'"}';


}