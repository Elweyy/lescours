<?php

  $v1 =42;
  $v2= 73;

  echo "Somme :". ($v1 + $v2);

  echo "\n Variable 1 type :".gettype($v1);
  echo "\n Variable 1 type :".gettype($v2);


  $v1 ='442';
  echo "\n Variable 1 type :".gettype($v1);

  echo "\nSomme :". ($v1 + $v2);

  $v3=1337;
  $v4=01337;
  $v5=0x1337;
  $v6=3.14159;
  $v7="yopyop";
  $v8="yepyep";
  $v9=True;
  $v10=False;

  echo " La variable v3 est de type :".gettype($v3)" et a pour valeur".$v3; 
