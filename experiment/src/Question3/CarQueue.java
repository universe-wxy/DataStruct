package Question3;

public class CarQueue {

    //设计链队数据结构及其基本操作
    private CarNode front;//队首指针
    private CarNode rear;//队尾指针

    //链队列类的构造函数
    public CarQueue() {
        front = rear = null;
    }

    //队列置空
    public void clear() {
        front = rear = null;
    }

    //车辆队列判空
    public boolean isEmpty() {
        return front == null;
    }

    //求队列长度
    public int length() {
        CarNode p = front;
        int length = 0;
        while (p != null) {
            p = p.next;//指针下移
            ++length;//计数器+1
        }
        return length;
    }

    //取出队首元素
    public Object peek() {
        if (front != null)//队列非空
            return front.car;//返回队首结点的数据域值
        else
            return null;
    }

    //车辆入队
    public boolean offer(Car car) {
        CarNode p = new CarNode(car);//初始化新结点
        if (front != null)//队列非空
        {
            rear.next = p;
            rear = p;//改变队尾位置
        } else {
            front = rear = p;
        }
        return true;
    }

    //车辆出队
    public Object poll() {
        if (front != null)//队列非空
        {
            CarNode p = front;//p指向队首结点
            front = front.next;//队首结点出列
            if (p == rear)//被删除的结点是队尾结点时
                rear = null;
            return p.car;//返回队首结点的数据域值
        } else
            return null;
    }

    //输出队列中的所有数据元素(从头到尾)
    public void display() {
        CarNode p = front;
        while (p != null) {
            System.out.println(p.car + ",");
            p = p.next;
        }
    }
}