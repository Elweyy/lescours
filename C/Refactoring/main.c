#include "etudiant.h"
#include <stdio.h>
#include <string.h>

int main ()
{
  Etudiant t[ETUDIANT_TAILLE_TABLEAU_MAX];
  int taille;

  printf("Nombre d'étudiants : \n");
  scanf("%d", &taille);
  etudiant_saisir_donnees(t, taille);
  etudiant_afficher_donnees(t, taille);
  etudiant_menu(t,taille);

  return 0;
}
