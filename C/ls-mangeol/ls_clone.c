#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/stat.h>
#include <string.h>
#include <dirent.h>

void droit(char* nom, char rwx[10]){
    struct stat s;
    lstat(nom, &s);

        memset(rwx, 0, 10);
        if(S_ISREG(s.st_mode))
            rwx[0] = '-';
        else if(S_ISDIR(s.st_mode))
            rwx[0] = 'd';
        else if(S_ISLNK(s.st_mode))
            rwx[0] = 'l';

    if(s.st_mode & S_IRUSR) strcat(rwx, "r"); else strcat(rwx, "-");
    if(s.st_mode & S_IWUSR) strcat(rwx, "w"); else strcat(rwx, "-");
    if(s.st_mode & S_IXUSR) strcat(rwx, "x"); else strcat(rwx, "-");

    if(s.st_mode & S_IRGRP) strcat(rwx, "r"); else strcat(rwx, "-");
    if(s.st_mode & S_IWGRP) strcat(rwx, "w"); else strcat(rwx, "-");
    if(s.st_mode & S_IXGRP) strcat(rwx, "x"); else strcat(rwx, "-");

    if(s.st_mode & S_IROTH) strcat(rwx, "r"); else strcat(rwx, "-");
    if(s.st_mode & S_IWOTH) strcat(rwx, "w"); else strcat(rwx, "-");
    if(s.st_mode & S_IXOTH) strcat(rwx, "x"); else strcat(rwx, "-");
}

int main(int argc, char **argv){
    struct stat s;
    DIR* rep = NULL;
    struct dirent* fichierLu = NULL; /* Déclaration d'un pointeur vers la structure dirent. */
    rep = opendir(argv[1]);
    if(rep == NULL)
        exit(1);

    while((fichierLu = readdir(rep)) != NULL){
        lstat(fichierLu->d_name, &s);
        char rwx[10];
        droit(fichierLu->d_name, rwx);
        printf("%d %s %d %s \n", (int)s.st_ino, rwx, (int)s.st_nlink, fichierLu->d_name);
    }

    if (closedir(rep) == -1)
        exit(-1);

        return 0;
}
