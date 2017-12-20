#include <stdio.h>


#define Z 8
#define S 8

int m[Z][S];

void pini(int m[Z][S]) {

	for (int a = 0; a < Z; a++)
		for (int b = 0; b < S; b++)
			m[a][b] = 0;

	
}

void mprint(int m[Z][S]) {
	
	for (int x = 0; x < 8; x++) {
	

		for (int y = 0; y < 8; y++) {
			if(m[x][y]<10)
				printf("0");
				printf("%d ", m[x][y]);
		}
		
		printf("\n");
	}

}

int isonboard(int nextx, int nexty,int m[S][Z]) {

	if (nextx >= 0 && nextx < S && nexty >= 0 && nexty < Z && m[nextx][nexty] == 0)
		return 1;
	else
		return 0;

}

int solveH(int x, int y, int num) {

	int xjump[] = { 2,1,-1,-2,-2,-1,1,2 };
	int yjump[] = { 1,2,2,1,-1,-2,-2,-1 };

	int nextJ_x, nextJ_y;
	m[x][y] = num;
	if (num == S * Z ) {
		mprint(m);
		return 1;
	}
	

	for (int k = 0; k < 8; k++) {

		nextJ_x = x + xjump[k];
		nextJ_y = y + yjump[k];
		if (isonboard(nextJ_x, nextJ_y, m)) {
			if (solveH(nextJ_x, nextJ_y, num + 1))
				return 1;
		}
	}
	m[x][y] = 0;
	return 0;

}



int main() {
	
    int x=0,y=0;
    
	pini(m);
	
	scanf(" %d %d", &x , &y);
	m[x][y] = 1;
	mprint(m);
	printf("\n");
	solveH(x,y,1);


	getch();
	return 0;
}
