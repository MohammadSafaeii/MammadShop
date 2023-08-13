<?php

include "connect.php";
$commentcount=0;
$paramcount=0;

$totalrating=0;
$ratingpoint=0;

$rating=array();
$hard=array();



$plus=0;



$id=$_POST["id2"];
//$id=1;
$query="SELECT * FROM tbl_product WHERE id=:id";
$res=$connect->prepare($query);
$res->bindParam(":id",$id);
$res->execute();
$pics=array();
while($row=$res->fetch(PDO::FETCH_ASSOC)){
	$record=array();
	$param=array();
	$comment=array();
	$allcomment=array();
	
	$record["title"]=$row["title"];
	$record["intro"]=$row["introduction"];
	$record["price"]=$row["price"];

	
	$record["color"]=$row["colors"];
	$record["gaurantee"]=$row["garantee"];
	
	$sql="SELECT * FROM tbl_color WHERE id=:id";
	$res2=$connect->prepare($sql);
	$res2->bindParam(":id",$record["color"]);
	$res2->execute();
	$row2=$res2->fetch(PDO::FETCH_ASSOC);
	$record["color"]=$row2["title"];
	
	$sql2="SELECT * FROM tbl_garantee WHERE id=:id";
	$res3=$connect->prepare($sql2);
	$res3->bindParam(":id",$record["gaurantee"]);
	$res3->execute();
	$row3=$res3->fetch(PDO::FETCH_ASSOC);
	$record["gaurantee"]=$row3["title"];
	
	
	
	$record["cat"]=$row["cat"];
	$sql4="SELECT * FROM tbl_comment_param WHERE idcategory=:id";
	$res4=$connect->prepare($sql4);
	$res4->bindParam(":id",$record["cat"]);
	$res4->execute();

	while($row4=$res4->fetch(PDO::FETCH_ASSOC)){
		$param[]=$row4["title"];		
		
	}

	$record["point"]=$param;
	$paramcount= count($record["point"]);
	

	$sql5="SELECT * FROM tbl_comment WHERE idproduct=:id AND confirm=1";
	$res5=$connect->prepare($sql5);
	$res5->bindParam(":id",$id);
	$res5->execute();
	
	while($row5=$res5->fetch(PDO::FETCH_ASSOC)){
		$comment[]=unserialize($row5["param"]);
		
	}
	
			foreach($comment as $com){

				foreach($com as $score){
					$totalrating=$totalrating+$score;
				}		
				
	}
	
	
	
	for($i=0;$i<$paramcount;$i++){
	$hard[$i]=0;
}
//print_r($hard);
	
	
	//echo $paramcount;
	foreach($comment as $comments){
		foreach($comments as $key=>$value){
			if(isset($hard[$key])){
				$hard[$key]=$hard[$key]+$value;
			}
			
				//print_r($comments);
		}
	}
	//print_r($hard);
	
	
	$record["comment"]=$comment;
	$record["hard"]=$hard;
	$commentcount= count($record["comment"]);
	
	

	
	
	
	$ratingpoint=$totalrating/$commentcount;
	$ratingpoint=$ratingpoint/$paramcount;
	$ratingpoint=($ratingpoint*$paramcount)/4;
		
	$record["rating"]=$ratingpoint;

	




	

	
	$pics[]=$record;

}
//print_r($pics);
echo JSON_encode($pics);
//print_r( $allcomment);
//print_r( $allcomment);
//echo "<br>";
//print_r($pics);


?>