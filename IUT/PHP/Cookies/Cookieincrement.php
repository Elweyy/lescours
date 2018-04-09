<?php

 if(isset($_COOKIE['cookie_increment'])){
    setcookie("cookie_increment",$i++,time()+60*60*2,"/");
    printf($_COOKIE['cookie_increment']);
  }else{
    $i=1;
    setcookie("cookie_increment",$i,time()+60*60*2,"/");
    printf($_COOKIE['cookie_increment']);
}
?>
