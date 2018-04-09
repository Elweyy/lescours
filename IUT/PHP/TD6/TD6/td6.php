<?php
/**
 * File:  td6.php
 * Creation Date: 12/07/2016
 * description:
 *
 * @author: canals
 */
 http_response_code(201);

print $_SERVER['REQUEST_METHOD'].' '.$_SERVER['HTTP_HOST'].' '.$_SERVER['SERVER_PROTOCOL'].'<br>';
foreach (getallheaders() as $name => $value) {
  echo "$name: $value\n<br>";
}


http_response_code(201);

//var_dump($_SERVER);


?>
