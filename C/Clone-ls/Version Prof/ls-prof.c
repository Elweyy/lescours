#include <dirent.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[])
{
    int i=0;
    int compt=0;
    char tab[100][200];

    DIR *rep;
    struct dirent* entree;

    /*On ouvre le répertoire souhaité*/
    if(argc == 2)
        rep = opendir(argv[1]);
    else
        rep = opendir(".");

    /*Vérification de l'ouverture*/

    if( rep == NULL) {
        printf("Impossible d'ouvrir le répertoire\n");
        exit(1);
    }

    /*Parcours du répertoire ouvert */

    while((entree=readdir(rep))!= NULL)
    {
    printf("%s \n", entree->d_name);
    strcpy(entree->d_name,tab[compt]);
    compt++;

    }

    qsort(tab,sizeof(20),compt,strcmp);

    for(;i<compt;i++){
        printf("%s\n",tab[i]);
    }

    closedir(rep);
    return 0;
}
