<?php
include "connect.php";
//$user=$_POST["user"];
$data = json_decode(file_get_contents('php://input'));
$param = json_encode($data, JSON_UNESCAPED_UNICODE);


/*$query = "INSERT INTO tbl_comment(param,user)VALUES (:param,:user)";
$res=$connect->prepare($query);
$res->bindParam(":param",$param);
$res->bindParam(":user",$user);
$res->execute();*/


echo '{"status":"success","message":"' . $user . '"}';

