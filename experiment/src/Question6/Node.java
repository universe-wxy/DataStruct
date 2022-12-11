package Question6;

public class Node {
    Character ch;
    int w;
    Node left, right;

    Node() {
        this.ch = 'A';
        this.left = null;
        this.right = null;
        this.w = 0;
    }

    Node(Character ch, int w) {
        this.ch = ch;
        this.w = w;
        this.left = null;
        this.right = null;
    }

    Node(Character ch, int w, Node l, Node r) {
        this.ch = ch;
        this.w = w;
        this.left = l;
        this.right = r;
    }

}
