<?php
$mysqli = new mysqli("mysql", "root", "rootpass", "demo_db");

if ($mysqli->connect_errno) {
    echo "Failed to connect: " . $mysqli->connect_error;
    exit();
}
echo "✅ Connected to MySQL<br>";
echo "Hello from PHP!";
?>
