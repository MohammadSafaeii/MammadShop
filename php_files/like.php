<?php
include "connect.php";
$id = $_GET["id"];
$query = "SELECT * FROM tbl_comment WHERE id=:id ";
$res = $connect->prepare($query);
$res->bindParam(":id", $id);
$res->execute();
while ($row = $res->fetch(PDO::FETCH_ASSOC)) {
    $like =(int) $row["likecount"];

}

$like++;

$query = "UPDATE tbl_comment SET likecount=:likecount WHERE id=:id ";
$res = $connect->prepare($query);
$res->bindParam(":likecount", $like);
$res->bindParam(":id", $id);
$res->execute();

if($res){
    echo '{"status":"success","message":"'.$id.'"}';
}else{
    echo '{"status":"error","message":"not found"}';
}


?>