#ifndef H_Etudiant
#define H_Etudiant
#define ETUDIANT_TAILLE_NOM 20
#define ETUDIANT_TAILLE_TABLEAU_MAX 30


typedef struct Etud {
  char nom[ETUDIANT_TAILLE_NOM];
  float note;
} Etudiant;

void etudiant_saisir_donnees(Etudiant t[], int taille);

void etudiant_afficher_donnees(Etudiant t[], int taille);

float etudiant_moyenne_tab_etudiants(Etudiant tab[], int taille);

float moyenne_tab_etudiants(Etudiant tab[], int taille);

void etudiant_note_min(Etudiant tab[], int taille);

void etudiant_mise_a_jour(Etudiant tab[], int taille, float coef);

void etudiant_menu(Etudiant tab[], int taille);

#endif
