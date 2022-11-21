package _2021210981chap7;

import java.util.Stack;
import java.util.Vector;

public class Second {
    static Stack<Node> tra = new Stack<Node>();
    static BiTree tree;
    static Stack<Character> output = new Stack<>();

    static void MakeTree() {
        BiTree h = new BiTree('h');
        BiTree l = new BiTree('l');
        BiTree k = new BiTree('k');
        BiTree g = new BiTree('g', l, h);
        BiTree c = new BiTree('c', g, k);
        BiTree f = new BiTree('f');
        BiTree e = new BiTree('e', null, f);
        BiTree a = new BiTree('a', c, e);
        tree = a;
    }

    static void InOrderTraverse() {
        Node last = null;
        tra.push(tree.root);
        while (!tra.empty()) {
            while (tra.peek().left != null && tra.peek().left != last) {
                tra.push(tra.peek().left);
                last = tra.peek();
            }
            Node temp = tra.pop();
            output.push((Character) temp.data);
            if (temp.right != null) {
                tra.push(temp.right);
                last = temp;
            }
        }
    }

    public static void main(String[] args) {
        MakeTree();
        InOrderTraverse();
        System.out.println(output.toString());
    }
}
