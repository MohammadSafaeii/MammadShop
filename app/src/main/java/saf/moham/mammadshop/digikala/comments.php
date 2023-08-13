<?php
include "connect.php";
$id = $_GET["id"];
$query = "SELECT * FROM tbl_comment WHERE idproduct=:id ORDER BY likecount DESC ";
$res = $connect->prepare($query);
$res->bindParam(":id", $id);
$res->execute();
$comments = array();
while ($row = $res->fetch(PDO::FETCH_ASSOC)) {
    $record = array();
    $record["id"] = $row["id"];
    $record["title"] = $row["title"];
    $record["passage"] = $row["matn"];
    $record["positive"] = $row["posotive"];
    $record["negative"] = $row["negative"];
    $record["likecount"] = $row["likecount"];
    $record["dislikecount"] = $row["dislikecount"];
    $record["param"] = $row["param"];
    $record["user"] = $row["user"];
    $record["suggest"] = $row["suggest"];



    $comments[] = $record;


}
echo JSON_encode($comments);

?>