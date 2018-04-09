#include <dirent.h>
#include <stdio.h>

int main()
{
    DIR* currdir;
    struct dirent* entree;
    currdir = opendir(".");

    while((entree=readdir(currdir))!= NULL)
    {
    printf("%s \n", entree->d_name);

    }

    closedir(currdir);

    return(0);
}
