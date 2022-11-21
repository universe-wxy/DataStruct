package _2021210981chap8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class First {
    final static int MAXN = 10005;
    static int[] to = new int[MAXN], next = new int[MAXN], w = new int[MAXN];
    static int[] head = new int[MAXN];
    static int cnt=0;
    static int n, m;
    static boolean[] vis=new boolean[MAXN];
    static int total=0;

    static void add(int u, int v, int weight) {
        to[++cnt] = v;
        w[cnt] = weight;
        next[cnt] = head[u];
        head[u] = cnt;
    }

    static void Prim(){
        int times=0;
        int now=1;
        ArrayList<Integer> dis=new ArrayList<Integer>();
        for(int i=0;i<cnt;i++)
            dis.add(MAXN);
        for(int i=head[now];i!=0;i=next[i])
            dis.set(to[i],Integer.min(dis.get(to[i]),w[i]));
        while(times++<(n-1)){
            int minn=MAXN;
            vis[now]=true;
            for(int i=1;i<=n;i++){
                if(!vis[i]&&minn>dis.get(i)){
                    minn=dis.get(i);
                    now=i;
                }
            }
            total+=minn;
            assert minn!=MAXN;
            for(int i=head[now];i!=0;i=next[i]){
                if(!vis[to[i]]&&dis.get(to[i])>w[i])
                    dis.set(to[i],w[i]);
            }
        }
    }


    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        n = reader.nextInt();
        m = reader.nextInt();
        for (int i = 0; i < m; i++) {
            int u, v, w;
            u = reader.nextInt();
            v = reader.nextInt();
            w = reader.nextInt();
            add(u,v,w);
        }
        Prim();
        System.out.println(total);
    }
}
