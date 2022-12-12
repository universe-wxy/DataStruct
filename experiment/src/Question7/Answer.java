package Question7;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Answer {
    public static void main(String[] args) {
        int n, m;
        final int INF = 0x3f3f3f;
        int[][] dis = new int[105][105];
        int[] maxdis=new int[105];
        Arrays.fill(dis, INF);
        Scanner reader = new Scanner(System.in);
        n = reader.nextInt();
        m = reader.nextInt();
        for (int i = 0; i < m; i++) {
            int u, v, w;
            u = reader.nextInt();
            v = reader.nextInt();
            w = reader.nextInt();
            dis[u][v] = w;
            dis[u][v] = w;
        }
        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++) {
                    if (dis[i][k] + dis[k][j] < dis[i][j]) {
                        dis[i][j] = dis[i][k] + dis[k][j];
                        dis[j][i] = dis[i][k] + dis[k][j];
                    }
                }
        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++){
                if(dis[i][j]>maxdis[i])
                    maxdis[i]=dis[i][j];
            }
        int ans=1;
        for(int i=1;i<=n;i++)
            if(maxdis[i]<maxdis[ans])
                ans=i;
        System.out.println("应该建在第"+ans+"个小区");
    }
}
