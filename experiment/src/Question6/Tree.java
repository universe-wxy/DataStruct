package Question6;


public class Tree {
    public Node root;

    Tree() {
        root = null;
    }

    Tree(int data, Tree left, Tree right) {
        Node l, r;
        if (left == null)
            l = null;
        else
            l = left.root;
        if (right == null)
            r = null;
        else
            r = right.root;
        root = new Node(null,data, l, r);
    }
    Tree(int data,Node l,Tree r){
        root=new Node(null,data,l,r.root);
    }
    Tree(int data) {
        root = new Node(null,data);
    }

}