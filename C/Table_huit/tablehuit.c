#include <stdio.h>

int main()
 {
	int j;
	int i =1;
	for (i; i<11;i++){
	j+=8;
	printf("%d\n", j);

	}


// Idem mais plus mieux
  i=0;
  for (;i<11;i++){
    printf("%5.2d x 8 = %d\n",i,i*8);
  }
	return 0;
}
