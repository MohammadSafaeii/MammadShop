<?php
include "connect.php";
$id=$_POST["id"];
$email=$_POST["email"];
$gaurantee=$_POST["gaurantee"];
$color=$_POST["color"];
$count_insert=1;
$count_update=0;


$query="SELECT * FROM tbl_basket WHERE cookie=:email AND idproduct=:id ";
$result=$connect->prepare($query);
$result->bindParam(":email",$email);
$result->bindParam(":id",$id);
$result->execute();
$row=$result->fetch(PDO::FETCH_ASSOC);
if($row==false){
	
	
$query2="INSERT INTO tbl_basket(cookie,idproduct,tedad,color,garantee) VALUES(:email,:id,:count,:color,:gaurantee)";
$res2=$connect->prepare($query2);
$res2->bindParam(":id",$id);
$res2->bindParam(":email",$email);
$res2->bindParam(":count",$count_insert);
$res2->bindParam(":color",$color);
$res2->bindParam(":gaurantee",$gaurantee);
$res2->execute();
echo "محصول به سبد خریده افزوده شد";
	
	
	
}else{
$tedad=$row["tedad"]++;
$count_update=$tedad+1;
$idbasket=$row["id"];


$query2="UPDATE tbl_basket SET tedad=:count   WHERE id=:id" ;
$res2=$connect->prepare($query2);
$res2->bindParam(":id",$idbasket);
$res2->bindParam(":count",$count_update);

$res2->execute();
echo "سبد خرید به روز شد";
	
	
	
	
}








?>