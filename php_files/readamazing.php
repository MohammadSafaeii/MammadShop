<?php
include "connect.php";
$query="SELECT * FROM tbl_product WHERE special=1";
$res=$connect->prepare($query);
$res->execute();
$products=array();
while($row=$res->fetch(PDO::FETCH_ASSOC)){
	$record=array();
	$record["id"]=$row["id"];
	$record["title"]=$row["title"];
    $record["pprice"] = trans($row["price"]). " تومان";
    $record["price"] = trans($row["price"] - $row["discount"]). " تومان";
	$record["image"]=$row["image"];
	$products[]=$record;
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