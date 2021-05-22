package com.fh;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 调度考生座位
 *
 *  需要保证每个考生里的离的最远
 *
 *  将学生抽象成线段,可以简单的用一个大小为2的数组表示
 *   需要找到最长线段
 *   需要去除线段
 *   增加线段
 *
 */
public class SchedulingOfCandidates {


    class ExamRoom{
        //将端点p映射到以p为左端点的线段
        private Map<Integer,int[]> startMap;
        //将端点p映射到以p为右端点的线段
        private Map<Integer,int[]> endMap;
        //根据线段长度从小到大存放所有线段
        private TreeSet<int[]> pq;

        private int N;


        public ExamRoom(int n){
            this.N = n;
            startMap = new HashMap<>();
            endMap = new HashMap<>();
            pq = new TreeSet<>((a,b) ->{
                int dista = distance(a);
                int distb = distance(b);
                if(dista == distb){
                    return b[0] - a[0];
                }
                return dista - distb;
            });
            addInterval(new int[]{-1,N});

        }

        //增加线段
        public void  addInterval(int[] intv){
            pq.add(intv);
            startMap.put(intv[0],intv);
            endMap.put(intv[1],intv);
        }

        //删除线段
        public void removeInterval(int[] intv){
            pq.remove(intv);
            startMap.remove(intv[0]);
            endMap.remove(intv[1]);
        }
        //计算一个线段的长度
        private int distance(int[] intv){
            int x = intv[0];
            int y = intv[1];
            if(x == -1) return y;
            if(y == N) return N-1-x;
            return (y-x)/2;
        }


        public int seat(){
            int[] last = pq.last();
            int x = last[0];
            int y = last[1];
            int seat;
            if(x == -1){
                seat = 0;
            }else if (y == N){
                seat = N - 1;
            }else{
                seat = (y-x)/2 + x;
            }
            int[] left = new int[]{x,seat};
            int[] right = new int[]{seat,y};
            removeInterval(last);
            addInterval(left);
            addInterval(right);
            return seat;
        }

        public void leave(int p){
            int[] ints = startMap.get(p);
            int[] ints1 = endMap.get(p);
            int[] merge = new int[]{ints[0],ints1[1]};
            removeInterval(ints);
            removeInterval(ints1);
            addInterval(merge);
        }
    }
}
