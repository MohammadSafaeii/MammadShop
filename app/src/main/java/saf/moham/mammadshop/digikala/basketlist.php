<?php
$email = $_GET["email"];
include "connect.php";
$products=array();
$query = "SELECT app_basket.basket_id,tbl_product.id,tbl_product.title,
tbl_product.price,
tbl_product.garantee,
tbl_product.image
FROM app_basket
JOIN  tbl_product
ON app_basket.product_id=tbl_product.id WHERE  app_basket.user_email=:email AND pay=0";
$res = $connect->prepare($query);
$res->bindParam(":email", $email);
$res->execute();
while ($row = $res->fetch(PDO::FETCH_ASSOC)) {
    $record = array();
    $record["basket_id"] = $row["basket_id"];
    $record["product_id"] = $row["id"];
    $record["title"] = $row["title"];
    $record["guarantee"] = $row["garantee"];
    $record["price"] = $row["price"];
    $record["image"] = $row["image"];

    $products[] = $record;
}

echo json_encode($products);