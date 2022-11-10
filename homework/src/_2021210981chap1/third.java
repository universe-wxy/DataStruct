package _2021210981chap1;

import java.util.ArrayList;
import java.util.Scanner;

public class third {
    public static <E> void exchange(ArrayList<E> array1,ArrayList<E> array2){
        ArrayList<E> temp;
        temp= (ArrayList<E>) array1.clone();
        array1.clear();
        array1.addAll(array2);
        array2.clear();
        array2.addAll(temp);
    }

    public static void main(String[] args) {
        int n,m;
        ArrayList<Integer> array1 = new ArrayList<Integer>(),array2 = new ArrayList<Integer>();
        Scanner reader=new Scanner(System.in);
        n= reader.nextInt();
        m= reader.nextInt();
        for(int i=0;i<n;i++)
            array1.add(reader.nextInt());
        for(int i=0;i<m;i++)
            array2.add(reader.nextInt());
        exchange(array1,array2);
        System.out.println(array1.toString());
        System.out.println(array2.toString());
    }
}
