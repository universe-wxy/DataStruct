package _2021210981chap1;

import java.util.ArrayList;
import java.util.Scanner;

public class first {
    public static <E> ArrayList<E> insert(ArrayList<E> array, int pos, E data){
        if(pos>array.size()) {
            System.out.println("ArrayIndexOutOfBoundsException");
            System.exit(0);
        }
        ArrayList<E> a=new ArrayList<E>();
        for(int i=0;i<array.size();i++){
            if(i==pos-1)
                a.add(data);
            a.add(array.get(i));
        }
        return a;
    }

    public static void main(String[] args) {
        ArrayList<Integer> array=new ArrayList<Integer>();
        int n,pos,data;
        Scanner reader=new Scanner(System.in);
        n=reader.nextInt();
        pos=reader.nextInt();
        data= reader.nextInt();
        for(int i=0;i<n;i++)
            array.add(reader.nextInt());
        System.out.println(insert(array,pos,data).toString());
    }
}
