package com.example;
/**
 * @Title: Reverse_7
 * @Package com/example/Reverse_7.java
 * @Description: 整数反转
 *
//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
//
//
// 示例 1：
//
//
//输入：x = 123
//输出：321
//
//
// 示例 2：
//
//
//输入：x = -123
//输出：-321
//
//
// 示例 3：
//
//
//输入：x = 120
//输出：21
//
//
// 示例 4：
//
//
//输入：x = 0
//输出：0
//
//
//
//
// 提示：
//
//
// -2³¹ <= x <= 2³¹ - 1
//
// Related Topics 数学 👍 3123 👎 0


 * @author zhaozhiwei
 * @date 2021/10/4 下午9:16
 * @version V1.0
 */
class Reverse_7 {

    /**
     * @Description: 描述
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:35.2 MB,击败了97.70% 的Java用户
     */
    private int reverse(int x) {

//        边界返回0
        if (x == 0) {
            return 0;
        }

        // 注意这里为long类型，防止int类型的则行数反转后溢出
        long res = 0;
        // 反转整数
        while(x != 0){
            // x%10获取到当前循环x最低位, 并且通过前一次*10, 将当前最低位置后
            res = res * 10 + x % 10;
            // 在原数字上移除最低位
            x /= 10;
        }
        // 判断是否溢出，若溢出则返回0
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
            return 0;
        }
        return (int)res;

    }

    /**
     * @Description: 描述
     * 执行耗时:13 ms,击败了5.25% 的Java用户
     * 	内存消耗:38.2 MB,击败了5.01% 的Java用
     */
    public int reverse1(int x) {

//        边界返回0
        if (x ==0 || x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
            return 0;
        }

//      转成string, 倒序
        final StringBuilder builder = new StringBuilder(String.valueOf(x).replace("-", "")).reverse();
//  首位为0要去掉
        final String s = builder.toString().replaceAll("^0*", "");

//  正数负数与原来一致
        try{
            if(x > 0){
                return Integer.parseInt(s);
            }else{
                return -Integer.parseInt(s);
            }
        }catch (Exception e){
            return 0;
        }
    }

    public static void main(String[] args) {
        final int reverse = new Reverse_7().reverse(129);
        System.out.println(reverse);
    }

}
