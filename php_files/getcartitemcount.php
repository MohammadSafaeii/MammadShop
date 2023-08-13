<?php
$token = $_SERVER["HTTP_TOKEN"];
include "connect.php";

$query = "SELECT * FROM tbl_user WHERE token=:token";
$res = $connect->prepare($query);
$res->bindParam(":token", $token);
$res->execute();
$count = 0;
$row = $res->fetch();
if ($row) {
    $user_id = $row["id"];
    $query = "SELECT * FROM app_basket WHERE user_id=:user_id  ";
    $res = $connect->prepare($query);
    $res->bindParam(":user_id", $user_id);
    $res->execute();
    while ($row = $res->fetch(PDO::FETCH_ASSOC)) {
        $count+= $row["count"];
    }
    echo '{"count":'.$count.'}';

} else {
    echo '{"count":"-1"}';
}


