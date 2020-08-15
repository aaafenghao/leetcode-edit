package leetcode.editor.cn.lru;

import java.util.HashMap;
import java.util.Map;

public class Lru {
    //key-->Node
    private Map<Integer,Node> map;
    //node-->node-->node
    private DoubleList doubleList;

    private int cap;

    public Lru(int cap){
        this.cap = cap;
        map = new HashMap<>();
        doubleList = new DoubleList();
    }

    private void makeRecently(int key){
        Node node = map.get(key);
        doubleList.remove(node);
        doubleList.addLast(node);
    }

    private void addRecently(int key,int val){
        Node node = new Node(key,val);
        map.put(key,node);
        doubleList.addLast(node);
    }

    private void deleteKey(int key){
        Node node = map.get(key);
        doubleList.remove(node);
        map.remove(key);
    }

    private void removeLeastRecently(){
        Node node = doubleList.removeFirst();
        int key = node.key;
        map.remove(key);
    }
}
