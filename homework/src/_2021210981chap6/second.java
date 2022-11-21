package _2021210981chap6;

import java.util.*;

public class second {
    static boolean b[] = new boolean[1005];//列asd
    static boolean c[] = new boolean[1005];//主对角线
    static boolean d[] = new boolean[1005];//反对角线
    static Stack<Integer> stack = new Stack<Integer>();
    static int n, cnt = 0;

    public static void DFS(int a) {
        if (a == n) {
            cnt++;
            System.out.println(stack);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!b[i] && !c[a - i + n] && !d[a + i]) {
                stack.push(i);
                b[i] = true;
                c[a - i + n] = true;
                d[a + i] = true;
                DFS(a + 1);
                stack.pop();
                b[i] = false;
                c[a - i + n] = false;
                d[a + i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        n = reader.nextInt();
        DFS(0);
        System.out.println(cnt);
    }
}
