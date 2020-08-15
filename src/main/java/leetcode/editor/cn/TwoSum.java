//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表

package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        int[] array = new int[]{3,3};int target = 6;
        int[] ints = solution.twoSum1(array, target);
        Arrays.stream(ints).forEach(item ->{
            System.out.println(item);
        });
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //假设只有一组对应数据
        Map<Integer, List<Integer>> data = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int item = nums[i];
            if(data.containsKey(item)){
                List<Integer> list = data.get(item);
                list.add(i);
                data.put(item,list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                data.put(item,list);
            }
        }
        for(int i=0;i<nums.length;i++){
            int tar = target - nums[i];
            if(data.containsKey(tar)){
                List<Integer> list = data.get(tar);
                int j = i;
                list.stream().filter(item ->item.intValue() != j).collect(Collectors.toList());
                return new int[]{i,1};
            }
        }
        throw new RuntimeException("no");
        
    }

        public int[] twoSum1(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement) && map.get(complement) != i) {
                    return new int[] { i, map.get(complement) };
                }
            }
            throw new IllegalArgumentException("No two sum solution");
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}