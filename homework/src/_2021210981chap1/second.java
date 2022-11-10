package _2021210981chap1;

import java.util.ArrayList;
import java.util.Scanner;

public class second {
    public static <E> ArrayList<E> delete(ArrayList<E> array,int pos){
        ArrayList<E> a=new ArrayList<E>();
        for(int i=0;i<array.size();i++){
            if(i==pos-1)
                continue;
            a.add(array.get(i));
        }
        return a;
    }

    public static void main(String[] args) {
        int n,pos;
        ArrayList<Integer> array = new ArrayList<Integer>();
        Scanner reader=new Scanner(System.in);
        n=reader.nextInt();
        pos=reader.nextInt();
        for(int i=0;i<n;i++)
            array.add(reader.nextInt());
        delete(array,pos);
        System.out.println(delete(array,pos).toString());
    }
}
