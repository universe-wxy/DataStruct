package Question10;

import java.io.*;
import java.util.Scanner;

public class Answer {
    public static void main(String[] args) throws Exception {
        InputStream stream=new FileInputStream("C:\\Users\\25372\\Desktop\\workspace\\数据结构\\experiment\\src\\Question10\\in.txt");
        Scanner reader=new Scanner(stream);
        Hash list = new Hash(100);
        for (int i = 0; i < 5; i++) {
            int row, col;
            float val;
            row = reader.nextInt();
            col = reader.nextInt();
            val = reader.nextFloat();
            list.add(row, col, val);
            System.out.print(list.index(val)+" ");
        }

    }
}
