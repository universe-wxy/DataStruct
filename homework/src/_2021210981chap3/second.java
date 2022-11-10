package _2021210981chap3;

import java.util.ArrayList;
import java.util.Scanner;

public class second {
    public static ArrayList<Integer> radixSort(ArrayList<Integer> arrayList,int pos){
        int cnt=1;
        boolean flag=false;
        for(int i=0;i<=pos;i++)
            cnt*=10;
        ArrayList<ArrayList<Integer>> storage=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=10;i++)
            storage.add(new ArrayList<Integer>());
        ArrayList<Integer> outcome=new ArrayList<Integer>();
        for(int i=0;i<arrayList.size();i++){
            int left=arrayList.get(i)%cnt/(cnt/10);
            ArrayList<Integer> temp=storage.get(left);
            temp.add(arrayList.get(i));
            storage.remove(left);
            storage.add(left,temp);
            if(arrayList.get(i)/cnt>0)
                flag=true;
        }
        for(int i=0;i<=10;i++)
            for(int j=0;j<storage.get(i).size();j++)
                outcome.add(storage.get(i).get(j));
        if(flag)
            return radixSort(outcome,pos+1);
        else
            return outcome;
    }

    public static void main(String[] args) {
        Scanner reader=new Scanner(System.in);
        int n= reader.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<n;i++)
            list.add(reader.nextInt());
        ArrayList<Integer> outcome=radixSort(list,0);
        System.out.println(outcome);
    }
}
