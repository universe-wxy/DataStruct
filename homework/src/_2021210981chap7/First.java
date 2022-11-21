package _2021210981chap7;

public class First {
    static BiTree tree;
    static public int count(Node node){
        if(node==null)
            return 0;
        if(node.left==null&&node.right==null)
            return 1;
        else
            return count(node.left)+count(node.right);
    }

    static void maketree() {
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

    public static void main(String[] args) {
        maketree();
        int cnt=count(tree.root);
        System.out.println(cnt);
    }
}
