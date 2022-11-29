package _2021210981chap9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

public class First {
    static ArrayList<Integer> InsertSort(ArrayList<Integer> array) {
        ArrayList<Integer> outcome = new ArrayList<Integer>();
        outcome.add(array.get(0));
        long st = System.currentTimeMillis();
        for (int i = 1; i < array.size(); i++) {
            outcome.add(null);
            for (int j = outcome.size() - 2; j >= 0; j--) {
                if (outcome.get(j) < array.get(i)) {
                    outcome.set(j + 1, array.get(i));
                    break;
                } else if (j != 0)
                    outcome.set(j + 1, outcome.get(j));
                else {
                    outcome.set(j + 1, outcome.get(j));
                    outcome.set(0, array.get(i));
                }
            }
        }
        long ed = System.currentTimeMillis();
        System.out.println("插入排序所用时间为：" + (ed - st));
        return outcome;
    }

    static ArrayList<Integer> BubbleSort(ArrayList<Integer> array) {
        ArrayList<Integer> outcome=new ArrayList<>(array);
        long st = System.currentTimeMillis();
        for (int i = 0; i < outcome.size(); i++)
            for (int j = i; j < outcome.size(); j++) {
                if (outcome.get(i) > outcome.get(j)) {
                    int temp;
                    temp = outcome.get(i);
                    outcome.set(i, outcome.get(j));
                    outcome.set(j, temp);
                }
            }
        long ed = System.currentTimeMillis();
        System.out.printf("冒泡排序所用时间为: %d\n", (ed - st));
        return outcome;
    }

    static ArrayList<Integer> RadixSort(ArrayList<Integer> array) {
        boolean flag = true;
        int pos = 0;
        ArrayList<Integer> outcome = new ArrayList<Integer>();
        long st = System.currentTimeMillis();
        while (flag) {
            int cnt = 1;
            flag = false;
            for (int i = 0; i <= pos; i++)
                cnt *= 10;
            ArrayList<ArrayList<Integer>> storage = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i <= 10; i++)
                storage.add(new ArrayList<Integer>());
            outcome = new ArrayList<Integer>();
            for (Integer integer : array) {
                int left = integer % cnt / (cnt / 10);
                ArrayList<Integer> temp = storage.get(left);
                temp.add(integer);
                storage.remove(left);
                storage.add(left, temp);
                if (integer / cnt > 0)
                    flag = true;
            }
            for (int i = 0; i <= 10; i++)
                outcome.addAll(storage.get(i));
            pos += 1;
        }
        long ed = System.currentTimeMillis();
        System.out.printf("基数排序所用时间为: %d\n", (ed - st));
        return outcome;

    }

    static ArrayList<Integer> ShellSort(ArrayList<Integer> array) {
        long st = System.currentTimeMillis();
        for (int step = array.size(); step >= 1; step /= 2) {
            for (int i = step; i < array.size(); i++) {
                int temp = array.get(i);
                int j = i - step;
                while (j >= 0 && array.get(i) < array.get(j)) {
                    array.set(j + step, array.get(j));
                    j -= step;
                }
                array.set(j + step, temp);
            }
        }
        long ed = System.currentTimeMillis();
        System.out.printf("希尔排序所用时间为: %d\n", (ed - st));
        return array;
    }

    static void QuickSort(ArrayList<Integer> array,int begin,int end){
        if(begin>=end)
            return;
        int i=begin;
        int key=array.get(begin);
        int j=end;
        while(i<j){
            while(i<j&&array.get(j)>key){
                j--;
            }
            if(i<j){
                array.set(i, array.get(j));
                i++;
            }
            while(i<j&&array.get(i)<key){
                i++;
            }
            if(i<j){
                array.set(j,array.get(i));
                j--;
            }
            array.set(i,key);
            QuickSort(array,begin,i-1);
            QuickSort(array,i,end);
        }
    }
    static ArrayList<Integer> BinarySort(ArrayList<Integer> array) {
        ArrayList<Integer> storage = array;
        ArrayList<Integer> outcome = new ArrayList<Integer>();
        long st=System.currentTimeMillis();
        int len = array.size();
        for (int i = 0; i < len; i++)
            outcome.add(0);
        for (int space = 1; space < len; space*=2) {
            for (int start = 0; start < len-space; start += 2 * space) {
                int low = start, mid = Integer.min(start + space, len), high = Integer.min(start + 2 * space, len);
                int k = low;
                int st1 = low, ed1 = mid;
                int st2 = mid, ed2 = high;
                while (st1 < ed1 && st2 < ed2)
                    outcome.set(k++, storage.get(st1) < storage.get(st2) ? storage.get(st1++) : storage.get(st2++));
                while (st1 < ed1)
                    outcome.set(k++, storage.get(st1++));
                while (st2 < ed2)
                    outcome.set(k++, storage.get(st2++));
            }
            storage=new ArrayList<>(outcome);
        }
        long ed=System.currentTimeMillis();
        System.out.printf("归并排序所用时间为: %d\n", (ed - st));
        return outcome;
    }
//    static ArrayList<Integer> HeapSort(ArrayList<Integer> array){
//
//    }
    static ArrayList<Integer> ChoseSort(ArrayList<Integer> array){
        ArrayList<Integer> outcome = new ArrayList<>(array);
        long st=System.currentTimeMillis();
        for(int i=0;i<outcome.size()/2;i++) {
            int min= i;
            int max= outcome.size()-1-i;
            for (int j = i + 1; j < outcome.size()-1-i; j++) {
                if(outcome.get(j)< outcome.get(min))
                    min=j;
                else if(outcome.get(j)>outcome.get(max))
                    max=j;
            }
            int temp=outcome.get(outcome.size()-1-i);
            outcome.set(outcome.size()-1-i,outcome.get(max));
            outcome.set(max,temp);
            temp= outcome.get(i);
            outcome.set(i, outcome.get(min));
            outcome.set(min,temp);
        }
        long ed=System.currentTimeMillis();
        System.out.printf("选择排序所用时间为: %d\n", (ed - st));
        return outcome;
    }


    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>();
//        for(int i=0;i<100000;i++)
//            array.add(seed.nextInt());
        array = new ArrayList<>(Arrays.asList(5, 8, 3, 11, 7, 10, 2, 6));
        ArrayList<Integer> InsertSortArray = InsertSort(array);
        System.out.println(InsertSortArray.toString());

        ArrayList<Integer> BubbleSortArray = BubbleSort(array);
        System.out.println(BubbleSortArray.toString());

        ArrayList<Integer> ChoseSortArray=ChoseSort(array);
        System.out.println(ChoseSortArray.toString());

        ArrayList<Integer> BinarySortArray=BinarySort(array);
        System.out.println(BinarySortArray.toString());

        ArrayList<Integer> ShellSortArray=ShellSort(array);
        System.out.println(ShellSortArray.toString());

        ArrayList<Integer> RadixSortArray=RadixSort(array);
        System.out.println(RadixSortArray.toString());

        QuickSort(array,0, array.size()-1);
        System.out.println(array);
    }
}
