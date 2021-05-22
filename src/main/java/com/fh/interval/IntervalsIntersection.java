package com.fh.interval;

import java.util.ArrayList;
import java.util.List;

/**
 * 区间交集
 */
public class IntervalsIntersection {

    public static void main(String[] args) {

    }

    public void intervalIntersection(List<Node> a,List<Node> b){
        int i=0,j=0;
        List<Node> res = new ArrayList<>();
        while (i<a.size() && j<b.size()){
            Node A = a.get(i);
            Node B = b.get(j);
            //存在交集的 a1 a2 b1 b2
            //不存在交集的情况 a2<b1 or b2<a1
            //a2>=b1 && b2>=a1
            if(A.end >= B.start && B.end >= A.start){
                res.add(new Node(Math.max(A.start,B.start),Math.min(A.end,B.end)));
            }
            if(B.end < A.end){
                j+=1;
            }else{
                i+=1;
            }
        }
    }

    class Node{
        public int start;
        public int end;

        public Node(int start,int end){
            this.start = start;
            this.end = end;
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
