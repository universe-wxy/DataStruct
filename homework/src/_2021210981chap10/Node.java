package _2021210981chap10;

public class Node {
    Object data;
    Node left,right;
    Node(){
        data=null;
        left=null;
        right=null;
    }
    Node(Object data,Node left,Node right){
        this.data=data;
        this.left=left;
        this.right=right;
    }

    Node(Object data){
        this.data=data;
    }


}
