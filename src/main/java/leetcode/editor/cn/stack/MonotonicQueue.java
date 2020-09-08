package leetcode.editor.cn.stack;

import java.util.Deque;
import java.util.LinkedList;

public class MonotonicQueue {

    private Deque<Integer> data = new LinkedList<>();

    public void push(int n){
        while (!data.isEmpty() && data.peekLast() < n){
            data.pollLast();
        }
        data.addLast(n);
    }

    public int max(){
        return data.getFirst();
    }

    public void pop(int n){
        if(!data.isEmpty() && data.getFirst() == n){
            data.pollFirst();
        }
    }

    public static void main(String[] args) {

    }

    Integer[] maxSlidingWindow(Integer[] nums,int k){
        MonotonicQueue window = new MonotonicQueue();
        Integer[] res = new Integer[nums.length];
        for (int i = 0; i <nums.length ; i++) {
            if(i < k-1){
                window.push(i);
            }else{
                window.push(i);
                res[i] = window.max();
                window.pop(nums[i-1+1]);
            }
        }
        return res;
    }
}
