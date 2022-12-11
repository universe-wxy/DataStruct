package Question1;

public class SingleList implements List {
    Node head;
    Node current;
    int size;

    SingleList() {
        head = current = new Node(null);
        head.setNext(head);
    }

    public Node index(int i) throws Exception {
        if (i < -1 || i > size - 1)
            throw new Exception("参数错误");
        if (i == -1) {
            current = head;
            return current;
        }
        current = head.next;
        for (int j = 0; j < i && current != head; j++)
            current = current.next;
        return current;
    }

    @Override
    public void insert(int i, Object obj) throws Exception {
        if (i < 0 || i > size) {
            throw new Exception("参数错误");
        }
        index(i - 1);
        current.setNext(new Node(obj, current.next));
        size++;
    }

    @Override
    public Object delete(int i) throws Exception {
        if (size == 0)
            throw new Exception("链表已空，无法删除");
        index(i - 1);
        Object obj = current.next.data;
        current.setNext(current.next.next);
        size--;
        return obj;
    }

    public Object delete(Node node) throws Exception {
        for (int i = 0; i < size; i++) {
            index(i);
            if (current == node) {
                Object obj = current.data;
                index(i - 1);
                current.setNext(current.next.next);
                size--;
                return obj;
            }
        }
        throw new Exception("Delete A Wrong Node");
    }

    @Override
    public Object getData(int i) throws Exception {
        if (i < -1 || i > size - 1)
            throw new Exception("参数错误");
        index(i);
        return current.getElement();
    }
}
