<?php
$email = $_GET["email"];
include "connect.php";
$query = "SELECT * FROM tbl_user WHERE email=:email";
$res = $connect->prepare($query);
$res->bindParam(":email", $email);
$res->execute();
$row = ($res->fetch(PDO::FETCH_ASSOC));
$user_id = $row["id"];

$query = "SELECT tbl_favorit.*,tbl_product.id,tbl_product.title,tbl_product.image
 FROM tbl_favorit
  JOIN  tbl_product
 ON tbl_favorit.idproduct=tbl_product.id WHERE  tbl_favorit.userId=:user_id ";
$res = $connect->prepare($query);
$res->bindParam(":user_id", $user_id);
$res->execute();
while ($row = $res->fetch(PDO::FETCH_ASSOC)) {
    $record = array();
    $record["fav_id"] = $row["fav_id"];
    $record["product_id"] = $row["id"];
    $record["title"] = $row["title"];
    $record["image"] = $row["image"];

    $favorites[] = $record;
}

echo json_encode($favorites);