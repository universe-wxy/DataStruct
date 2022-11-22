package _2021210981chap8;

import java.util.Scanner;

public class Second {
    static final int MAXN=10005;
    static int[] father=new int[MAXN];
    static int n,m,ans=0;
    static int[] u=new int[MAXN],v=new int[MAXN],w=new int[MAXN];
    static int Find(int a){
        return father[a]==a?a:Find(father[a]);
    }
    static void ReSort(){
        for(int i=1;i<m;i++){
            int keyw=w[i],keyu=u[i],keyv=v[i];
            int j=i-1;
            while((j>=0)&&(w[j]>keyw)){
                w[j+1]=w[j];
                u[j+1]=u[j];
                v[j+1]=v[j];
                j--;
            }
            w[j+1]=keyw;
            u[j+1]=keyu;
            v[i+1]=keyv;
        }
    }
    static void Kruskal(){
        int cnt=0;
        ReSort();
        for(int i=0;i<m;i++){
            if(Find(u[i])==Find(v[i]))
                continue;
            ans+=w[i];
            father[v[i]]=u[i];
            cnt++;
            if(cnt==n-1)
                break;
        }
    }

    public static void main(String[] args) {
        Scanner reader=new Scanner(System.in);
        n= reader.nextInt();
        m= reader.nextInt();
        for(int i=1;i<=n;i++)
            father[i]=i;
        for(int i=0;i<m;i++){
            u[i]= reader.nextInt();
            v[i]= reader.nextInt();
            w[i]= reader.nextInt();
        }
        Kruskal();
        System.out.println(ans);
    }

}
