<?php
include "connect.php";
$cat = $_GET["cat"];
$sort=$_GET["sort"];
if($sort==1){
    $query = "SELECT * FROM tbl_product WHERE cat=:cat ORDER BY viewd DESC ";
    $res = $connect->prepare($query);
    $res->bindParam(":cat", $cat);
    $res->execute();
    $products = array();
    while ($row = $res->fetch(PDO::FETCH_ASSOC)) {
        $record = array();
        $record["id"] = $row["id"];
        $record["title"] = $row["title"];
        $record["price"] = number_format($row["price"]). " تومان";
        $record["image"] = $row["image"];

        $products[] = $record;
    }
    echo JSON_encode($products);
}else if($sort==2){
    $query = "SELECT * FROM tbl_product WHERE cat=:cat ORDER BY sell DESC ";
    $res = $connect->prepare($query);
    $res->bindParam(":cat", $cat);
    $res->execute();
    $products = array();
    while ($row = $res->fetch(PDO::FETCH_ASSOC)) {
        $record = array();
        $record["id"] = $row["id"];
        $record["title"] = $row["title"];
        $record["price"] = number_format($row["price"]). " تومان";
        $record["image"] = $row["image"];

        $products[] = $record;
    }
    echo JSON_encode($products);
}else if($sort==3){
    $query = "SELECT * FROM tbl_product WHERE cat=:cat ORDER BY price DESC ";
    $res = $connect->prepare($query);
    $res->bindParam(":cat", $cat);
    $res->execute();
    $products = array();
    while ($row = $res->fetch(PDO::FETCH_ASSOC)) {
        $record = array();
        $record["id"] = $row["id"];
        $record["title"] = $row["title"];
        $record["price"] = number_format($row["price"]). " تومان";
        $record["image"] = $row["image"];

        $products[] = $record;
    }
    echo JSON_encode($products);
}else if($sort==4){
    $query = "SELECT * FROM tbl_product WHERE cat=:cat ORDER BY price ASC ";
    $res = $connect->prepare($query);
    $res->bindParam(":cat", $cat);
    $res->execute();
    $products = array();
    while ($row = $res->fetch(PDO::FETCH_ASSOC)) {
        $record = array();
        $record["id"] = $row["id"];
        $record["title"] = $row["title"];
        $record["price"] = number_format($row["price"]). " تومان";
        $record["image"] = $row["image"];

        $products[] = $record;
    }
    echo JSON_encode($products);
}else if($sort==5){
    $query = "SELECT * FROM tbl_product WHERE cat=:cat ORDER BY id DESC ";
    $res = $connect->prepare($query);
    $res->bindParam(":cat", $cat);
    $res->execute();
    $products = array();
    while ($row = $res->fetch(PDO::FETCH_ASSOC)) {
        $record = array();
        $record["id"] = $row["id"];
        $record["title"] = $row["title"];
        $record["price"] = number_format($row["price"]). " تومان";
        $record["image"] = $row["image"];

        $products[] = $record;
    }
    echo JSON_encode($products);
}


?>