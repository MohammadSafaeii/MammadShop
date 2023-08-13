<?php
include "connect.php";
$cat = $_GET["cat"];
$query = "SELECT * FROM tbl_product WHERE cat=:cat";
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
    $record["filter_item"] = "[
  {
  \"title\": \"برند\",
  \"values\":[{
  \"title\":\"سامسونگ\"
  },{
  \"title\":\"الجی\"
  },{
  \"title\":\"هوآوی\"
  },{
  \"title\":\"شیائومی\"
  },{
  \"title\":\"جی ال ایکس\"
  },{
  \"title\":\"اچ تی سی\"
  },{
  \"title\":\"اپل\"
  },{
  \"title\":\"آنر\"
  },{
  \"title\":\"ایسوس\"
  }]
  },{
    \"title\": \"نوع\",
    \"values\": [
      {
        \"title\": \"سیستم عامل اندروید\"
      },
      {
        \"title\": \"سیتم عامل IOS\"
      },
      {
        \"title\": \"سیستم عامل ویندوز فون\"
      },
      {
        \"title\": \"سایر سیستم عامل ها\"
      }
    ]
  },{
    \"title\": \"رزولوشن عکس\",
    \"values\": [
      {
        \"title\": \"13 مگا پیکسل\"
      },
      {
        \"title\": \"5 مگا پیکسل\"
      },
      {
        \"title\": \"12 مگا پیکسل\"
      },
      {
        \"title\": \"13 مگا پیکسل\"
      },
      {
        \"title\": \"16 مگا پیکسل\"
      },
      {
        \"title\": \"فاقد دوربین\"
      },
      {
        \"title\": \"23 مگا پیکسل\"
      },
      {
        \"title\": \"20 مگا پیکسل\"
      },
      {
        \"title\": \"فاقد دوربین\"
      }
    ]
  },{
    \"title\": \"تعداد سیم کارت\",
    \"values\": [
      {
        \"title\": \"دو\"
      },
      {
        \"title\": \"تک\"
      },
      {
        \"title\": \"سه\"
      }
    ]
  }
]";

    $products[] = $record;
}
echo JSON_encode($products);

?>