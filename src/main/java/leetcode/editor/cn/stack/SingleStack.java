package leetcode.editor.cn.stack;

import java.util.Stack;

/**
 * 单调栈的使用
 */
public class SingleStack {

    public static void main(String[] args) {
        //2 1 2 4 3
        //4 2 4 -1 -1
    }

    public Integer[] nextGreaterElement(Integer[] nums){
        Integer[] ans = new Integer[nums.length];
        Stack<Integer> s = new Stack<>();
        for (int i = nums.length-1; i >=0 ; i--) {//倒着向栈中存放
            while (!s.isEmpty() && s.peek() <= nums[i]){//判定个子高矮
                s.pop();//矮个子起开
            }
            ans[i] = s.isEmpty()?-1:s.peek();//元素后的第一个高个子
            s.push(nums[i]);//进队,接受之后的身高判定
        }
        return ans;
    }

}
