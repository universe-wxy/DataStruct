package _2021210981chap7;

public class Node {
    Object data;
    Node left,right,father;
    public void setFather(Node _father){
        father=_father;
    }
    Node(){
        data=null;
        left=null;
        right=null;
    }
    Node(Object _data,Node _left,Node _right){
        data=_data;
        left=_left;
        right=_right;
        _left.setFather(this);
        _right.setFather(this);
    }

}
