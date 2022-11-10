package _2021210981chap2;

import java.util.Scanner;

public class second {
    public static class SeqList implements List {
        final int defaultSize = 10;

        int maxSize;
        int size;
        Object[] listArray;

        public SeqList(){
            initiate(defaultSize);
        }

        public SeqList(int size){
            initiate(size);
        }

        private void initiate(int sz){
            maxSize = sz;
            size = 0;
            listArray = new Object[sz];
        }

        public void insert(int i,Object obj) throws Exception{
            if (size == maxSize){
                throw new Exception("顺序表已满无法插入！");
            }
            if (i < 0 || i > size){
                throw new Exception("参数错误！");
            }

            for(int j = size; j > i; j--){
                listArray[j] = listArray[j-1];
            }

            listArray[i] = obj;
            size++;
        }

        public Object delete(int i) throws Exception{
            if(size == 0){
                throw new Exception("顺序表已空无法删除！");
            }
            if (i < 0 || i > size-1){
                throw new Exception("参数错误！");
            }
            Object it = listArray[i];
            for(int j = i; j < size-1; j++){
                listArray[j] = listArray[j+1];
            }

            size--;
            return it;
        }

        public Object getData(int i) throws Exception{
            if(i < 0 || i >= size){
                throw new Exception("参数错误！");
            }
            return listArray[i];
        }

        public int size(){
            return size;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public void add(Object data) throws Exception{
            if(size==maxSize)
                throw new Exception("顺序表已满，无法添加");
            listArray[size++]=data;
        }

        public int MoreDataDelete(SeqList L, Object x) throws Exception{

            int tag = 0;

            for(int i = 0; i < L.size; i++){
                if(x.equals(L.getData(i))){
                    L.delete(i);
                    i --;
                    tag = 1;
                }
            }

            return tag;
        }

        public SeqList reverse() throws Exception {
            SeqList goal = new SeqList();
            for(int i=this.size-1;i>=0;i--)
                goal.add(this.getData(i));
            return goal;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner reader=new Scanner(System.in);
        int n= reader.nextInt();
        SeqList L=new SeqList(n);
        for(int i=0;i<n;i++)
            L.add(reader.nextInt());
        SeqList outcome=L.reverse();
        for(int i=0;i< outcome.size;i++)
            System.out.print(outcome.getData(i)+" ");
    }
}
