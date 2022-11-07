package com.example;//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：nums = [-1]
//输出：-1
// 
//
// 示例 5： 
//
// 
//输入：nums = [-100000]
//输出：-100000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治 动态规划 👍 3826 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class MaxSubArray {

    /**
     * @Description: 思路:
     * 连续子数组, 并且和最大, 暴力
     * https://zh.wikipedia.org/wiki/%E6%9C%80%E5%A4%A7%E5%AD%90%E6%95%B0%E5%88%97%E9%97%AE%E9%A2%98
     *
     * 执行耗时:1 ms,击败了91.61% 的Java用户
     * 内存消耗:48.8 MB,击败了5.05% 的Java用户
     *
     */
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, curSum = 0;
//      求所有数和最大, 每次尽量最大, 当前的最大不一定最大，还要与上一次的比较
        for (int num : nums) {
            curSum = Math.max(num + curSum, num);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;

    }

    public static void main(String[] args) {
        //输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
        final int i = new MaxSubArray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
