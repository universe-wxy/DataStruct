package Question5;

import java.util.Scanner;
import java.util.Stack;

public class Maze {
    public static int[][] maze = new int[105][105];
    public static Stack<RecordType> s = new Stack<>();
    public static Stack<RecordType> l = new Stack<>();
    static int n, m, ans;

    public static void main(String[] args) {
        for (int i = 0; i < 105; i++)
            for (int j = 0; j < 105; j++)
                maze[i][j] = 0;
        Scanner reader = new Scanner(System.in);
        n = reader.nextInt();
        m = reader.nextInt();
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                maze[i][j] = reader.nextInt();
        s.push(new RecordType(1, 1, -1));
        ans = 0;
        int x, y;
        while (!s.empty()) {
            RecordType temp = s.pop();
            x = temp.x;
            y = temp.y;
            if (x == n && y == m) {
                ans++;
                System.out.println("path" + ans);
                for (RecordType recordType : l)
                    System.out.println(recordType.x + " " + recordType.y);
                System.out.println(x + " " + y);
                System.out.println();
                boolean flag = false;
                RecordType past = l.peek();
                while (past.num == 1) {
                    l.pop();
                    maze[past.x][past.y] = 1;
                    if (l.empty()) {
                        flag = true;
                        break;
                    }
                    past = l.peek();
                }
                if (!flag)
                    l.peek().num--;
                continue;
            }
            int cnt = 0;
            if (maze[x][y - 1] == 1) {
                s.push(new RecordType(x, y - 1, 3));
                cnt++;
            }
            if (maze[x - 1][y] == 1) {
                s.push(new RecordType(x - 1, y, 6));
                cnt++;
            }
            if (maze[x + 1][y] == 1) {
                s.push(new RecordType(x + 1, y, 1));
                cnt++;
            }
            if (maze[x][y + 1] == 1) {
                s.push(new RecordType(x, y + 1, 4));
                cnt++;
            }
            if (maze[x + 1][y - 1] == 1) {
                s.push(new RecordType(x + 1, y - 1, 0));
                cnt++;
            }
            if (maze[x + 1][y + 1] == 1) {
                s.push(new RecordType(x + 1, y + 1, 2));
                cnt++;
            }

            if (maze[x - 1][y - 1] == 1) {
                s.push(new RecordType(x - 1, y - 1, 5));
                cnt++;
            }

            if (maze[x - 1][y + 1] == 1) {
                s.push(new RecordType(x - 1, y + 1, 7));
                cnt++;
            }
            if (cnt == 0) {
                boolean flag = false;
                RecordType past = l.peek();
                while (past.num == 1) {
                    l.pop();
                    maze[past.x][past.y] = 1;
                    if (l.empty()) {
                        flag = true;
                        break;
                    }
                    past = l.peek();
                }
                if (!flag)
                    l.peek().num--;
                continue;
            }
            l.push(new RecordType(x, y, cnt));
            maze[x][y] = 0;
        }
        if(ans==0)
            System.out.println("THERE IS NO PATH IN MAZE.");
    }
}