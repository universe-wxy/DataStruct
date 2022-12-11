package Question10;

import java.util.Scanner;

public class Answer {
    public static void main(String[] args) {
        Hash list = new Hash(100);
        Scanner reader = new Scanner(System.in);
        for (int i = 0; i < 100; i++) {
            int row, col;
            float val;
            row = reader.nextInt();
            col = reader.nextInt();
            val = reader.nextFloat();
            list.add(row, col, val);
        }
    }
}
