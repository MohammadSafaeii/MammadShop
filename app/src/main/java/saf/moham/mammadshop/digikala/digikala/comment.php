<?php
include "connect.php";
$id=$_POST["id"];
//$id=1;
$cat="";



$query3="SELECT * FROM tbl_product WHERE id=:id  ";
		$res3=$connect->prepare($query3);
		$res3->bindParam(":id",$id);
		$res3->execute();
		
		while($row3=$res3->fetch(PDO::FETCH_ASSOC)){
			$cat= $row3["cat"];
			
		}


$query4="SELECT * FROM tbl_comment_param WHERE idcategory=:cat  ";
		$res4=$connect->prepare($query4);
		$res4->bindParam(":cat",$cat);
		$res4->execute();
		$paramtitle=array();
		while($row4=$res4->fetch(PDO::FETCH_ASSOC)){
			$paramtitle[]=$row4["title"];
			
		}
		
		



$query="SELECT * FROM tbl_comment WHERE idproduct=:id AND confirm=1";
$res=$connect->prepare($query);
$res->bindParam(":id",$id);
$res->execute();
$all=array();
$title=array();
$matn=array();
$positive=array();
$negative=array();
$likecount=array();
$dislikecount=array();
$param=array();
$user=array();
$name=array();
while($row=$res->fetch(PDO::FETCH_ASSOC)){

	
	$title[]=$row["title"];
	$matn[]=$row["matn"];
	$positive[]=$row["posotive"];
	$negative[]=$row["negative"];
	$likecount[]=$row["likecount"];
	$dislikecount[]=$row["dislikecount"];
	$param[]=unserialize($row["param"]);
	$user[]=$row["user"];


	
}



foreach($user as $key=>$value){
	
	$query2="SELECT * FROM tbl_user WHERE id=:id  ";
		$res2=$connect->prepare($query2);
		$res2->bindParam(":id",$value);
		$res2->execute();
		
		while($row2=$res2->fetch(PDO::FETCH_ASSOC)){
			
			 $name[]=$row2["family"];
			
		}
}







$all["title"]=$title;
$all["matn"]=$matn;
$all["positive"]=$positive;
$all["negative"]=$negative;
$all["likecount"]=$likecount;
$all["dislikecount"]=$dislikecount;
$all["param"]=$param;
$all["name"]=$name;
$all["paramtitle"]=$paramtitle;



//print_r($all);
 echo json_encode($all);


?>