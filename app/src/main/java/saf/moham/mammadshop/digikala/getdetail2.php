<?php
include "connect.php";
if (isset($_GET["user"])) {
    $user = $_GET["user"];
} else {
    $user = "";
}
$id = $_GET["id"];
$products = array();
$favorite = array();
//$user_id;
if ($user != "") {
    $query = "SELECT * FROM tbl_user WHERE token=:user";
    $res = $connect->prepare($query);
    $res->bindParam(":user", $user);
    $res->execute();
    $row = $res->fetch(PDO::FETCH_ASSOC);
    if ($row) {
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


    }


}


$query = "SELECT * FROM tbl_product WHERE id=:id";
$res = $connect->prepare($query);
$res->bindParam(":id", $id);
$res->execute();
while ($row = $res->fetch(PDO::FETCH_ASSOC)) {
    $record = array();
    $record["id"] = $row["id"];
    $record["title"] = $row["title"];
    $record["pprice"] = trans($row["price"]). " تومان";
    $record["price"] = trans($row["price"] - $row["discount"]). " تومان";
    $record["image"] = $row["image"];
    $record["colors"] = $row["colors"];
    $record["garantee"] = $row["garantee"];
    $record["introduction"] = $row["introduction"];
    $record["weight"] = $row["weight"];
    $record["rating_item"] = $row["rating_item"];
    $record["rating"] = $row["rating"];
    $record["properties"] = $row["properties"];
    $record["cat"] = $row["cat"];
    $record["fav"] = $favorite;


    $products[] = $record;


}
echo JSON_encode($products);


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