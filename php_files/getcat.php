<?php
include "connect.php";
$query="SELECT * FROM tbl_category WHERE parent=0";
$res=$connect->prepare($query);
$res->execute();
$products=array();
while($row=$res->fetch(PDO::FETCH_ASSOC)){
    $record=array();
    $record["id"]=$row["id"];
    $record["title"]=$row["title"];
    $record["parent"]=$row["parent"];
    $record["position"]=$row["position"];

    $products[]=$record;
}
echo JSON_encode($products);

?>