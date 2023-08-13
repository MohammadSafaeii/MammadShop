<?php
$token=$_SERVER["HTTP_TOKEN"];
$id=$_GET["id"];
include "connect.php";
$cartItems = array();
$total_price=0;
$query="SELECT * FROM tbl_user WHERE token=:token";
$res = $connect->prepare($query);
$res->bindParam(":token",$token);
$res->execute();
$row = $res->fetch();
if ($row) {
    $user_id=$row["id"];
    $query="DELETE FROM app_basket WHERE product_id=:id AND user_id=:user_id";
    $res=$connect->prepare($query);
    $res->bindParam(":id",$id);
    $res->bindParam(":user_id",$user_id);
    $res->execute();


    /*$sql = "SELECT app_basket.*,tbl_product.title,tbl_product.price,tbl_product.image FROM app_basket  JOIN
 tbl_product ON app_basket.product_id=tbl_product.id WHERE app_basket.user_id=:user_id";
    $res = $connect->prepare($sql);
    $res->bindParam(":user_id", $user_id);
    $res->execute();
    while ($row = $res->fetch(PDO::FETCH_ASSOC)) {
        $cart = array();
        $cart["product_id"] = $row["product_id"];
        $cart["user_id"] = $row["user_id"];
        $cart["title"] = $row["title"];
        $cart["image"] = $row["image"];
        $cart["price"] = $row["price"];
        $total_price = $total_price + $row["price"];
        $cart["count"] = $row["count"];
        $cartItems[] = $cart;

    }*/

  //  echo '{"status":"success","message":'. JSON_encode($cartItems).',"totalPrice":"'.$total_price.'"}';

    echo '{"status":"success","message":"remove successfully"}';
} else {
    echo '{"status":"error","message":"invalid token"}';
}


?>