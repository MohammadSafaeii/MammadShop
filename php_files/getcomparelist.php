<?php
include "connect.php";
$cat=$_GET["cat"];
$all=array();
$query="SELECT * FROM tbl_product WHERE cat=:cat";
$res=$connect->prepare($query);
$res->bindParam(":cat",$cat);
$res->execute();
$pics=array();
while($row=$res->fetch(PDO::FETCH_ASSOC)){
    $record=array();
    $record["id"]= $row["id"];
    $record["title"]= $row["title"];
    $record["image"]= $row["image"];
    $record["price"]= trans($row["price"]). " تومان";
    $all[]=$record;
}



//print_r($all);

echo json_encode($all);

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