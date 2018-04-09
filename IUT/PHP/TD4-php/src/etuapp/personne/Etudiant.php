<?php
namespace etuapp\personnapp\personne;
require_once 'src/etuapp/personne/Personne.php';

class Etudiant extends Personne {
    protected $noEtudiant, $refFormation, $groupe, $marks, $generalAverage;

    public function __construct($nom)
    {
	     parent::__construct($nom);
       $this->marks = array();
       $generalAverage = 0;
    }

    // Exercice 4.2
    public function punition($n, $l) {
	echo "Je fais la punition...";
    }

    public function convertDays($days){
      $tabDays = [1=>'Lundi','Mardi','Mercredi','Jeudi','Vendredi','Samedi','Dimanche',];
      if (is_string($days)){
        return array_search($days,$tabDays);
      }
      else{
        return $tabDays[$days];
      }
    }

    public function addMark($mark,$component){
      if(array_key_exists($component, $this->marks)){
        array_push($this->marks[$component],$mark);
      }
      else{
        $this->marks[$component] =  array();
        array_push($this->marks[$component],$mark);
      }
    }

    public function echoMarks(){
      foreach($this->marks as $component => $marks){
        echo "<h4>".$component." : ";
        foreach($this->marks[$component] as $marks => $mark){
          echo $mark. " ";
        }
        echo "</h4>";
      }

    }

    public function averageMarks($component){
      $average = 0;
      $numberMarks=0;
      if(array_key_exists($component, $this->marks)){
         foreach ($this->marks[$component] as $marks => $mark){
            $average += $mark;
            $numberMarks ++;
          }
          return $average/$numberMarks;
      }
       return -1;
     }

     public function averageMarksAndComponents(){
       $generalAverage = 0;
       $numberComponents = 0;
       foreach($this->marks as $component=>$marks)
       {
         $numberComponents ++;
         $generalAverage += $this->averageMarks($component);
       }
       //echo "<h4>La moyenne générale est de : " . $generalAverage / $numberComponents."</h4>";
       return $generalAverage / $numberComponents;
     }

     public function addMarks($marks,$component){
       $tabMarks = explode(';',$marks);
       foreach ($tabMarks as $mark){
         $this->addMark($mark,$component);
       }
     }

     public function modifyMark($component, $num, $newMark){
       if(array_key_exists($component, $this->marks)){
         $this->marks[$component][$num] = $newMark;
       }
     }

}

?>
