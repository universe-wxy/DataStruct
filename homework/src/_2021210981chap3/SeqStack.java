package _2021210981chap3;

import java.util.ArrayList;

public class SeqStack <E>{
    final int defaultSize = 10;
    int top;
    ArrayList<E> stack;
    int maxStackSize;

    public SeqStack(){
        initiate(defaultSize);
    }

    public SeqStack(int sz){
        initiate(sz);
    }

    private void initiate(int sz){
        maxStackSize = sz;
        top = 0;
        stack = new ArrayList<E>();
    }

    public void push(E obj) throws Exception{
        if(top == maxStackSize){
            throw new Exception("堆栈已满！");
        }
        stack.add(obj);
        top ++;
    }

    public E pop() throws Exception{
        if(top == 0){
            throw new Exception("堆栈已空！");
        }
        top --;
        E val=stack.get(top);
        stack.remove(top);
        return val;
    }

    public E getTop() throws Exception{
        if(top == 0){
            throw new Exception("堆栈已空！");
        }
        return stack.get(top-1);
    }
    
}
