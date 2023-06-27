import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Pair;

public class TSP {

    private static final int N = 25;
    private static final int VISITED_ALL = (1 << N) - 1;

    private static double tsp(double[][] dist, int mask, int s) {
        if (mask == VISITED_ALL) {
            return dist[s][0];
        }
        double ans = Double.POSITIVE_INFINITY;
        for (int city = 0; city < N; city++) {
            if ((mask & (1 << city)) == 0) {
                double newAns = dist[s][city] + tsp(dist, mask | (1 << city), city);
                ans = Math.min(ans, newAns);
            }
        }
        return ans;
    }

    public static void main(String[] args) throws FileNotFoundException {
        double[][] dist = new double[N][N];
        for (int i = 0; i < N; i++) {
            dist[i][i] = 0.0;
        }
        int cities = 0;
        Scanner scanner = new Scanner(new File("tsp.txt"));
        scanner.nextLine().split(" ");
        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(" ");
            double x = Double.parseDouble(parts[0]);
            double y = Double.parseDouble(parts[1]);
            Pair<Double, Double> point = new Pair<>(x, y);
            for (int i = 0; i < N; i++) {
                Pair<Double, Double> otherPoint = new Pair<>(dist[i][0], dist[i][1]);
                double d = pointDistance(point, otherPoint);
                dist[i][cities] = d;
                dist[cities][i] = d;
            }
            cities++;
        }
        scanner.close();
        System.out.println(tsp(dist, 1, 0));
    }

    private static double pointDistance(Pair<Double, Double> a, Pair<Double, Double> b) {
        double dx = a.getKey() - b.getKey();
        double dy = a.getValue() - b.getValue();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
