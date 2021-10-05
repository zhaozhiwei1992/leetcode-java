package com.example;//给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 
//
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// 
//// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：2, nums = [1,2]
//解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,1,1,1,2,2,3,3,4]
//输出：5, nums = [0,1,2,3,4]
//解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3 * 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 已按升序排列 
// 
//
// 
// Related Topics 数组 双指针 👍 2243 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @Description: 删除重复项
 */
class RemoveDuplicates_26 {

    /**
     * @Description:
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:39.8 MB,击败了53.64% 的Java用户
     *
     * 利用索引指针处理, 相邻重复
     * 数组；排序；双指针；
     * 用双指针，一个指针从头到尾遍历，另一个始终指示当前没有重复的元素最后一个；
     */
    public int removeDuplicates(int[] nums) {

//      当前未重复的指针下标, 首次为0
        int prev = 0;

        for (int i = 1; i < nums.length; i++) {
//            数字[0,0,0,1,1]
//            一直找到不相同的, 将不相同的赋值过来
            if(nums[prev] != nums[i]){
                prev ++;
                nums[prev] = nums[i];
            }
        }
        return prev+1;
    }

    /**
     * @data: 2021/10/5-下午4:40
     * @User: zhaozhiwei
     * @method: removeDuplicates
      * @param nums :
     * @return: int
     * @Description:
     * 执行耗时:7 ms,击败了5.05% 的Java用户
     * 内存消耗:39.2 MB,击败了98.68% 的Java用户
     *
     * TreeSet去重并不乱序
     * 处理后重新赋值给nums
     */
    public int removeDuplicates2(int[] nums) {

//        放入map, 只留key
        final TreeSet<Integer> integers = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
           integers.add(nums[i]);
        }

        final Object[] objects = integers.toArray();
        for (int i = 0; i < objects.length; i++) {
            nums[i] = Integer.parseInt(objects[i].toString());
        }

        return integers.size();
    }

    public static void main(String[] args) {
       int[] nums = new int[]{-3,-1,0,0,0,3,3};
        final int i = new RemoveDuplicates_26().removeDuplicates(nums);
        System.out.println(i);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
