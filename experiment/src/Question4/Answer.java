package Final.Question4;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Answer {
    static int s;
    static Vector<Integer> w = new Vector<Integer>();

    public static void dfs(int V, Stack<Integer> ans) {
        if (V == s){
            for (Integer an : ans) System.out.print(w.get(an) + " ");
            System.out.println();
        }
        for(int i=ans.peek();i<w.size();i++){
            if(!ans.contains(i)){
                if(V+w.get(i)<=s) {
                    ans.push(i);
                    dfs(V + w.get(i), ans);
                    ans.pop();
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n;
        n = reader.nextInt();
        s = reader.nextInt();
        for (int i = 0; i < n; i++)
            w.add(reader.nextInt());
        for (int i = 0; i < n; i++) {
            Stack<Integer> temp= new Stack<Integer>();
            temp.push(i);
            dfs(w.get(i), temp);
        }
    }
}
