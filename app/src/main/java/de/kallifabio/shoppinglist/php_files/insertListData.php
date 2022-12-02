<?php
require "mainreader.php";

$name = $_POST["name"];
$created_username = $_POST["created_username"];

$sql = "INSERT INTO ShoppingLists VALUES (NULL,'$name','$created_username');";

$result = mysqli_query($conn, $sql);

//RESET the AUTOINCREMENT
$result = mysqli_query($conn,"SET @num := 0;");
$result = mysqli_query($conn,"UPDATE list SET id = @num := (@num+1)");
$result = mysqli_query($conn,"ALTER TABLE list AUTO_INCREMENT =1");

if($result){
print("Liste wurde erstellt!");
}
else{
print("NOT Successful");
}

?>