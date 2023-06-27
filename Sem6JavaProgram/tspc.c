#include <stdio.h>
#include <math.h>
#include <limits.h>

#define n 25

int VISITED_ALL = (1 << n) - 1;

double tsp(double dist[n][n], int mask, int s) {
    if (mask == VISITED_ALL) {
        return dist[s][0];
    }
    double ans = INT_MAX;

    for (int city = 0; city < n; city++) {
        if((mask&(1<<city))==0) {
            double newAns = dist[s][city] + tsp(dist, mask|(1<<city), city);
            ans = fmin(ans, newAns);
        }
    }
    return ans;
}

int main() {
    double dist[n][n];
    for (int i = 0; i < n; i++) {
        dist[i][i] = 0.0;
    }
    int cities;
    FILE *file = fopen("tsp.txt", "r");
    fscanf(file, "%d", &cities);
    double x, y;
    for (int i = 0; i < cities; i++) {
        fscanf(file, "%lf %lf", &x, &y);
        for (int j = 0; j < cities; j++) {
            double d = sqrt((y - v[j].second) * (y - v[j].second) + (x - v[j].first) * (x - v[j].first));
            dist[i][j] = d;
            dist[j][i] = d;
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("%f ", dist[i][j]);
        }
        printf("\n");
    }
    printf("%f\n", tsp(dist, 1, 0));
    fclose(file);
    return 0;
}
