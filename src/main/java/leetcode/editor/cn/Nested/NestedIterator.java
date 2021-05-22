package leetcode.editor.cn.Nested;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    public LinkedList<NestedInteger> list;

    public NestedIterator(List<NestedInteger> list){
        this.list = new LinkedList(list);
    }


    @Override
    public boolean hasNext() {
        while (!list.isEmpty() && !list.get(0).isInteger()){//是Integer的时候循环结束
            List<NestedInteger> first = this.list.remove(0).getList();
            for (int i = first.size()-1; i >=0 ; i--) {
                list.addFirst(first.get(i));
            }
        }
        return !list.isEmpty();
    }

    @Override
    public Integer next() {
        return list.remove(0).getInteger();
    }
}
