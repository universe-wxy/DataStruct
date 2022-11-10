package _2021210981chap2;

import java.util.Scanner;

public class fourth {
    public static class LinList implements List {
        Node head;
        Node current;
        int size;

        LinList(){
            head = current = new Node(null);
        }

        public void index(int i) throws Exception{
            if(i < -1 || i > size - 1){
                throw new Exception("参数错误！");
            }
            if(i == -1){current=head; return;}
            current = head.next;
            int j = 0;
            while((current != null) && j < i){
                current=current.next;
                j ++;
            }
        }

        public void insert(int i,Object obj) throws Exception{
            if(i < 0 || i > size){
                throw new Exception("参数错误！");
            }
            index(i - 1);
            current.setNext(new Node(obj,current.next));
            size ++;
        }

        public Object delete(int i) throws Exception{
            if(size == 0){
                throw new Exception("链表已空无元素可删！");
            }
            if(i < 0 || i > size - 1){
                throw new Exception("参数错误！");
            }

            index(i - 1);
            Object obj = current.next.getElement();
            current.setNext(current.next.next);
            size --;
            return obj;
        }

        public int size(){
            return size;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public Object getData(int i) throws Exception{
            if(i < -1 || i > size - 1){
                throw new Exception("参数错误！");
            }
            index(i);
            return current.getElement();
        }
        public LinList reverse2() throws Exception {
            LinList temp=new LinList();
            for(int i=this.size;i>0;i--)
                temp.insert(this.size-i,this.getData(i-1));
            return temp;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner reader=new Scanner(System.in);
        LinList list=new LinList();
        int n=reader.nextInt();
        for(int i=0;i<n;i++)
            list.insert(list.size, reader.nextInt());
        LinList outcome=list.reverse2();
        for(int i=0;i< outcome.size;i++)
            System.out.print(outcome.getData(i)+" ");
    }
}
