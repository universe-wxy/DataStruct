package Question7;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Answer {
    public static void main(String[] args) {
        int n, m;
        final int INF = 0x3f3f3f;
        int[][] dis = new int[105][105];
        int[] maxdis = new int[105];
        for (int i = 0; i < 105; i++)
            for (int j = 0; j < 105; j++)
                dis[i][j] = (i != j ? INF : 0);
        Scanner reader = new Scanner(System.in);
        n = reader.nextInt();
        m = reader.nextInt();
        for (int i = 0; i < m; i++) {
            int u, v, w;
            u = reader.nextInt();
            v = reader.nextInt();
            w = reader.nextInt();
            dis[u][v] = w;
            dis[v][u] = w;
        }
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    if(i==k||j==k||i==j)
                        continue;
                    if (dis[i][k] + dis[k][j] < dis[i][j]) {
                        dis[i][j] = dis[i][k] + dis[k][j];
                        dis[j][i] = dis[i][k] + dis[k][j];
                    }
                }
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                if(dis[i][j]>maxdis[i])
                    maxdis[i]=dis[i][j];
            }
        int ans=1;
        for(int i=0;i<n;i++)
            if(maxdis[i]<maxdis[ans])
                ans=i;
        System.out.println("应该建在第"+ans+"个小区");
    }
}
