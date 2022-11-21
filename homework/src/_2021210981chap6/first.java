package _2021210981chap6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class first {
    //返回所找的数在给定数组中的下标（未找到返回-1）
    public static int binarySearch(int goal, int left, int right, ArrayList<Integer> arrayList) {
        int mid = (left + right) / 2;
        if (arrayList.get(mid) == goal)
            return mid;
        else if (arrayList.get(mid) < goal)
            binarySearch(goal, mid, right, arrayList);
        else
            binarySearch(goal, left, mid, arrayList);
        return -1;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n = reader.nextInt();
        int m = reader.nextInt();
        for (int i = 0; i < n; i++)
            arrayList.add(reader.nextInt());
        arrayList.sort(Comparator.naturalOrder());
        System.out.println(arrayList);
        System.out.println(binarySearch(m, 0, arrayList.size() - 1, arrayList) + 1);

    }
}
