package Final.Question2;

import java.util.ArrayList;

public class myVector{
    int size;     //用来指明队列的长度
    int length=0;
    int front=0,tail=0;     //用来指明队列的首和尾
    int[] list;     //用于存储数据
    myVector(int sz){
        size=sz;
        list=new int[sz];
    }

    //用来向队尾中添加数据
    public void append(int data) throws Exception {
        if(length==size)
            throw new Exception("队列已满，无法添加元素");
        list[tail++]=data;
        if(tail==size)
            tail=0;
        length++;
    }

    //用来从队首提取数据
    public int pop() throws Exception {
        if(length==0)
            throw new Exception("队列已空，无法去除元素");
        int outcome=list[front++];
        if(front==size)
            front=0;
        length--;
        return outcome;
    }

    //用来取得队首元素
    public int getFront() {
        return list[front];
    }

}
