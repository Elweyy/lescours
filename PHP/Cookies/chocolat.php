  <?php


  if(isset($_COOKIE['chocolat'])){
    printf($_COOKIE['chocolat']);
  }else{
  setcookie("chocolat","lechococbon",time()+60*60*2,"/");
  printf('creation du cookie');
  }
  ?>
