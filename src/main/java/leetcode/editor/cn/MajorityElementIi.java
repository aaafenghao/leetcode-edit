//给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。 
//
// 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: [3] 
//
// 示例 2: 
//
// 输入: [1,1,1,3,3,2,2,2]
//输出: [1,2] 
// Related Topics 数组

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementIi {
    public static void main(String[] args) {
        Solution solution = new MajorityElementIi().new Solution();
        int[] array = new int[]{1,1,1,3,3,2,2,2};
        List<Integer> list = solution.majorityElement(array);
        list.forEach(System.out::println);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 摩尔投票法
    //大于n/3的话,最多有两个候选人
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> results = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return results;
        }
        int conditionA = nums[0];
        int conditionB = nums[1];
        int countA = 0;
        int countB = 0;
        for (int num:nums){
            if(num == conditionA){
                countA++;
                continue;
            }
            if(num == conditionB){
                countB++;
                continue;
            }
            //检查是否有票数为0的情况
            if(countA == 0){
                conditionA = num;
                countA++;
                continue;
            }
            if(countB == 0){
                conditionB = num;
                countB++;
                continue;
            }
            //当前元素不投AB的话,AB的票数减1
            countA--;
            countB--;
        }
        countA = 0;
        countB = 0;
        for (int num:nums){
            if(conditionA == num){
                countA++;
            } else if (conditionB == num){
                countB++;
            }
        }
        if(countA > nums.length/3){
            results.add(conditionA);
        }
        if(countB > nums.length/3){
            results.add(conditionB);
        }

        return results;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}