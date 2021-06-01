<?php
if(isset($_COOKIE["curentuser"])){
setcookie("curentuser",$userInputName,time()-(86400*9));
header ("location: photographers.php");	
}
	
?>