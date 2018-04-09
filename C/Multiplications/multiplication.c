#include <stdio.h>
#include <unistd.h>
#include <signal.h>
#include <time.h>
#include <string.h>
#include <stdlib.h>

  int score=0;

  void sortie(){
    printf("Jeu terminé ! \n");
    printf("Vous marquez %d points\n",score );
    exit(0);
  }


  int main(){
    srand(time(NULL));
    while(1){
      int a= (rand()%9)+1;
      int b= (rand()%9)+1;
      int reponse;
      signal(SIGALRM,sortie);
      signal(SIGINT,sortie);
      printf("Combien font %d * %d ?\n",a,b );
      alarm(5);

      scanf("%d", &reponse);
      if(reponse == a*b){
        score++;
        printf("Bien ouej ! \n");
      }else
        printf("Non, %dx%d fait %d ...\n",a,b,a*b);
    }
    return 0;
  }
