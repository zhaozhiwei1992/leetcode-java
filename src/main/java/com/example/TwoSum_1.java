package com.example;

import java.util.HashMap;

/**
 * @Description: 两数之和
 * //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
 * //
 * // 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * //
 * // 你可以按任意顺序返回答案。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：nums = [2,7,11,15], target = 9
 * //输出：[0,1]
 * //解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：nums = [3,2,4], target = 6
 * //输出：[1,2]
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //输入：nums = [3,3], target = 6
 * //输出：[0,1]
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 2 <= nums.length <= 10⁴
 * // -10⁹ <= nums[i] <= 10⁹
 * // -10⁹ <= target <= 10⁹
 * // 只会存在一个有效答案
 *
 */
class TwoSum_1 {

    /**
     * @data: 2021/10/4-下午6:47
     * @User: zhaozhiwei
     * @method: twoSum
      * @param nums :
     * @param target :
     * @return: int[]
     * @Description: 通过map优化, 单层循环
     * 执行耗时:1 ms,击败了99.47% 的Java用户
     * 内存消耗:38.5 MB,击败了75.14% 的Java用户
     */
    public int[] twoSum(int[] nums, int target) {

//        存储变量和索引映射
        final HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
//            根据key是否为目标target-当前值来判断, 首次肯定不存在, map.key记录遍历过数字索引
            if(hashMap.containsKey(target - nums[i])){
                return new int[]{hashMap.get(target - nums[i]), i};
            }else{
                hashMap.put(tmp, i);
            }
        }
        return null;
    }

    /**
     * @data: 2021/10/4-下午6:46
     * @User: zhaozhiwei
     * @method: twoSum1
      * @param nums :
     * @param target :
     * @return: int[]
     * @Description: 描述
     * 执行耗时:115 ms,击败了5.01% 的Java用户
     * 内存消耗:38.5 MB,击败了60.46% 的Java用
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
               if(i != j && nums[i] + nums[j] == target) {
                   return new int[]{i, j};
               }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,5,11};
        final int[] ints = new TwoSum_1().twoSum(nums, 10);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}