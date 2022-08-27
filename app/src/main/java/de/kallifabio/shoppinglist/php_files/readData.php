<?php

require "reader.php";
$user_name = $_POST["user_name"];
$password = $_POST["password"];
//$user_name = "shah";
//$password = "1234";

$mysqli_query = "SELECT * FROM ShoppingAccount WHERE username LIKE '$user_name' AND password LIKE '$password'";

$result = mysqli_query($conn,$mysqli_query);

if(mysqli_num_rows($result)>0){
//print("Login success");
$row = mysqli_fetch_assoc($result);
$name =$row["name"];
Print("Login Successful..Welcome ".$name);

}
else{
print("Login not succes");
}

?>