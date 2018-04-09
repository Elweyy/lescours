<?php
session_start();

  if(isset($_SESSION["sess_counter"])) {
    $_SESSION["sess_counter"]+=$_GET['session'];
    printf($_SESSION["sess_counter"]);
  } else{
    $_SESSION["sess_counter"]=$_GET['session'];
  }

?>
