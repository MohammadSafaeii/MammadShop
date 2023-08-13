<?php
include "connect.php";
$id = $_GET["id"];
$query = "SELECT * FROM tbl_comment WHERE id=:id ";
$res = $connect->prepare($query);
$res->bindParam(":id", $id);
$res->execute();
while ($row = $res->fetch(PDO::FETCH_ASSOC)) {
    $dislike =(int) $row["dislikecount"];

}

$dislike++;

$query = "UPDATE tbl_comment SET dislikecount=:dislikecount WHERE id=:id ";
$res = $connect->prepare($query);
$res->bindParam(":dislikecount", $dislike);
$res->bindParam(":id", $id);
$res->execute();

if($res){
    echo '{"status":"success","message":"'.$id.'"}';
}else{
    echo '{"status":"error","message":"not found"}';
}
?>