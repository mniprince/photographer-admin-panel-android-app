<?php
session_start();

$host="localhost";
$dbUser="twinklew_pg";
$dbpwd="sksksk#@65";
$dbName="twinklew_photographersdb";

$conect= mysqli_connect($host,$dbUser,$dbpwd,$dbName);

if($conect==false){
	echo "<h1>Error established database connection!</h1>";
}

?>