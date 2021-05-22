package com.fh.interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 区间合并
 */
public class IntervalMerge {

    public List<Node> merge(List<Node> intervals){
        List<Node> res = new ArrayList<>();
        if(intervals == null || intervals.isEmpty()){
            return res;
        }
        intervals.sort(Comparator.comparingInt(a -> a.start));
        res.add(new Node(0,0));
        for (int i = 0; i < intervals.size(); i++) {
            Node current = intervals.get(i);
            Node last = res.get(res.size() - 1);
            if(current.start < last.end){
                last.end = Math.max(current.end,last.end);
            }else{
                res.add(current);
            }
        }
        return res;
    }

    class Node{
        public int start;
        public int end;

        public Node(int start,int end){
            this.start = start;
            this.end  = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }
}
