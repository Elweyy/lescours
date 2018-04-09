  <?php
  session_start();
  $taille_suite= sizeof($_SESSION["suite_fibo"]);
  $val_courante_fibo=$_SESSION["suite_fibo"][$taille_suite-1]+ $_SESSION["suite_fibo"][$taille_suite-2];
  $_SESSION["suite_fibo"][]= $val_courante_fibo;








   ?>
