<?php
include "connect.php";
$id=$_GET["id"];
$all=array();
$query="SELECT * FROM history WHERE product_id=:id";
$res=$connect->prepare($query);
$res->bindParam(":id",$id);
$res->execute();
$pics=array();
while($row=$res->fetch(PDO::FETCH_ASSOC)){
    $record=array();
    $record["id"]= $row["id"];
    $record["product_id"]= $row["product_id"];
    $record["date"]= $row["date"];
    $record["price"]= $row["price"];
    $all[]=$record;
}



//print_r($all);

echo json_encode($all);
?>