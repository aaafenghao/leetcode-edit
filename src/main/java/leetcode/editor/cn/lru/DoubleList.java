package leetcode.editor.cn.lru;

public class DoubleList {
    //头尾虚节点
    public Node head,tail;
    //链表大小
    public int size;

    public DoubleList(){
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    //head-->node-->tail

    //在链表尾部添加
    public void addLast(Node x){
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size++;
    }
    //删除指定节点
    public void remove(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    //删除链表中的第一个节点
    public Node removeFirst(){
        if(head == tail){
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }

    public int size(){
        return size;
    }
}
