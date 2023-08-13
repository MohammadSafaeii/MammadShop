<?php
include "connect.php";
//$email=$_POST["email"];
$email="info@clicksite.ir";
$basket=array();
$record=array();
$query="SELECT * FROM tbl_basket WHERE cookie=:email ";
$result=$connect->prepare($query);
$result->bindParam(":email",$email);
$result->execute();

while($row=$result->fetch(PDO::FETCH_ASSOC)){

	$record["count"]=$row["tedad"];
	$id=$row["idproduct"];
	$record["idbasket"]=$row["id"];
	
	$query2="SELECT * FROM tbl_product WHERE id=:id ";
	$result2=$connect->prepare($query2);
	$result2->bindParam(":id",$id);
	$result2->execute();
	$row2=$result2->fetch(PDO::FETCH_ASSOC);
	
	
	
	$record["title"]=$row2["title"];
	$record["color"]=$row2["colors"];
	$record["gaurantee"]=$row2["garantee"];
	$record["title"]=$row2["title"];
	$price=$row2["price"];
	$record["finalprice"]=$price*$record["count"];
	
	
	$query3="SELECT * FROM tbl_gallery WHERE idproduct=:id ";
	$result3=$connect->prepare($query3);
	$result3->bindParam(":id",$id);
	$result3->execute();
	$row3=$result3->fetch(PDO::FETCH_ASSOC);
	
	$record["img"]=$row3["img"];
	
	$basket[]=$record;
	
	
}

echo json_encode($basket);


?>