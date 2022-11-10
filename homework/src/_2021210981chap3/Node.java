package _2021210981chap3;

public class Node{

    Object data;
    Node next;

    Node(Object obj,Node nextval){
        data = obj;
        next = nextval;
    }

    Node(Node nextval){
        next = nextval;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node nextval){
        next = nextval;
    }

    public Object getElement(){
        return data;
    }

    public void setElement(Object obj){
        data = obj;
    }
    public String toString(){
        return data.toString();
    }
}