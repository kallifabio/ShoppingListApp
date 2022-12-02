<?php

$servername = "web07.bero-webspace.de";
$username = "nitschpas";
$password = "ehrenlosdatenbank!";
$database = "ehrenlos";

// Create connection
$conn = mysqli_connect($servername, $username, $password,$database);

if($conn) {
    echo '<h1>Connected to MySQL</h1>';
} else {
    echo '<h1>MySQL Server is not connected</h1>';
}
?>