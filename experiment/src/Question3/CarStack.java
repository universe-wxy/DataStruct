package Question3;

public class CarStack {
    private Car[] Carstack;//对象数组
    private int top;//在非空栈中，top始终指向栈顶元素的下一个存储位置栈
    private int MAXSIZE;
    //栈的构造函数，构造一个存储空间为MAXSIZE的空
    public CarStack(int MAXSIZE)
    {
        this.MAXSIZE=MAXSIZE;
        top=0;
        Carstack = new Car[MAXSIZE];
    }
    //栈置空
    public void clear()
    {
        top=0;
    }
    //判空
    public boolean isEmpty()
    {
        return top==0;
    }
    //判满
    public boolean isFull()
    {
        return top==MAXSIZE;
    }
    //求栈中元素的个数
    public int length()
    {
        return top;
    }
    //取栈顶元素
    public Object peek()
    {
        if(!isEmpty())
            return Carstack[top-1];
        else
            return null;
    }
    //车辆进栈
    public boolean push(Car car)
    {
        if(top >= MAXSIZE)
            return false;//车子没有成功停进停车场，返回false
        else
            Carstack[top++] = car;
        return true;//车子成功停进停车场，返回true
    }
    //车辆出栈
    public Car pop()
    {
        if(isEmpty())
            return null;
        else
            return Carstack[--top];
    }
    //输出栈中的所有元素
    public void display()
    {
        if(isEmpty())
        {
            System.out.println("停车场暂时没有车！");
        }
        else
        {
            for(int i=top-1;i>=0;i--)
                System.out.println(Carstack[i].toString()+"  ");
        }
    }
}
