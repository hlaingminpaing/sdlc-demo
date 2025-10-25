<?php
// Load DB settings
$config = include('config.php');

// Connect to MySQL
$mysqli = new mysqli(
    $config['DB_HOST'],
    $config['DB_USER'],
    $config['DB_PASS'],
    $config['DB_NAME']
);

// Check connection
if ($mysqli->connect_errno) {
    echo "❌ Failed to connect: " . $mysqli->connect_error;
    exit();
}

echo "✅ Connected to MySQL database: " . htmlspecialchars($config['DB_NAME']) . "<br>";
echo "Hello from PHP!";
?>
