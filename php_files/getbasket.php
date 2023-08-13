<?php
include "connect.php";
$token = $_SERVER["HTTP_TOKEN"];

$cartItems = array();
$total_price=0;
$query = "SELECT * FROM tbl_user WHERE token=:token";
$res = $connect->prepare($query);
$res->bindParam(":token", $token);
$res->execute();
$row = $res->fetch();
if ($row) {
    $user_id = $row["id"];
    $sql = "SELECT app_basket.*,tbl_product.title,tbl_product.price,tbl_product.image FROM app_basket  JOIN 
 tbl_product ON app_basket.product_id=tbl_product.id WHERE app_basket.user_id=:user_id ";
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
        $total_price=$total_price+($row["price"]*$row["count"]);
        $cart["count"] = $row["count"];
        $cartItems[] = $cart;
    }


    echo '{"status":"success","message":'. JSON_encode($cartItems).',"totalPrice":"'.$total_price.'"}';
    //echo JSON_encode($cartItems);

} else {
    echo '{"status":"error","message":"invalid token"}';
}


function trans($num)
{
    $persian_num_array = [
        '0'=>'۰',
        '1'=>'۱',
        '2'=>'۲',
        '3'=>'۳',
        '4'=>'۴',
        '5'=>'۵',
        '6'=>'۶',
        '7'=>'۷',
        '8'=>'۸',
        '9'=>'۹',
    ];

    $num = (float) $num;
    return strtr(number_format($num), $persian_num_array);
}
?>
