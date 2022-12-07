package Question1;

import java.util.Scanner;


public class first {
    public static void main(String[] args) throws Exception {
        SingleList list=new SingleList();
        Scanner reader=new Scanner(System.in);
        int n= reader.nextInt();
        int m= reader.nextInt();
        for(int i=1;i<=n;i++)
            list.insert(i-1,i);
        for(Node temp=list.head;list.size>1;) {
            for(int i=0;i<m;i++){
                temp=temp.next;
                if(temp==list.head)
                    temp=temp.next;
            }
            System.out.println(temp.data+" "+temp.next.data);
            list.delete(temp);
        }
        System.out.println(list.getData(0));
    }
}

