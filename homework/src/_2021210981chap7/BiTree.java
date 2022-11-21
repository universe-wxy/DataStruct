package _2021210981chap7;

public class BiTree {
    public Node root;

    BiTree() {
        root = null;
    }

    BiTree(Object data, BiTree left, BiTree right) {
        Node l, r;
        if (left == null)
            l = null;
        else
            l = left.root;
        if (right == null)
            r = null;
        else
            r = right.root;
        root = new Node(data, l, r);
    }

    BiTree(Object data) {
        root = new Node(data);
    }

}
