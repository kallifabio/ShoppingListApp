<?php
require "mainreader.php";

$name = $_POST["name"];
$user_name = $_POST["user_name"];
$password = $_POST["password"];

$mysqli_query = "INSERT INTO ShoppingAccount VALUES (NULL,'$name','$user_name','$password');";

$result = mysqli_query($conn,$mysqli_query);

//RESET the AUTOINCREMENT
$result = mysqli_query($conn,"SET @num := 0;");
$result = mysqli_query($conn,"UPDATE list SET id = @num := (@num+1)");
$result = mysqli_query($conn,"ALTER TABLE list AUTO_INCREMENT =1");

if($result){
print("Your have registered!");
}
else{
print("NOT Successful");
}

?>