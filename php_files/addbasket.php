<?php
include "connect.php";
$id = $_GET["productId"];
$token=$_SERVER["HTTP_TOKEN"];
$cartItems = array();
$total_price=0;
$count=0;



$query="SELECT * FROM app_basket WHERE product_id=:id";
$res = $connect->prepare($query);
$res->bindParam(":id",$id);
$res->execute();
$row = $res->fetch();
$count=$row["count"];
if($row){
    $query="SELECT * FROM tbl_user WHERE token=:token";
    $res = $connect->prepare($query);
    $res->bindParam(":token",$token);
    $res->execute();
    $row = $res->fetch();
    if ($row) {
        $user_id=$row["id"];
        $email=$row["email"];
        $sql = "UPDATE app_basket SET count=:count WHERE user_id=:user_id AND product_id=:id";
        $res = $connect->prepare($sql);
        $count+=1;
        $res->bindParam(":count",$count);
        $res->bindParam(":id",$id);
        $res->bindParam(":user_id",$user_id);
        $res->execute();
        echo '{"status":"success","message":"add successfully"}';


    }else{
        echo '{"status":"error","message":"invalid token"}';
    }

}else {
    //insert
    $query = "SELECT * FROM tbl_user WHERE token=:token";
    $res = $connect->prepare($query);
    $res->bindParam(":token", $token);
    $res->execute();
    $row = $res->fetch();
    if ($row) {
        $user_id = $row["id"];
        $email = $row["email"];
        $count = 1;
        $sql = "INSERT INTO app_basket(product_id,user_id,user_email,count) VALUES(:id,:user_id,:email,:count)";
        $res = $connect->prepare($sql);
        $res->bindParam(":id", $id);
        $res->bindParam(":user_id", $user_id);
        $res->bindParam(":email", $email);
        $res->bindParam(":count", $count);
        $res->execute();
        echo '{"status":"success","message":"add successfully"}';
    }else{
        echo '{"status":"error","message":"invalid token"}';
    }
}
?>