<?php
header("Content-Type: text/plain");

$requestUri = $_SERVER['REQUEST_URI'];

if (preg_match('#^/customers/([^/]+)/address$#', $requestUri, $matches)) {
    $name = $matches[1];
    echo "Adresse du client $name : 30-32 Av. de la république, Villejuif";
    exit;
}

echo "Service PHP opérationnel";
?>
