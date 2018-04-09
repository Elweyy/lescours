    #include <stdio.h>
    #include <stdlib.h>

    #include "liste.h"

    /* Initialisation d'une liste */
    Liste liste_initialiser()
    {
      return(NULL);
    }

    /* Test si une liste est vide */
    int liste_vide(Liste l)
    {
      return (l == NULL);
    }

    /* Ajout d'un élément en tête de liste */
    Liste liste_teteinserer(Liste l, int e)
    {
      Liste p;

      p = (Liste) malloc(sizeof(TypeCellule));
      if (p == NULL) {
        printf("Allocation impossible...\n");
        exit(1);
      }
      p->val = e;
      p->suc = l;

      return p;
    }

    /* Suppression d'un élément en tête de liste */
    Liste liste_tetesupprimer(Liste l)
    {
      Liste p = NULL;

      if (!liste_vide(l)) {
        p = l->suc;
        free(l);
      }

      return (p) ;
    }

    void liste_afficher(Liste l){


      if(liste_vide(l)){
        printf("Pas de bol l'ami, c'est vide !");
      }else{
        printf("%d \n",l->val);
        while(l->suc != NULL){
        l=l->suc;
        printf("%d \n",l->val);
        }
      }
    }

      Liste liste_queueinserer(Liste l, int e){

        Liste tete =l;
        Liste p;

        if(!l){
          return liste_teteinserer( l, e);
        }
        while(l->suc != NULL){
          l=l->suc;
        }


        p = (Liste) malloc(sizeof(TypeCellule));
        if (p == NULL) {
          printf("Allocation impossible...\n");
          exit(1);
        }

        p->val=e;
        p->suc=NULL;
        l->suc=p;

        return tete;
      }

    Liste liste_queuesupprimer(Liste l){
      Liste ancienne_fin =l;


      if(liste_vide(l)){
        return l;
      }

      if(l->suc ==NULL){
        return l=liste_tetesupprimer(l);
      }
      while (l->suc->suc !=NULL){
        l =l->suc ;
      }
      free(l->suc);

      l->suc=NULL;
      return ancienne_fin;

    }

   int liste_rechercher(Liste l, int a, int *rang) {

    *rang=0;
    while ( l)
      if(l->val == a)
        return 1;
      else {
        l = l->suc;
        (*rang)++;
      }
      return 0;
    }

    void liste_destruction(Liste l){
        while(l)
        l = liste_tetesupprimer(l);
    }


    int main() {
      Liste l_test = NULL;
      int rang;
      l_test = liste_teteinserer(l_test,3);
      l_test = liste_teteinserer(l_test,4);
      l_test = liste_teteinserer(l_test,5);
      liste_afficher(l_test);
      printf("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx Ceci est une transition xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n\n");
      l_test = liste_queueinserer(l_test,2);
      liste_afficher(l_test);
      printf("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx Ceci est une transition xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n\n");
      l_test = liste_queueinserer(l_test,1);
      liste_afficher(l_test);
      printf("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx Ceci est une transition xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n\n");
      l_test = liste_queuesupprimer(l_test);
      liste_afficher(l_test);
      printf("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx Ceci est une transition xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n\n");
      l_test = liste_queuesupprimer(l_test);
      l_test = liste_queuesupprimer(l_test);
      liste_afficher(l_test);
      printf("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx Ceci est une transition xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n\n");
      liste_rechercher(l_test,4,&rang);
      printf("%d\n",rang );
      printf("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx Ceci est une transition xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n\n");
      liste_destruction(l_test);
      liste_afficher(l_test);



      return 1;
    }
