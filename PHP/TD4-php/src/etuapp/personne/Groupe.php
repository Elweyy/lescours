<?php
namespace etuapp\personnapp\personne;
require_once 'src/etuapp/personne/Etudiant.php';

class Groupe{
  protected $noSemester, $name, $formation, $list;

  public function __construct($no, $na, $formation){
    $this->noSemester = $no;
    $this->name = $na;
    $this->formation = $formation;
    $this->list = array();
  }

  public function addStudent(Etudiant $e){
    array_push($this->list, $e);
  }

  public function averageMarksInComponent($component){
    $averageMarks = 0;
    $numStudents = 0;
    foreach($this->list as $student){
      $averageMarks += $student->averageMarks($component);
      $numStudents ++;
    }
    echo "<h4>La moyenne du groupe dans la matière ".$component." est de : ". $averageMarks / $numStudents."</h4></br>";
    return $averageMarks / $numStudents;
  }

  public function allMarksandAveragePerStudent($orderBy){
    if($orderBy === 'name'){
        krsort($this->list);
    }
    else{
        asort($this->list);
    }
    foreach($this->list as $num => $student){
      $student->generalAverage = $student->averageMarksAndComponents();
    }
      return $this->list;
    }
}

?>
