  <?php
  session_start();

  if(isset($_SESSION["sess_fibo"])) {
    echo ($_SESSION["sess_fibo"]);
  } else{
    $_SESSION["sess_fibo"]= 1;
  }

  $_SESSION["suite_fibo"]=array();
  $_SESSION["suite_fibo"][0]=$_GET['a'];
  $_SESSION["suite_fibo"][1]=$_GET['b'];
  







   ?>
