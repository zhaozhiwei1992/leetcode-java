package com.example;//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。

/**
 * @Title: Palindrome_9
 * @Package com/example/Palindrome_9.java
 * @Description: 回文数, 配合整数反转 + 相等
 *
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
//
//
//
// 示例 1：
//
//
//输入：x = 121
//输出：true
//
//
// 示例 2：
//
//
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//
//
// 示例 3：
//
//
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
//
//
// 示例 4：
//
//
//输入：x = -101
//输出：false
//
//
//
//
// 提示：
//
//
// -2³¹ <= x <= 2³¹ - 1
//
//
//
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？
// Related Topics 数学 👍 1634 👎 0


 * @author zhaozhiwei
 * @date 2021/10/4 下午9:26
 * @version V1.0
 */
class Palindrome_9 {

    /**
     * @Description: 描述
     * 执行耗时:8 ms,击败了100.00% 的Java用户
     * 内存消耗:37.8 MB,击败了68.03% 的Java用户
     */
    public boolean isPalindrome(int x) {

//        负数不是回文
        if(x < 0){
            return false;
        }

//        数字反转
        int result = 0;
        int tmp = x;
        while (x != 0){
           result = result*10 + x%10;
           x /= 10;
        }
//        比较是否相等
        return result == tmp;
    }

    public static void main(String[] args) {
        final boolean palindrome = new Palindrome_9().isPalindrome(121);
        System.out.println(palindrome);
    }
}
