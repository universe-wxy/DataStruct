package _2021210981chap2;

public class Node{
    Object data;						//数据元素
    Node next;							//表示下一个结点的对象引用

    Node(Node nextval){					//用于头结点的构造函数1
        next = nextval;
    }

    Node(Object obj,Node nextval){ 		//用于其他结点的构造函数2
        data = obj;
        next = nextval;
    }

    public Node getNext(){							//取next
        return next;
    }

    public void setNext(Node nextval){				//置next
        next = nextval;
    }

    public Object getElement(){						//取data
        return data;
    }

    public void setElement(Object obj){ 			//置data
        data = obj;
    }

    public String toString(){				//转换data为String类型
        return data.toString();
    }
}
