<?php
  use PDO;

  try{
    $dsn= 'mysql:host=localhost;dbname=wishlist';
    $db = new PDO($dsn, $user, $pass, array(  PDO::ATTR_PERSISTENT => true ,
                                              PDO::ATTR_ERRMODE=>PDO::ERRMODE_EXCEPTION,
                                              PDO::ATTR_EMULATE_PREPARES => false,
                                              PDO::ATTR_STRINGIFY_FETCHES => false));

  }catch (PDOException $e){
    throw new DBException("connection : $dsn" . $e->getMessage() . '</br>');
  }

  $sql= 'SELECT * FROM item';
  try {
    $stmt = $db->prepare($sql);
    $stmt -> execute();
    while ($row = $stat -> fetch(PDO::FETCH_OBJ)) {
      print $row -> $nom
    }
  }

?>
