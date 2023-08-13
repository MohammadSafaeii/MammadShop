<?php
include "connect.php";
$id = $_GET["productId"];
$token=$_SERVER["HTTP_TOKEN"];
$count=$_GET["count"];
$cartItems = array();
$total_price=0;
$query="SELECT * FROM tbl_user WHERE token=:token";
$res = $connect->prepare($query);
$res->bindParam(":token",$token);
$res->execute();
$row = $res->fetch();
if ($row) {
    $user_id=$row["id"];
    $sql = "UPDATE app_basket SET count=:count WHERE user_id=:user_id AND product_id=:id";
    $res = $connect->prepare($sql);
    $res->bindParam(":id",$id);
    $res->bindParam(":user_id",$user_id);
    $res->bindParam(":count",$count);
    $res->execute();

  /*  $sql = "SELECT app_basket.*,tbl_product.title,tbl_product.price,tbl_product.image FROM app_basket  JOIN
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
    echo '{"status":"success","message":"change count successfully"}';


} else {
    echo '{"status":"error","message":"invalid token"}';
}


?>