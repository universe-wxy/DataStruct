package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Test {
    public static void main(String[] args) {
        int [] array=new int[]{1,3,4,5,6,11};
        ArrayList<Integer> a=new ArrayList<Integer>();
        ArrayList<Integer> b=new ArrayList<Integer>();
        a=new ArrayList<>(Arrays.asList(1,3,4,5,6,11));
        b=a;
        b.set(3,700);
        System.out.println(a.toString());
    }
}
