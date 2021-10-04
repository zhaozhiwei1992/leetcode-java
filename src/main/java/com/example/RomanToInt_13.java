package com.example;//罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

/**
 * @Title: RomanToInt_13
 * @Package com/example/RomanToInt_13.java
 * @Description: 罗马数字转整数
 *
//
//
//字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V +
//II 。
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
//
//
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
//
//
// 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
//
//
//
// 示例 1:
//
//
//输入: "III"
//输出: 3
//
// 示例 2:
//
//
//输入: "IV"
//输出: 4
//
// 示例 3:
//
//
//输入: "IX"
//输出: 9
//
// 示例 4:
//
//
//输入: "LVIII"
//输出: 58
//解释: L = 50, V= 5, III = 3.
//
//
// 示例 5:
//
//
//输入: "MCMXCIV"
//输出: 1994
//解释: M = 1000, CM = 900, XC = 90, IV = 4.
//
//
//
// 提示：
//
//
// 1 <= s.length <= 15
// s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
// 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
// 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
// IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
// 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
//
// Related Topics 哈希表 数学 字符串 👍 1493 👎 0


 * @author zhaozhiwei
 * @date 2021/10/4 下午10:04
 * @version V1.0
 */
class RomanToInt_13 {

    /**
     * @Description: 描述
     * 执行耗时:4 ms,击败了99.47% 的Java用户
     * 内存消耗:38.5 MB,击败了76.36% 的Java用户
     *
     * 解题思路,
     * 前提: 如IV这种前置, 做减法的只可能存在一个字母, 不会存在IIV表示3
     * 特殊情况做if判断, 并且将其代表值作为负数,累加即可
     */
    public int romanToInt(String s) {
        //I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
        int result = 0;
        s+="0";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
//        IXC放左边只能放一个,表示特殊含义, 可以将改值乘负数
            final char tmpChar = chars[i];
            if('I' == tmpChar ){
                if('V' == (chars[i+1]) || 'X' == (chars[i+1])){
                    result += -1;
                }else{
                    result += 1;
                }
            }else if('V' == (tmpChar)){
                result += 5;
            }else if('X' == (tmpChar)){
                if('L' == (chars[i+1]) || 'C' == (chars[i+1])){
                    result += -10;
                }else{
                    result += 10;
                }
            }else if('L' == (tmpChar)){
                result += 50;
            }else if('C' == (tmpChar)){
                if('D' == (chars[i+1]) || 'M' == (chars[i+1])){
                    result += -100;
                }else{
                    result += 100;
                }
            }else if('D' == (tmpChar)){
                result += 500;
            }else if('M' == (tmpChar)){
                result += 1000;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        final int i = new RomanToInt_13().romanToInt("IV");
        System.out.println(i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
