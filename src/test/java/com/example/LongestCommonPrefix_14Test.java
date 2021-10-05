package com.example;

import junit.framework.Assert;
import junit.framework.TestCase;

public class LongestCommonPrefix_14Test extends TestCase {

    public void testLongestCommonPrefix() {
        final LongestCommonPrefix_14 longestCommonPrefix_14 = new LongestCommonPrefix_14();
        final String s = longestCommonPrefix_14.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        Assert.assertEquals("fl", s);
        Assert.assertEquals("", longestCommonPrefix_14.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        Assert.assertEquals("", longestCommonPrefix_14.longestCommonPrefix(new String[]{""}));
        Assert.assertEquals("a", longestCommonPrefix_14.longestCommonPrefix(new String[]{"ab", "a"}));
    }
}