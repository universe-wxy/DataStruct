package Question10;

import java.util.ArrayList;

public class Hash {
    int m;
    DataType[] H=new DataType[130];
    ArrayList<Integer> list;
    Hash(int m){
        this.m=m;
        for(int i=0;i<130;i++)
            H[i]=null;
        list=new ArrayList<>();
    }
    void add(int row,int col,float val){
        int pos=(13*row+17*col)%m;
        while(H[pos]!=null)
            pos=(pos+1)%m;
        H[pos]=new DataType(row,col,val);
        list.add(pos);
    }
    int index(float val){
        for (Integer integer : list) {
            if (H[integer].val == val)
                return integer;
        }
        return -1;
    }
}
