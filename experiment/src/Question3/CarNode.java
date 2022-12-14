package Question3;

public class CarNode {
    public Car car;// 汽车
    public CarNode next;// 下一个节点
    public CarNode()
    {
        this(null,null);
    }
    public CarNode(Car car)
    {
        this(car,null);
    }
    public CarNode(Car car,CarNode next)
    {
        this.car=car;
        this.next=next;
    }
}
