package com.example;//编写一个函数来查找字符串数组中的最长公共前缀。

/**
 * @Description: 最长公共前缀
 *
//
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//
// 示例 2：
//
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
// Related Topics 字符串 👍 1803 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
 */
class LongestCommonPrefix_14 {

    /**
     * @Description: 找到最长公共位置, substr
     * 执行耗时:1 ms,击败了72.52% 的Java用户
     * 内存消耗:36.4 MB,击败了71.35% 的Java用户
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length < 1){
            return "";
        }
//        最终公共字符串都不可能超过第一个的范围
        int length = strs[0].length();
        final int count = strs.length;

        for (int i = 0; i < length; i++) {
//            获取当前位置字符
            final char c = strs[0].charAt(i);
//            比较后续字符串中相同位置字符是否相同
            for (int j = 1; j < count; j++) {
//                如果当前j字符串长度达到了i的位置, 则没必要继续比较, 该字符串比较短
               if(strs[j].length() == i || strs[j].charAt(i) != c){
                   return strs[0].substring(0, i) ;
               }
            }
        }
        return strs[0];
    }

    /**
     * @Description: 找到最短长度,分别比较每一位是否完全相同, append,拼接
     * 执行耗时:1 ms,击败了72.52% 的Java用户
     * 内存消耗:36.3 MB,击败了80.78% 的Java用户
     */
    public String longestCommonPrefix1(String[] strs) {

//        从头到尾, 存在strs.size个，才是公共字符
//        以最短的字符串长度位数比较, charAt

//输入：strs = ["flower","flow","flight"]
//输出："fl"

        // 找最短长度
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            if(str.length() < 1){
                minLen = 0;
                break;
            }else if (str.length() < minLen) {
                minLen = str.length();
            }
        }
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            final char c = strs[0].charAt(i);
            boolean flag = true;
//            每一位都等于上一位字符,则有效, 否则结束退出
            for (String str : strs) {
                if(c != str.charAt(i)){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                break;
            }else{
                builder.append(c);
            }
        }

        return builder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
