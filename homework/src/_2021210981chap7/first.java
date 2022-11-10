package _2021210981chap7;

import java.util.Scanner;

public class first {
    public int count(Node node){
        if(node==null)
            return 1;
        else
            return count(node.left)+count(node.right);
    }

    public static void main(String[] args) {
        Scanner reader=new Scanner(System.in);
        int n= reader.nextInt();

    }
}
