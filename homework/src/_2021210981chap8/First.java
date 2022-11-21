package _2021210981chap8;

import java.util.ArrayList;
import java.util.Scanner;

public class First {
    final static int MAXN = 10005;
    static int[] to = new int[MAXN], next = new int[MAXN], w = new int[MAXN];
    static int[] head = new int[MAXN];
    static int cnt;

    static void add(int u, int v, int weight) {
        to[++cnt] = v;
        w[cnt] = weight;
        next[cnt] = head[u];
        head[u] = cnt;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n, m;
        n = reader.nextInt();
        m = reader.nextInt();
        for (int i = 0; i < m; i++) {
            int u, v, w;
            u = reader.nextInt();
            v = reader.nextInt();
            w = reader.nextInt();
        }
    }
}
