//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        int[] array = new int[]{1,2,3};
//        List<List<Integer>> subsets = solution.subsets(array);
        List<List<Integer>> subsets = solution.subsets1(array);
        subsets.forEach(item ->{
            System.out.println("----");
            item.forEach(target -> System.out.print(target));
            System.out.println("----");
        });

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //计算所有的子集且不能重复
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        for(int i:nums){
            List<List<Integer>> sub = new ArrayList<>();
            for (List<Integer> tar:results){
                sub.add(new ArrayList<Integer>(tar){{add(i);}});
            }
            for (List<Integer> item:sub){
                results.add(item);
            }
        }
        return results;
    }

    //回溯--探索所有的可能性找到解决方法
    //归去来兮
    //查找重复性
    public List<List<Integer>> subsets1(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        backTrack(0,nums,res,new ArrayList<>());
        return res;
    }

    private void backTrack(int i,int[] nums,List<List<Integer>> res,ArrayList<Integer> tmp){
        res.add(new ArrayList<>(tmp));
        for (int j=i;j<nums.length;j++){
            tmp.add(nums[j]);
            backTrack(j+1,nums,res,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}