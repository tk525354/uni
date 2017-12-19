#include <stdio.h>


#define Z 8
#define S 8


void pini(int m[Z][S]) {

	for (int a = 0; a < Z; a++)
		for (int b = 0; b < S; b++)
			m[a][b] = 0;

	
}

void mprint(int m[Z][S]) {
	
	for (int x = 0; x < 8; x++) {
		printf("\n");

		for (int y = 0; y < 8; y++) 
			printf(" [%d] ", m[x][y]);

	}

}

int isonboard(int nextx, int nexty,int m[S][Z]) {

	if (nextx >= 0 && nextx < S && nexty >= 0 && nexty < Z && m[nextx][nexty] == 0)
		return 1;
	else
		return 0;

}

int solveH(int x, int y, int m[Z][S],int maxmove) {

	int xjump[8] = { 2,1,-1,-2,-2,-1,1,2 };
	int yjump[8] = { 1,2,2,1,-1,-2,-2,-1 };

	int nextJ_x, nextJ_y;

	if (maxmove == S * Z -1) {
		mprint(m);
		return 1;
	}
	for (int k = 0; k < 8; k++) {

		nextJ_x = x + xjump[k];
		nextJ_y = y + yjump[k];
		if (isonboard(nextJ_x, nextJ_y, m) == 1) {
			m[nextJ_x][nextJ_y] = 1;

			if (solveH(nextJ_x, nextJ_y, m, maxmove + 1) == 1)
				return 1;
			else
				m[nextJ_x][nextJ_y] = 0;
		}
	}

	return 0;

}

int jump(int x , int y , int num) {

	int start[Z][S];

	int sx = 7, sy = 0;
	int xjump[8] = { 2,1,-1,-2,-2,-1,1,2 };
	int yjump[8] = { 1,2,2,1,-1,-2,-2,-1 };

	int nextJ_x, nextJ_y;
	
	printf("\n start %d", start[sx][sy]);

	if (start[sx][sy] != 1) {
		for (int a = 0; a < Z; a++)
			for (int b = 0; b < S; b++) 
				start[a][b] = 0;
			
		start[sx][sy] = 1;
	}



	if (start[x][y] != 1) {


		for (int k = 0; k < 8; k++) {
			nextJ_x = sx + xjump[k];
			nextJ_y = sy + yjump[k];

			if (isonboard(nextJ_x, nextJ_y, start) == 1) {
				start[nextJ_x][nextJ_y] = 1;

				if (jump(nextJ_x, nextJ_y, num - 1) == 1)
					return 1;
				else
					start[nextJ_x][nextJ_y] = 0;

			}


		}

	}
	printf("\n nummer: %d \n", num);
	mprint(start);
	return 0;

}


int main() {

	int chess[Z][S];
	int i = 0;

	pini(chess);
	jump(6, 2, 1);


	
	scanf_s("%d", &i);
	return 0;
}