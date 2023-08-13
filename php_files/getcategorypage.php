<?php
include "connect.php";
$query = "SELECT tbl_favorit.idproduct,tbl_favorit.userId,tbl_product.* FROM tbl_favorit  JOIN  tbl_product ON tbl_favorit.idproduct=tbl_product.id WHERE  tbl_favorit.userId=:user ";
$res = $connect->prepare($query);
$res->bindParam(":user", $row["id"]);
$res->execute();
while ($row = $res->fetch(PDO::FETCH_ASSOC)) {
    $fav = array();
    $fav["fav_id"] = $row["id"];
    $fav["fav_idproduct"] = $row["idproduct"];
    $fav["fav_userId"] = $row["userId"];
    $fav["fav_title"] = $row["title"];
    $fav["fav_image"] = $row["image"];

    $favorite[] = $fav;


}
