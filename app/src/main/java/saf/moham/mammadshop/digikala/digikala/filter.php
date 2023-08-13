<?php
include "connect.php";
$param=$_POST["param"];
//$param="کمتر از 100";
$cat=$_POST["cat"];
//$cat=4;
$all=array();
$pic=array();
$title=array();
$price=array();
if($param=="بیشتر از 100"){
	

$query="SELECT * FROM tbl_category WHERE id=:cat  ";
		$res=$connect->prepare($query);
		$res->bindParam(":cat",$cat);
		$res->execute();
		
		while($row=$res->fetch(PDO::FETCH_ASSOC)){
			$cat= $row["id"];
			
		}
		
		
$query2="SELECT * FROM tbl_product WHERE cat=:cat AND price >100 ";
		$res2=$connect->prepare($query2);
		$res2->bindParam(":cat",$cat);
		$res2->execute();
		
		while($row2=$res2->fetch(PDO::FETCH_ASSOC)){
			$title[]= $row2["title"];
			$price[]= $row2["price"];
			$idproduct=$row2["id"];
			
		}	
		
		
		$query3="SELECT * FROM tbl_gallery WHERE idproduct=:id  ";
		$res3=$connect->prepare($query3);
		$res3->bindParam(":id",$idproduct);
		$res3->execute();
		
		while($row3=$res3->fetch(PDO::FETCH_ASSOC)){
			$pic[]=$row3["img"];
			
		}	
		
		
		$all["title"]=$title;
		$all["pic"]=$pic;
		$all["price"]=$price;
		
		//print_r($all);
		
		
		echo json_encode($all);
			

	
	
	
	
	
	
}elseif($param=="بیشتر از 100"){
	
}else{
}
?>