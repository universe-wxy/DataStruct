package Question10;

public class Hash {
    int m;
    DataType[] H=new DataType[130];
    Hash(int m){
        this.m=m;
        for(int i=0;i<130;i++)
            H[i]=null;
    }
    void add(int row,int col,float val){
        int pos=(13*row+17*col)%m;
        while(H[pos]!=null)
            pos=(pos+1)%m;
        H[pos]=new DataType(row,col,val);
    }
}
