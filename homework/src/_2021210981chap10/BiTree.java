package _2021210981chap10;

import java.util.Vector;


class BiSearchTree{
    private BiTreeNode root;
    Vector vector = new Vector();

    public BiSearchTree(){
        root = null;
    }

    public void setRoot(BiTreeNode t){
        root = t;
    }

    public BiTreeNode getRoot(){
        return root;
    }

    public BiTreeNode getLeft(BiTreeNode current){
        return current != null ? current.getLeft() : null;
    }

    public BiTreeNode getRight(BiTreeNode current){
        return current != null ? current.getRight() : null;
    }

    public BiTreeNode find(int item){
        if(root != null){
            BiTreeNode temp = root;
            while(temp != null){
                if(temp.getData() == item) return temp;//查找成功

                if(temp.getData() < item)
                    temp = temp.getRight();			//在右子树继续
                else
                    temp = temp.getLeft();			//在左子树继续
            }
        }
        return null;									//查找失败
    }

    public void insert(BiTreeNode ptr, int item){
        if(item < ptr.getData()){
            if(ptr.getLeft() == null){
                BiTreeNode temp = new BiTreeNode(item);	//生成新结点
                temp.setParent(ptr);	//把ptr结点设为temp结点的父结点
                ptr.setLeftChild(temp);	//把temp结点设为ptr结点的左孩子结点
            }
            else insert(ptr.getLeft(), item); 		//在左子树递归
        }
        else if(item > ptr.getData()){
            if(ptr.getRight() == null){
                BiTreeNode temp = new BiTreeNode(item); //生成新结点
                temp.setParent(ptr); //把ptr结点设为temp结点的父结点
                ptr.setRightChild(temp); //把temp结点设为ptr结点的右孩子结点
            }
            else insert(ptr.getRight(), item); 		//在右子树递归
        }
        return;
    }

}