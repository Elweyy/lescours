/**************************************************************
  IMPORTANT : NE MODIFIER AUCUNE DES FONCTIONS FOURNIES !

  NE MODIFIER QUE LES FONCTIONS DONT LE CORPS EST VIDE, CELLES
  QUI DONT DEMANDÉES PAR L'ÉNONCÉ.
***************************************************************/


/* Inclusion d'une librairie standard */

#include <stdio.h>
#include <string.h>

/* Déclaration de constantes */

#define ETUDIANT_TAILLE_NOM 20
#define ETUDIANT_TAILLE_TABLEAU_MAX 30

/* Déclaration d'une structure de type Etudiant */

typedef struct Etud {
  char nom[TAILLE_NOM];
  float note;
} Etudiant;

/* Fonction de lecture de données */

void Etudiant_saisir_donnees(Etudiant t[], int taille)
{
  int i;

  for (i = 0; i < taille; i++)
  {
    if (i == 0)
    {
      printf("Nom du %d er étudiant :\n", i + 1);
    }
    else
    {
      printf("Nom du %d eme étudiant :\n", i + 1);
    }
    /* Saisir une chaîne de caractères */
    scanf("%s", t[i].nom);
    if (i == 0)
    {
      printf("Note du %d er étudiant :\n", i + 1);
    }
    else
    {
      printf("Note du %d er étudiant :\n", i + 1);
    }

    /* Saisir un réel */
    scanf("%f", &t[i].note);

    while ((t[i].note < 0) || (t[i].note > 20))
    {
      printf("Erreur ! Indiquez une valeur entre 1 et 20\n");
      scanf("%f", &t[i].note);
    }
  }
}

/* Fonction d'affichage de données lues */

void Etudiant_afficher_donnees(Etudiant t[], int taille)
{
  int i;

  /* Affichage de chaînes de caractères et de réels */
  for (i = 0; i < taille; i++)
    printf("Nom : %s, note : %f\n", t[i].nom, t[i].note);
}

/* Calcul de la moyenne des étudiants (à remplir) */
float moyenne_tab_etudiants(Etudiant tab[], int taille)
{
  int i = 0;
  float moyenne = 0;
  for (; i < taille; i++)
  {
    moyenne += tab[i].note;
  }
  return moyenne/taille;
}

/* Affichage de l'étudiant présentant la note minimale (à remplir) */
void Etudiant_note_min(Etudiant tab[], int taille)
{
  float note_min = tab[0].note;
  int i =  1;
  char ch[50];
  for (; i < taille; i++)
  {
    if (tab[i].note < note_min)
    {
      note_min = tab[i].note;
      strcpy(ch,tab[i].nom);
    }
  }
  printf("L'étudiant %s a la plus petite note : %f\n", ch, note_min);
}

/* Mise à jour de toutes les notes par un coefficient donné (à remplir) */
void Etudiant_mise_a_jour(Etudiant tab[], int taille, float coef)
{
  int i = 0;
  for (;i < taille; i++)
  {
    tab[i].note *= coef;
  }
}

/* Gestion du menu interactif */

void Etudiant_menu(Etudiant tab[], int taille)
{
  int choix;
  float coef;

  printf("Menu interactif\n");
  printf("0) Quitter\n");
  printf("1) Calculer la moyenne des etudiants\n");
  printf("2) Afficher la note minimale\n");
  printf("3) Faire une mise a jour des notes avec un certain coefficient\n");
  scanf("%d", &choix);

  switch (choix){
  case 1:
    printf("Moyenne des étudiants : %f\n", moyenne_tab_etudiants(tab, taille));
    break;
  case 2:
    note_min(tab, taille);
    break;
  case 3:
    printf("Mise a jour des notes , veuillez entrer un coefficient :\n");
    scanf("%f", &coef);
    mise_a_jour(tab, taille, coef);
    afficher_donnees(tab, taille);
    break;
  default:
    printf("Votre choix n'est pas dans la liste !\n");
    break;
  }
}

/* PROGRAMME PRINCIPAL */

int main ()
{
  Etudiant t[TAILLE_TABLEAU_MAX];
  int taille;

  printf("Nombre d'étudiants : \n");
  scanf("%d", &taille);
  saisir_donnees(t, taille);
  afficher_donnees(t, taille);
  menu(t,taille);

  return 0;
}
