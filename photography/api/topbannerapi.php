<?php
header ('Content-type: application/json');
$method = $_SERVER['REQUEST_METHOD'];

switch ($method){
	case 'GET':
	handleGEToperation();
	break;
	
	case 'POST':
	echo "post r";
	break;
	
	case 'PUT':
	echo "put r";
	break;
	
	case 'DELETE':
	#code
	break;
	
	default:
	#code
	break;
}


 function handleGEToperation(){
	 include "../connectdb.php";
	 $sql= "SELECT * FROM bannertbl";
	 $topbanner= mysqli_query($conect, $sql);
	 
	 if(mysqli_num_rows($topbanner)>0){
		 $rows=array();
		 while($r= mysqli_fetch_assoc($topbanner))
		 {
			 $rows["topbanner"][]=$r;
			 }
			 echo json_encode($rows);
		 	 } else
			 {
				 echo '{"Not found"}';
			 }
	 
 }





?>