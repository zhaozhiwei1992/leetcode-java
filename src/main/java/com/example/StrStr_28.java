package com.example;//实现 strStr() 函数。
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：haystack = "", needle = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 字符串匹配 👍 1057 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class StrStr_28 {

    /**
     * @Description: KMP算法
     * 执行耗时:5 ms,击败了86.59% 的Java用户
     * 内存消耗:38.5 MB,击败了49.12% 的Java用户
     */
    public int strStr3(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
//        pi记录needle字符串的 前缀函数值(含义见notes/算法/KMP算法)
//        如字符串为aaa, 则pi=[0,1,2]
//        i为什么从1开始? π(0)=0，因为 a 没有真前缀和真后缀，根据规定为 0（可以发现对于任意字符串 π(0)=0 必定成立）
//        意味着单独一个字符的函数值肯定为0, 没有计算必要，从1开始即可

//        第一部分是求 needle 部分的前缀函数，我们需要保留这部分的前缀函数值。
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }

//        第二部分是求 haystack 部分的前缀函数，
//        我们无需保留这部分的前缀函数值，只需要用一个变量记录上一个位置的前缀函数值即可。
//        当某个位置的前缀函数值等于 m 时，说明我们就找到了一次字符串 needle在字符串 haystack中的出现
//        （因为此时真前缀恰为字符串 needle，真后缀为以当前位置为结束位置的字符串 haystack的子串）
//        ，我们计算出起始位置，将其返回即可。
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
//               if (innerIndex > 0) {
//                    如果匹配成功过, 在哪里跌倒在哪里爬起来, 回到最初(当前位置-匹配的长度)重新遍历,可能部分匹配
//                    i -= innerIndex;
//                }
//                innerIndex = 0;
//                这里意思也是回退指针，类似innerIndex=0, 但是实现更骚, 利用的kmp的思想，使得回溯尺度更 智能 (牛皮), 不用到解放前
//                TODO 为什么用了kmp会更智能,?
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
//                这里的j可以类比com.example.StrStr_28.strStr中的innerIndex, 相同即递增, 跟i同时进步
                j++;
            }
            if (j == m) {
//             i - m + 1? 找到子串后i的位置已经包含了m的长度,此时说明匹配了完整字符串, 所以要回到匹配的最初作为下标
//             等同com.example.StrStr_28.strStr中的意思, 外层循环去推动比较, j累加
                return i - m + 1;
            }
        }
        return -1;
    }

    /**
     * @Description: 描述
     * 执行耗时:381 ms,击败了56.27% 的Java用户
     * 内存消耗:38.1 MB,击败了91.49% 的Java用户
     */
    public int strStr2(String haystack, String needle) {
       return haystack.indexOf(needle);
    }

    /**
     * @Description: 暴力方式
     * 执行耗时:1647 ms,击败了8.87% 的Java用户
     * 内存消耗:38.2 MB,击败了84.38% 的Java用户
     * 每次扫描,需要将内部m(needle.length)个字符全部比较,一个不匹配则跳过
     * 通过i + j的方式,保证从当前i开始,随着j递增比较各个字符
     * {@see https://leetcode-cn.com/problems/implement-strstr/solution/shi-xian-strstr-by-leetcode-solution-ds6y/}
     */
    public int strStr1(String haystack, String needle) {
        if ("".equals(needle) || needle == null) {
            return 0;
        }

        if (haystack.length() < needle.length()) {
            return -1;
        }

        final int m = needle.length();

//        i + m <= haystack.length(), 如果到了这里还没有匹配, 后续字符长度不够，没有比较的意义了
        for (int i = 0; i + m <= haystack.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
//                有一个不相等就跳过, 否则依次比较后续字符
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @Description: 实现strStr
     * 思路: 外层内层同时推进, 外层循环,内层游标
     * <p>
     * 实现java String indexOf
     * 执行耗时:476 ms,击败了34.40% 的Java用户
     * 内存消耗:38.6 MB,击败了26.56% 的Java用
     */
    public int strStr(String haystack, String needle) {
        if ("".equals(needle) || needle == null) {
            return 0;
        }

        if (haystack.length() < needle.length()) {
            return -1;
        }

//输入：haystack = "hello", needle = "ll"
//输出：2

        final char[] hayStackChars = haystack.toCharArray();
        final char[] needleChars = needle.toCharArray();

//        比较相同字符组,
//        flag标识全部匹配标志, 匹配的索引长度innerIndex等于字符长度,表示都比较过了,即flag==true
        boolean flag = false;
//        第一个相同, 后续也必须相同, 记录needle上次相同的索引, 如果下个比较不同重置
//        只有第一个相同比较后边的才有意义
        for (int i = 0, innerIndex = 0; i < hayStackChars.length; i++) {

//          每次循环比较一次即可, 不同就回到适当位置(调整i)重新遍历
            if (hayStackChars[i] == needleChars[innerIndex]) {
                ++innerIndex;
                if (innerIndex == needleChars.length) {
                    flag = true;
                }
            } else {
                if (innerIndex > 0) {
//                    如果匹配成功过, 在哪里跌倒在哪里爬起来, 回到最初(当前位置-匹配的长度)重新遍历,可能部分匹配
                    i -= innerIndex;
                }
                innerIndex = 0;
            }
//
            if (flag) {
                return i - needleChars.length + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        final int i = new StrStr_28().strStr("mississippi", "issip");
        final int i = new StrStr_28().strStr3("hello", "ll");
//        final int i = new StrStr_28().strStr("aaa", "aaaa");
//        final int i = new StrStr_28().strStr("bbbbababbbaabbba", "abb");
//        final int i = new StrStr_28().strStr3("aaa", "aaa");
        System.out.println(i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
